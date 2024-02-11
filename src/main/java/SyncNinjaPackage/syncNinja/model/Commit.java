package SyncNinjaPackage.syncNinja.model;

import org.springframework.data.neo4j.core.schema.Node;

@Node
public class Commit extends NinjaNode {
    private String message;

    public Commit(){
    }

    public Commit(String message) {
        super();
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
