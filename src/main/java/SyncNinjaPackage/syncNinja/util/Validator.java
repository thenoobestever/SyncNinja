package SyncNinjaPackage.syncNinja.util;

import SyncNinjaPackage.syncNinja.model.Directory;
import SyncNinjaPackage.syncNinja.service.DirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Validator {
    DirectoryService directoryService;

    @Autowired
    public Validator(DirectoryService directoryService) {
        this.directoryService = directoryService;
    }

    public void validate(String path) throws Exception{
        Directory directory = directoryService.getDirectory(path);
    }
}
