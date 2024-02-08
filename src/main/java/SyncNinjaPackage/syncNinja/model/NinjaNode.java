package SyncNinjaPackage.syncNinja.model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.Set;
import java.util.UUID;

@Node
public abstract class NinjaNode extends SyncNode{ // commits and branches
    @Id
    private final UUID id;

    @Relationship(type = "ParentOf")
    Set<NinjaNode> childrenSet;

    public NinjaNode() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public Set<NinjaNode> getChildrenSet() {
        return childrenSet;
    }

    public void setChildrenSet(Set<NinjaNode> childrenSet) {
        this.childrenSet = childrenSet;
    }

    public void addToChildrenSet(NinjaNode ninjaNode){
        childrenSet.add(ninjaNode);
    }

    public void DeleteFromChildrenSet(NinjaNode ninjaNode){
        childrenSet.remove(ninjaNode);
    }
}
