package SyncNinjaPackage.syncNinja.service;

import SyncNinjaPackage.syncNinja.model.StateTreeModel.StateDirectory;
import SyncNinjaPackage.syncNinja.model.StateTreeModel.StateFile;
import SyncNinjaPackage.syncNinja.repository.StateTreeRepository.StateFileRepository;
import SyncNinjaPackage.syncNinja.repository.StateTreeRepository.StateDirectoryRepository;
import SyncNinjaPackage.syncNinja.service.ResourceMessagingService;
import SyncNinjaPackage.syncNinja.util.ResourceBundleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
            System.out.println(resourceMessagingService.getMessage(ResourceBundleEnum.FILE_ALREADY_EXISTS, new Object[] {path}));
        }
        else{
            file = new StateFile(path);
            stateFileRepository.save(file);
        }
        return file;
    }

    /*public void generateStateTree(String path){
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
    }*/

    public StateDirectory generateStateDirectoryNode(String path){
        Optional<StateDirectory> file = stateDirectoryRepository.findById(path);
        StateDirectory stateDirectory = null;
        if(file.isPresent()){
            System.out.println(resourceMessagingService.getMessage(ResourceBundleEnum.SUB_DIRECTORY_ALREADY_EXISTS, new Object[]{path}));
        }
        else{
            stateDirectory = new StateDirectory(path);
            stateDirectoryRepository.save(stateDirectory);
        }
        return stateDirectory;

    }


}
