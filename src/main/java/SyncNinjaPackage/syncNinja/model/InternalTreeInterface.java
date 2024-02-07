package SyncNinjaPackage.syncNinja.model;

import org.springframework.data.neo4j.core.schema.Node;


public interface InternalTreeInterface {
    public boolean isDirectory(String path);
}
