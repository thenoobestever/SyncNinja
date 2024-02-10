package SyncNinjaPackage.syncNinja.model.stagingArea;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

public abstract class StagingNode {
    @Id
    private String path;
    public String getPath(){
        return path;
    }

    public StagingNode(String path) {
        this.path = path;
    }

    public StagingNode() {
    }
}
