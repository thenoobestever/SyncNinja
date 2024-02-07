package SyncNinjaPackage.syncNinja.model;

import SyncNinjaPackage.syncNinja.util.Fetcher;
import SyncNinjaPackage.syncNinja.util.SHA256;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.io.IOException;
import java.util.List;

@Node
public class File implements InternalTreeInterface{

    @Id
    String path;
    List<String> lines;

    String hashValue;
    public File(String path) throws IOException {
        this.path = path;
        hashValue = SHA256.hashValue(path);
        lines = Fetcher.readFile(path);
    }

    public String getPath() {
        return path;
    }

    public List<String> getLines() {
        return lines;
    }
    @Override
    public boolean isDirectory(String path) {
        return false;
    }
    public String getHashValue() {
        return hashValue;
    }


}
