package SyncNinjaPackage.syncNinja.model.StateTreeModel;

import org.springframework.context.annotation.Lazy;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Node
public class StateDirectory extends StateTree {
    
    @Relationship(type = "HAS" , direction = Relationship.Direction.OUTGOING)
    @Lazy
    private Set<StateTree> internalNodes = new HashSet<>();


    public StateDirectory() {;
    }


    public StateDirectory(String path) {
        super(path);
        this.internalNodes = new HashSet<>();
    }

    public String getPath() {
        return path;
    }

    public Set<StateTree> getInternalNodes() {
        return internalNodes;
    }


    @Override
    public boolean isDirectory() {
        return true;
    }
    public void addfile(StateTree internalfile) {

        this.internalNodes.add(internalfile);
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setInternalNodes(Set<StateTree> internalNodes) {
        this.internalNodes = internalNodes;
    }



}
