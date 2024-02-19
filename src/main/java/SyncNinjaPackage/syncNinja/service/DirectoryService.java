package SyncNinjaPackage.syncNinja.service;

import SyncNinjaPackage.syncNinja.model.Branch;
import SyncNinjaPackage.syncNinja.model.Directory;
import SyncNinjaPackage.syncNinja.repository.DirectoryRepository;
import SyncNinjaPackage.syncNinja.util.ResourceBundleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectoryService {
    private final DirectoryRepository directoryRepository;
    private final ResourceMessagingService resourceMessagingService;
    @Autowired
    public DirectoryService(DirectoryRepository directoryRepository, ResourceMessagingService resourceMessagingService) {
        this.directoryRepository = directoryRepository;
        this.resourceMessagingService = resourceMessagingService;
    }

    public Directory createDirectory(String path) throws Exception {
        //Directory directory = directoryRepository.findById(path).orElseThrow(()->
//                new Exception(resourceMessagingService.getMessage(ResourceBundleEnum.DIRECTORY_ALREADY_INITIALIZED,
//                        new Object[]{path})));
        return directoryRepository.save(new Directory(path));
    }

    public void createDirectoryMainBranch(Directory directory, String name) {
        if (directory.getBranch() == null) {
            directory.setBranch(new Branch(name));
            directoryRepository.save(directory);
        }
    }
    public Directory getDirectory(String path) throws Exception {
        return directoryRepository.findById(path).orElseThrow(()->
                new Exception(resourceMessagingService.getMessage(ResourceBundleEnum.DIRECTORY_ALREADY_INITIALIZED,
                        new Object[]{path})));
    }
}
