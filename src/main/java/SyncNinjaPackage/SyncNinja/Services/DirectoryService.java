package SyncNinjaPackage.SyncNinja.Services;

import SyncNinjaPackage.SyncNinja.Models.Directory;
import SyncNinjaPackage.SyncNinja.Repositories.DirectoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectoryService {
    private final DirectoryRepository directoryRepository;

    @Autowired
    public DirectoryService(DirectoryRepository directoryRepository) {
        this.directoryRepository = directoryRepository;
    }

    public void saveDirectory(String path){
        Directory directory = new Directory(path);
        directoryRepository.save(directory);
    }
}
