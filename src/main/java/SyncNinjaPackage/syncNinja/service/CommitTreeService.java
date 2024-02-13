package SyncNinjaPackage.syncNinja.service;

import SyncNinjaPackage.syncNinja.model.commitTree.CommitNode;
import SyncNinjaPackage.syncNinja.model.commitTree.StagingTree;
import SyncNinjaPackage.syncNinja.repository.commitRepository.StagingTreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;

@Service
public class CommitTreeService {

    private StagingTreeRepository stagingTreeRepository;

    @Autowired
    public CommitTreeService(StagingTreeRepository stagingTreeRepository) {
        this.stagingTreeRepository = stagingTreeRepository;
    }

//    public void addFilesToCommitTree(List<String> filePaths){
//        for (String path: filePaths){
//            String[] pathComponents = path.split("/");
//            CommitNode currentNode= stagingTree;
//
//            for (String component : pathComponents) {
//                //validation from leen's function
//                boolean found = false;
//                for (CommitNode child : currentNode.getStagingNodeList()) {
//                    if (child.getPath().equals(component)) {
//                        currentNode = child;
//                        found = true;
//                        break;
//                    }
//                }
//                if (!found) {
//                    CommitNode newNode = new CommitFile(component);
//                    currentNode.addNode(newNode);
//                    currentNode = newNode;
//                }
//        }
//    }
}
