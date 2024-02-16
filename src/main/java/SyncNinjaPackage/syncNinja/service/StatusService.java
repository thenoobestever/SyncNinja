package SyncNinjaPackage.syncNinja.service;

import SyncNinjaPackage.syncNinja.model.StateTreeModel.StateFile;
import SyncNinjaPackage.syncNinja.repository.StateTreeRepository.StateDirectoryRepository;
import SyncNinjaPackage.syncNinja.repository.StateTreeRepository.StateFileRepository;
import SyncNinjaPackage.syncNinja.model.StateTreeModel.StateDirectory;
import SyncNinjaPackage.syncNinja.util.Fetcher;
import SyncNinjaPackage.syncNinja.util.ResourceBundleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
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

    public void currentState(String directoryPath ,List<String> untracked){
        File filePath = new File(directoryPath);
        File filesList[] = filePath.listFiles();
        for(File file :filesList){
            if(file.isDirectory()){
                StateDirectory stateDirectory = stateDirectoryRepository.findById(file.toString()).orElse(null);
                if(stateDirectory==null){
                    currentState(file.toString() , untracked);
                }
                else if (stateDirectory.getLastModified() !=file.lastModified()){
                    currentState(file.toString(),untracked);
                }
            }
            else{
                StateFile stateFile = stateFileRepository.findById(file.toString()).orElse(null);
                if(stateFile==null){
                    untracked.add(file.toString());
                }
                else if(stateFile.getLastModified()!=file.lastModified()){
                    untracked.add(file.toString());
                }
            }
        }

    }
    public Object[] getStatus(String path) throws Exception {
        if(!stateDirectoryRepository.existsById(path)){
            throw new Exception(resourceMessagingService.getMessage(ResourceBundleEnum.DIRECTORY_ALREADY_INITIALIZED, new Object[]{path}));
        }
        List<String> tracked = new ArrayList<>();
        List<String> untracked = new ArrayList<>();
        currentState(path,untracked);
        return new Object[]{tracked,untracked};
    }
}
