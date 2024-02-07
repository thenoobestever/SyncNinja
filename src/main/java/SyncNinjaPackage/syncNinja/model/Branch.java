package SyncNinjaPackage.syncNinja.model;

import org.springframework.data.neo4j.core.schema.Node;
import java.util.UUID;


@Node
public class Branch extends BranchableNode {

    private String name;

    public Branch() {
    }

    public Branch(String name) {
        super();
        this.name = name;
    }

    public UUID getId() {
        return super.getId();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
