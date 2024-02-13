package SyncNinjaPackage.syncNinja.model.commitTree;

import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@Node
public class commitDirectory extends CommitNode {
    @Relationship(type ="CONTAINS")
    private List<CommitNode> commitNodeList;

    public commitDirectory() {
        this.commitNodeList = commitNodeList;
    }
    public commitDirectory(String path,List<CommitNode> commitNodeList) {
        super(path);
        this.commitNodeList = commitNodeList;
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
}
