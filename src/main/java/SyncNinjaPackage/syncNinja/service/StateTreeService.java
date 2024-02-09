package SyncNinjaPackage.syncNinja.service;

import SyncNinjaPackage.syncNinja.model.StateDirectory;
import SyncNinjaPackage.syncNinja.model.StateFile;
import SyncNinjaPackage.syncNinja.model.StateTree;
import SyncNinjaPackage.syncNinja.repository.StateFileRepository;
import SyncNinjaPackage.syncNinja.repository.StateDirectoryRepository;
import SyncNinjaPackage.syncNinja.util.ResourceBundleEnum;
import SyncNinjaPackage.syncNinja.util.SHA256;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StateTreeService {

    private final StateDirectoryRepository stateDirectoryRepository;

    private final ResourceMessagingService resourceMessagingService;
    private final StateFileRepository stateFileRepository;

    @Autowired
    public StateTreeService(StateDirectoryRepository stateDirectoryRepository, ResourceMessagingService resourceMessagingService, StateFileRepository stateFileRepository) {
        this.stateDirectoryRepository = stateDirectoryRepository;
        this.resourceMessagingService = resourceMessagingService;
        this.stateFileRepository = stateFileRepository;
    }

    public StateFile generateStateFileNode(String path) throws IOException {
        Optional<StateFile> optionalFile = stateFileRepository.findById(path);
        StateFile file = null;
        if(optionalFile.isPresent()){
            System.out.println(resourceMessagingService.getMessage(ResourceBundleEnum.FILE_ALREADY_EXISTS));
        }
        else{
            file = new StateFile(path);
            stateFileRepository.save(file);
        }
        return file;
    }

    public void generateStateTree(String path){
        Path mainDirectory = Paths.get(path);
        List<Path> subList = null;
        try {
            subList = Files.walk(mainDirectory)
                    .collect(Collectors.toList());
            {
                for(int i = 0 ; i<subList.size() ; i++){
                    Path file = subList.get(i);
                    if(file.toFile().isDirectory()){
                        StateDirectory child = generateStateDirectoryNode(file.toString());
                        StateDirectory parent = stateDirectoryRepository.findById(file.getParent().toString()).orElse(null);
                        if(parent!=null){
                            parent.addfile(child);
                            stateDirectoryRepository.save(parent);
                        }
                    }
                    else{
                        StateFile child = generateStateFileNode(file.toString());
                        StateDirectory parent = stateDirectoryRepository.findById(file.getParent().toString()).orElse(null);

                        if(parent!=null){
                            parent.addfile(child);
                            stateDirectoryRepository.save(parent);
                        }
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public StateDirectory generateStateDirectoryNode(String path){
        Optional<StateDirectory> file = stateDirectoryRepository.findById(path);
        StateDirectory stateDirectory = null;
        if(file.isPresent()){
            System.out.println(resourceMessagingService.getMessage(ResourceBundleEnum.SUB_DIRECTORY_ALREADY_EXISTS));
        }
        else{
            stateDirectory = new StateDirectory(path);
            stateDirectoryRepository.save(stateDirectory);
        }
        return stateDirectory;

    }

    public void getStatus(String path) throws IOException {
        StateDirectory stateDirectoryOptional = stateDirectoryRepository.findById(path).orElse(null);
        List<String> tracked = new ArrayList<>();
        List<String> untracked = new ArrayList<>();
        if(stateDirectoryOptional!=null){
            Path mainDirectory = Paths.get(path);
            List<Path> subList = Files.walk(mainDirectory)
                    .filter(Files::isRegularFile)
                    .collect(Collectors.toList());

            for(int i= 0 ; i<subList.size() ; i++){
                StateFile stateFile = stateFileRepository.findById(subList.get(i).toString()).orElse(null);
                if(stateFile!=null){
                    String hashValue = SHA256.hashValue(stateFile.getPath());
                    if(hashValue.equals(stateFile.getHashValue())){
                        if(stateFile.getStatus()){
                            tracked.add(stateFile.getPath());
                        }
                        else{
                            untracked.add(stateFile.getPath());
                        }
                    }
                    else{
                        untracked.add(stateFile.getPath());
                    }
                }
                else{
                    untracked.add(stateFile.getPath());
                }



            }
            String redColorCode = "\u001B[31m";
            String resetColorCode = "\u001B[0m";
            System.out.println(resourceMessagingService.getMessage(ResourceBundleEnum.FILES_READY_TO_BE_COMMITED));
            for (int i = 0; i <tracked.size() ; i++){
                System.out.println(tracked.get(i));
            }
            System.out.println("\n" + "\n");
            System.out.println(resourceMessagingService.getMessage(ResourceBundleEnum.UNTRACKED_FILES) + "\n");
            for (int i = 0; i <untracked.size() ; i++){
                System.out.println(redColorCode+ "\t"+untracked.get(i) + resetColorCode);
            }
            System.out.println();
        }
        else{
            System.out.println(resourceMessagingService.getMessage(ResourceBundleEnum.DIRECTORY_NOT_INITIALIZED));
        }
    }
}
