package SyncNinjaPackage.syncNinja.stateTree.repository;

import SyncNinjaPackage.syncNinja.stateTree.models.StateTree;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface StateTreeRepository extends Neo4jRepository<StateTree, String> {

}
