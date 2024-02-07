package SyncNinjaPackage.syncNinja.model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Relationship;
import java.util.Set;
import java.util.UUID;

public class BranchableNode extends SyncNode{
    @Id
    private final UUID id;

    @Relationship(type = "ParentOf")
    Set<BranchableNode> childrenSet;

    public BranchableNode() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public Set<BranchableNode> getChildrenSet() {
        return childrenSet;
    }

    public void setChildrenSet(Set<BranchableNode> childrenSet) {
        this.childrenSet = childrenSet;
    }

    public void addToChildrenSet(BranchableNode branchableNode){
        childrenSet.add(branchableNode);
    }

    public void DeleteFromChildrenSet(BranchableNode branchableNode){
        childrenSet.remove(branchableNode);
    }
}
