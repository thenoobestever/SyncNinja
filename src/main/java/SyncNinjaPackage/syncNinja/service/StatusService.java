package SyncNinjaPackage.syncNinja.service;

import SyncNinjaPackage.syncNinja.model.StateTreeModel.StateFile;
import SyncNinjaPackage.syncNinja.model.StateTreeModel.StateTree;
import SyncNinjaPackage.syncNinja.repository.StateTreeRepository.StateDirectoryRepository;
import SyncNinjaPackage.syncNinja.repository.StateTreeRepository.StateFileRepository;
import SyncNinjaPackage.syncNinja.model.StateTreeModel.StateDirectory;
import SyncNinjaPackage.syncNinja.util.ResourceBundleEnum;
import org.neo4j.cypherdsl.core.Cypher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.core.Neo4jTemplate;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

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

    public void currentState(File directory, StateDirectory stateDirectory, List<String> untracked) {
        File filesList[] = directory.listFiles();
        Map<String, StateTree> stateTreeMap = stateDirectory.getInternalNodes().stream()
                .collect(Collectors.toMap((stateTree) -> stateTree.getPath(), (stateTree -> stateTree)));

        for (File file: filesList) {
            if (file.isDirectory()) {
                StateDirectory stateDirectoryChild = (StateDirectory) stateTreeMap.get(file.getPath());
                if(stateDirectoryChild == null) {
                    addAllFilesInDirectory(file, untracked);

                } else if (stateDirectoryChild.getLastModified() != file.lastModified()) {
                    currentState(file, stateDirectoryChild, untracked);
                }
            } else {
                StateFile stateFile = (StateFile) stateTreeMap.get(file.getPath());
                if (stateFile == null || stateFile.getLastModified() != file.lastModified()) {
                    untracked.add(file.toString());
                }
            }
        }

    }

    private void addAllFilesInDirectory(File directory, List<String> untracked) {
        for (File file : directory.listFiles()) {
            if (file.isDirectory()) {
                addAllFilesInDirectory(file, untracked);
            } else if (file.isFile()) {
                untracked.add(file.getPath());
            }
        }
    }

    public Object[] getStatus(String path) throws Exception {
        if (!stateDirectoryRepository.existsById(path)) {
            throw new Exception(resourceMessagingService.getMessage(ResourceBundleEnum.DIRECTORY_ALREADY_INITIALIZED, new Object[]{path}));
        }
        List<String> tracked = new ArrayList<>();
        List<String> untracked = new ArrayList<>();

        StateDirectory stateDirectory = stateDirectoryRepository.findById(path).orElse(null);

        currentState(new File(path), stateDirectory, untracked);
        return new Object[]{tracked, untracked};
    }
}
