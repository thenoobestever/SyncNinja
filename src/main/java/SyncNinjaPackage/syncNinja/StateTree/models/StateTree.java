package SyncNinjaPackage.syncNinja.StateTree.models;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public abstract class StateTree {
    @Id
    protected String path;

    public String getPath(){
        return path;
    }
    public abstract boolean isDirectory();



}
