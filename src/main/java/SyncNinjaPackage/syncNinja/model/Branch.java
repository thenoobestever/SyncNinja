package SyncNinjaPackage.syncNinja.model;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.List;
import java.util.Set;

@Node
public class Branch {
    @Id
    private String id;
    private String name;




    public Branch() {
    }

    public Branch(String name) {
        this.id = RandomStringUtils.randomAlphanumeric(16);;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
