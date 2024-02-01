package SyncNinjaPackage.syncNinja.model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node
public class Branch {
    @Id
    int id;
    String name;

    @Relationship(type = "DIRECTORY")
    Directory directory;

    public Branch() {
    }

    public Branch(int id) {
        this.id = id;
    }

    public Branch(String name, Directory directory) {
        this.name = name;
        this.directory = directory;
    }

    public Branch(int id, String name, Directory directory) {
        this.id = id;
        this.name = name;
        this.directory = directory;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
