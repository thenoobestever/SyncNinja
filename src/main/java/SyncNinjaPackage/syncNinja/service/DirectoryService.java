package SyncNinjaPackage.syncNinja.service;

import SyncNinjaPackage.syncNinja.model.Branch;
import SyncNinjaPackage.syncNinja.model.Directory;
import SyncNinjaPackage.syncNinja.repository.DirectoryRepository;
import SyncNinjaPackage.syncNinja.util.ResourceBundleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<Directory> OptionalDirectory = directoryRepository.findById(path);
        if (OptionalDirectory.isPresent()) {
            throw new Exception(resourceMessagingService.getMessage(ResourceBundleEnum.DIRECTORY_ALREADY_INITIALIZED));
        }
        return directoryRepository.save(new Directory(path));
    }

    public void createDirectoryMainBranch(Directory directory, String name) {
        if (directory.getBranch() == null) {
            directory.setBranch(new Branch(name));
            directoryRepository.save(directory);
        }
    }
    public Directory getDirectory(String path) throws Exception {
        Directory directory = directoryRepository.findById(path).orElse(null);
        if(directory == null){
            throw new Exception(resourceMessagingService.getMessage(ResourceBundleEnum.DIRECTORY_NOT_INITIALIZED));
        }
        return directory;
    }


}
