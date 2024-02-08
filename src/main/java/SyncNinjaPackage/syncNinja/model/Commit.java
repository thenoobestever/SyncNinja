package SyncNinjaPackage.syncNinja.model;

import org.springframework.data.neo4j.core.schema.Node;
import java.util.UUID;

@Node
public class Commit extends NinjaNode {
    private String message;

    public Commit(String message) {
        super();
        this.message = message;
    }

    public UUID getId() {
        return super.getId();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}