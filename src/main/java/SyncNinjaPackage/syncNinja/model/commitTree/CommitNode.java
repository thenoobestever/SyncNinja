package SyncNinjaPackage.syncNinja.model.commitTree;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public abstract class CommitNode {
    @Id
    private String path;
    public String getPath(){
        return path;
    }

    public CommitNode(String path) {
        this.path = path;
    }

    public CommitNode() {

    }
}
