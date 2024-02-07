package SyncNinjaPackage.syncNinja.service;

import SyncNinjaPackage.syncNinja.model.File;
import SyncNinjaPackage.syncNinja.repository.FilesRepository;
import SyncNinjaPackage.syncNinja.util.ResourceBundleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
public class FileService {
    private final FilesRepository filesRepository;
    private final ResourceMessagingService resourceMessagingService;

    @Autowired
    public FileService(FilesRepository filesRepository, ResourceMessagingService resourceMessagingService) {
        this.filesRepository = filesRepository;
        this.resourceMessagingService = resourceMessagingService;
    }

    public File generateFileNode(String path) throws IOException {
        Optional<File> optionalFile = filesRepository.findById(path);
        File file = null;
        if(optionalFile.isPresent()){
            System.out.println(resourceMessagingService.getMessage(ResourceBundleEnum.FILE_ALREADY_EXISTS));
        }
        else{
            file = new File(path);
            filesRepository.save(file);
        }
        return file;
    }

}
