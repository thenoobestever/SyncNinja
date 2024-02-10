package SyncNinjaPackage.syncNinja.model.stagingArea;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.List;
//findingChanges
@Node
public class StagingTree {
    List <StagingNode> stagingNodeList;

    public List<StagingNode> getStagingNodeList() {
        return stagingNodeList;
    }

    public void setStagingNodeList(List<StagingNode> stagingNodeList) {
        this.stagingNodeList = stagingNodeList;
    }

    public void addNode (StagingNode stagingNode) {stagingNodeList.add(stagingNode);}

    public void removeNode(StagingNode stagingNode){stagingNodeList.remove(stagingNode);}
}
