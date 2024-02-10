package SyncNinjaPackage.syncNinja.model.stagingArea;

import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@Node
public class StagingDirectory extends StagingNode {
    @Relationship(type ="CONTAINS")
    private List<StagingNode> stagingNodeList;

    public StagingDirectory() {
        this.stagingNodeList = stagingNodeList;
    }
    public StagingDirectory(List<StagingNode> stagingNodeList) {
        this.stagingNodeList = stagingNodeList;
    }

    public List<StagingNode> getStagingNodeList() {
        return stagingNodeList;
    }

    public void setStagingNodeList(List<StagingNode> stagingNodeList) {
        this.stagingNodeList = stagingNodeList;
    }

    public void addNode (StagingNode stagingNode) {stagingNodeList.add(stagingNode);}

    public void removeNode (StagingNode stagingNode) {stagingNodeList.remove(stagingNode);}
}
