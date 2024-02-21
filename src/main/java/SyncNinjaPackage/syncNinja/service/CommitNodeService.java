package SyncNinjaPackage.syncNinja.service;

import SyncNinjaPackage.syncNinja.model.commitTree.CommitFile;
import SyncNinjaPackage.syncNinja.model.commitTree.CommitNode;
import SyncNinjaPackage.syncNinja.repository.commitRepository.CommitNodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommitNodeService {
    private final CommitNodeRepository commitNodeRepository;

    @Autowired
    public CommitNodeService(CommitNodeRepository commitNodeRepository) {
        this.commitNodeRepository = commitNodeRepository;
    }

    public void createCommitFile(String path){
        // Create empty lists for lineNumberList, newValuesList, and oldValuesList


        CommitFile commitFile = new CommitFile(path);

        commitNodeRepository.save(commitFile);
    }
}

