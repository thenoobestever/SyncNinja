package SyncNinjaPackage.SyncNinja.Services;

import SyncNinjaPackage.SyncNinja.Models.Directory;
import SyncNinjaPackage.SyncNinja.Repositories.DirectoryRepository;
import SyncNinjaPackage.SyncNinja.ResourceBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DirectoryService {
    private final DirectoryRepository directoryRepository;

    @Autowired
    public DirectoryService(DirectoryRepository directoryRepository) {
        this.directoryRepository = directoryRepository;
    }

    public void saveDirectory(String path){
        Optional<Directory> directory = directoryRepository.findById(path);
        if (directory.isPresent()){
            System.out.println(ResourceBundle.DIRECTORY_ALREADY_INITIALIZED.getMessage());
        }
        else{
            Directory new_directory = new Directory(path);
            directoryRepository.save(new_directory);
        }

    }
}
