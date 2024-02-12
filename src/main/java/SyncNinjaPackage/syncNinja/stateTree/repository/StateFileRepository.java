package SyncNinjaPackage.syncNinja.stateTree.repository;

import SyncNinjaPackage.syncNinja.stateTree.models.StateFile;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface StateFileRepository extends Neo4jRepository<StateFile,String> {
}
