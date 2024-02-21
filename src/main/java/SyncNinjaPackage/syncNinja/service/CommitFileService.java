package SyncNinjaPackage.syncNinja.service;
import SyncNinjaPackage.syncNinja.model.commitTree.CommitFile;
import SyncNinjaPackage.syncNinja.repository.commitRepository.CommitDirectoryRepository;
import SyncNinjaPackage.syncNinja.repository.commitRepository.CommitFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommitFileService  {
    private final CommitFileRepository commitFileRepository;


    @Autowired
    public CommitFileService(CommitFileRepository commitFileRepository) {
        this.commitFileRepository = commitFileRepository;
    }

    public void createCommitFile(String path){
        CommitFile commitFile = new CommitFile(path);
        commitFileRepository.save(commitFile);
    }

}

