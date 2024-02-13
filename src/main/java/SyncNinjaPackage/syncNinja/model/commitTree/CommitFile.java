package SyncNinjaPackage.syncNinja.model.commitTree;

import org.springframework.data.neo4j.core.schema.Node;

import java.util.List;

@Node
public class CommitFile extends CommitNode {
    private List<Integer> lineNumberList;
    private List<String> newValuesList;
    private List<String> oldValuesList;

    public CommitFile(String path,List<Integer> lineNumberList, List<String> newValuesList, List<String> oldValuesList) {
        super(path);
        this.lineNumberList = lineNumberList;
        this.newValuesList = newValuesList;
        this.oldValuesList = oldValuesList;
    }

    public CommitFile(String path) {super(path);}

    public List<Integer> getLineNumberList() {
        return lineNumberList;
    }

    public void setLineNumberList(List<Integer> lineNumberList) {
        this.lineNumberList = lineNumberList;
    }

    public List<String> getNewValuesList() {
        return newValuesList;
    }

    public void setNewValuesList(List<String> newValuesList) {
        this.newValuesList = newValuesList;
    }

    public List<String> getOldValuesList() {
        return oldValuesList;
    }

    public void setOldValuesList(List<String> oldValuesList) {
        this.oldValuesList = oldValuesList;
    }

    public void addLineNumber(int lineNumber){
        this.lineNumberList.add(lineNumber);
    }

    public void removeLineNumber(int lineNumber){
        this.lineNumberList.remove(lineNumber);
    }

    public void addNewValue(String newValue){
        this.newValuesList.add(newValue);
    }

    public void removeNewValue(String newValue){
        this.newValuesList.remove(newValue);
    }

    public void addOldValue(String oldValue){
        this.oldValuesList.add(oldValue);
    }

    public void removeOldValue(String oldValue){
        this.oldValuesList.remove(oldValue);
    }
}
