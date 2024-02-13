package SyncNinjaPackage.syncNinja.model.commitTree;

import org.springframework.data.neo4j.core.schema.Node;

import java.util.List;
//findingChanges
@Node
public class StagingTree {
    List <CommitNode> commitNodeList;

    public List<CommitNode> getStagingNodeList() {
        return commitNodeList;
    }

    public void setStagingNodeList(List<CommitNode> commitNodeList) {
        this.commitNodeList = commitNodeList;
    }

    public void addNode (CommitNode commitNode) {
        commitNodeList.add(commitNode);}

    public void removeNode(CommitNode commitNode){
        commitNodeList.remove(commitNode);}
}
