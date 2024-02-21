package SyncNinjaPackage.syncNinja.model.commitTree;

import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

@Node
public class CommitDirectory extends CommitNode {
    @Relationship(type ="CONTAINS")
    private List<CommitNode> commitNodeList= new ArrayList<>();

    public CommitDirectory() {
    }
    public CommitDirectory(String path) {
        super(path);
    }

    public List<CommitNode> getStagingNodeList() {
        return commitNodeList;
    }

    public void setStagingNodeList(List<CommitNode> commitNodeList) {
        this.commitNodeList = commitNodeList;
    }

    public void addNode (CommitNode commitNode) {
        commitNodeList.add(commitNode);}

    public void removeNode (CommitNode commitNode) {
        commitNodeList.remove(commitNode);}

    public List<CommitNode> getCommitNodeList() {
        return commitNodeList;
    }
}
