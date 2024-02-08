package SyncNinjaPackage.syncNinja.model;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class Branch extends NinjaNode {
    private String name;

    public Branch(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
