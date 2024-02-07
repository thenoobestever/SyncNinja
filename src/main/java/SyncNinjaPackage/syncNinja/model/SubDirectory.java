package SyncNinjaPackage.syncNinja.model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

@Node
public class SubDirectory implements InternalTreeInterface{

    @Id
    String path;

    @Relationship(type = "HAS" , direction = Relationship.Direction.OUTGOING)
    List<InternalTreeInterface> internalNodes;



    public SubDirectory(String path) {
        this.path = path;
        this.internalNodes = new ArrayList<>();
    }

    public String getPath() {
        return path;
    }

    public List<InternalTreeInterface> getInternalNodes() {
        return internalNodes;
    }


    @Override
    public boolean isDirectory(String path) {
        return true;
    }
    public void addfile(InternalTreeInterface internalfile) {

        this.internalNodes.add(internalfile);
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setInternalNodes(List<InternalTreeInterface> internalNodes) {
        this.internalNodes = internalNodes;
    }

}
