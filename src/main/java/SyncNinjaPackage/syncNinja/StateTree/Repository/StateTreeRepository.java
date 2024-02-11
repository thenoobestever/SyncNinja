package SyncNinjaPackage.syncNinja.StateTree.Repository;

import SyncNinjaPackage.syncNinja.StateTree.models.StateTree;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface StateTreeRepository extends Neo4jRepository<StateTree, String> {

}
