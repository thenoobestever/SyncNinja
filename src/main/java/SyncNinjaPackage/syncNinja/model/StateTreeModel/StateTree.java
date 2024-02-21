package SyncNinjaPackage.syncNinja.model.StateTreeModel;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

import java.io.File;

@Node
public abstract class StateTree {
    @Id
    protected String path;

    protected long lastModified;

    public StateTree() {

    }

    public StateTree(String path) {
        this.path = path;
        File file = new File(path);
        this.lastModified = file.lastModified();
    }

    public long getLastModified() {
        return lastModified;
    }

    public void setLastModified(long lastModified) {
        this.lastModified = lastModified;
    }

    public String getPath(){
        return path;
    }
    public abstract boolean isDirectory();



}
