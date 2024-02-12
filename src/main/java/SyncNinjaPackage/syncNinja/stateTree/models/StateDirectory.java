package SyncNinjaPackage.syncNinja.stateTree.models;

import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

@Node
public class StateDirectory extends StateTree {
    
    @Relationship(type = "HAS" , direction = Relationship.Direction.OUTGOING)
    private List<StateTree> internalNodes;

    public StateDirectory() {
    }


    public StateDirectory(String path) {
        this.path = path;
        this.internalNodes = new ArrayList<>();
    }

    public String getPath() {
        return path;
    }

    public List<StateTree> getInternalNodes() {
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

    public void setInternalNodes(List<StateTree> internalNodes) {
        this.internalNodes = internalNodes;
    }



}
