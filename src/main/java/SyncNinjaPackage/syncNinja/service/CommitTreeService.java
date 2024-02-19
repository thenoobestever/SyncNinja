package SyncNinjaPackage.syncNinja.service;

import SyncNinjaPackage.syncNinja.model.commitTree.CommitDirectory;
import SyncNinjaPackage.syncNinja.model.commitTree.CommitFile;
import SyncNinjaPackage.syncNinja.model.commitTree.CommitNode;
import SyncNinjaPackage.syncNinja.repository.commitRepository.CommitNodeRepository;
import SyncNinjaPackage.syncNinja.util.Fetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

@Service
public class CommitTreeService {

    private CommitNode root;
    private final StatusService statusService;
    private final CommitNodeRepository commitNodeRepository;

    @Autowired
    public CommitTreeService(StatusService statusService , CommitNodeRepository commitNodeRepository) {
        this.statusService = statusService;
        this.commitNodeRepository=commitNodeRepository;
    }

    public void addFilesFromDirectoryToCommitTree(String directoryPath) throws IOException {
        List<String> filePaths = Fetcher.pathList(Path.of(directoryPath));
        List<String> untrackedFiles = statusService.getUntrackedFiles(filePaths, directoryPath);
        addFilesToCommitTree(untrackedFiles,directoryPath);
    }

    public void addFilesToCommitTree(List<String> filePaths, String directoryPath) {

        CommitNode root = new CommitDirectory(directoryPath);

        for (String path : filePaths) {
            String[] pathComponents = path.split("\\\\");
            CommitNode currentNode = root;

            for (String component : pathComponents) {
                System.out.println(component);
                boolean found = false;
                if (currentNode instanceof CommitDirectory && ((CommitDirectory) currentNode).getCommitNodeList() != null) {
                    for (CommitNode child : ((CommitDirectory) currentNode).getCommitNodeList()) {
                        if (child.getPath().equals(component)) {
                            currentNode = child;
                            found = true;
                            break;
                        }
                    }
                }
                if (!found) {
                    CommitNode newNode;
                    if (isFile(component)) {
                        newNode = new CommitFile(component);
                    } else {
                        newNode = new CommitDirectory(component);
                    }
                    ((CommitDirectory) currentNode).addNode(newNode);
                    currentNode = newNode;
                }
            }
        }
        commitNodeRepository.save(root);
    }
    private boolean isFile(String path) {

        //if the path contains "." then it's a file?
        return new File(path).isFile();
    }
}
