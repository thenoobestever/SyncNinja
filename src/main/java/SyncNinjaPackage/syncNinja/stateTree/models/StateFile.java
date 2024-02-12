package SyncNinjaPackage.syncNinja.stateTree.models;

import SyncNinjaPackage.syncNinja.util.Fetcher;
import SyncNinjaPackage.syncNinja.util.SHA256;
import org.springframework.data.neo4j.core.schema.Node;

import java.io.IOException;
import java.util.List;

@Node
public class StateFile extends StateTree {



    private List<String> lines;

    String hashValue;
    public StateFile(String path) throws IOException {
        this.path = path;
        hashValue = SHA256.hashValue(path);
        lines = Fetcher.readFile(path);

    }

    public StateFile() {
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setLines(List<String> lines) {
        this.lines = lines;
    }

    public void setHashValue(String hashValue) {
        this.hashValue = hashValue;
    }

    public String getPath() {
        return path;
    }

    public List<String> getLines() {
        return lines;
    }
    @Override
    public boolean isDirectory() {
        return false;
    }
    public String getHashValue() {
        return hashValue;
    }


}
