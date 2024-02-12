package SyncNinjaPackage.syncNinja.service;

import SyncNinjaPackage.syncNinja.stateTree.repository.StateDirectoryRepository;
import SyncNinjaPackage.syncNinja.stateTree.repository.StateFileRepository;
import SyncNinjaPackage.syncNinja.stateTree.models.StateDirectory;
import SyncNinjaPackage.syncNinja.util.Fetcher;
import SyncNinjaPackage.syncNinja.util.ResourceBundleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class StatusService {
    private final StateDirectoryRepository stateDirectoryRepository;
    private final ResourceMessagingService resourceMessagingService;
    private final StateFileRepository stateFileRepository;

    @Autowired
    public StatusService(StateDirectoryRepository stateDirectoryRepository, ResourceMessagingService resourceMessagingService, StateFileRepository stateFileRepository) {
        this.stateDirectoryRepository = stateDirectoryRepository;
        this.resourceMessagingService = resourceMessagingService;
        this.stateFileRepository = stateFileRepository;
    }

    public List<String> getUntrackedFiles(List<String> pathList , String directoryPath){
        List<String> untracked = new ArrayList<>();
        StateDirectory stateDirectoryOptional = stateDirectoryRepository.findById(directoryPath).orElse(null);
        if(stateDirectoryOptional.getInternalNodes().isEmpty()){
            return pathList;
        }
        else{
            for(int i = 0 ; i<pathList.size() ; i++){
                String path = pathList.get(i);
                if(stateFileRepository.findById(path).orElse(null)==null){
                    untracked.add(path);
                }
                /*else{
                    code will be done after the staging area is done (to check in staging area
                    and also to check if any tracked file was modified)
                }*/
            }
        }
        return untracked;
    }
    public void getStatus(String path) throws IOException {
        Path mainDirectory = Paths.get(path);
        List<String> allFilesInDirectory = Fetcher.pathList(mainDirectory);
        List<String> tracked = new ArrayList<>();
        List<String> untracked = getUntrackedFiles(allFilesInDirectory, path);
        String greenColor = "\u001B[32m";
        String redColorCode = "\u001B[31m";
        String resetColorCode = "\u001B[0m";
        System.out.println(resourceMessagingService.getMessage(ResourceBundleEnum.FILES_READY_TO_BE_COMMITED));
        for (int i = 0; i <tracked.size() ; i++){
            System.out.println(greenColor+ "\t" +tracked.get(i) + resetColorCode);
        }
        System.out.println("\n" + "\n");
        System.out.println(resourceMessagingService.getMessage(ResourceBundleEnum.UNTRACKED_FILES) + "\n");
        for (int i = 0; i <untracked.size() ; i++){
            System.out.println(redColorCode+ "\t"+untracked.get(i) + resetColorCode);
        }
        System.out.println();

    }
}
