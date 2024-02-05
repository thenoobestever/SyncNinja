package SyncNinjaPackage.syncNinja.model;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node
public class Branch {
    @Id
    String id;
    String name;

    @Relationship(type = "DIRECTORY")
    Directory directory;

    public Branch() {
    }

    public Branch(String id) {
        this.id = id;
    }

    public Branch(String name, Directory directory) {
        this.id = RandomStringUtils.randomAlphanumeric(16);;
        this.name = name;
        this.directory = directory;
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

    public Directory getDirectory() {
        return directory;
    }

    public void setDirectory(Directory directory) {
        this.directory = directory;
    }
}
