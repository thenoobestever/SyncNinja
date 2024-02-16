package SyncNinjaPackage.syncNinja.repository.StateTreeRepository;

import SyncNinjaPackage.syncNinja.model.StateTreeModel.StateTree;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface StateTreeRepository extends Neo4jRepository<StateTree, String> {

}
