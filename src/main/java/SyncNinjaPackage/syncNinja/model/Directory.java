package SyncNinjaPackage.syncNinja.model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node
public class Directory {
    @Id
    private final String path;

    @Relationship(type = "MainBranch")
    private Branch branch;

    public Directory(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
