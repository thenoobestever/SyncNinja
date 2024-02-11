package SyncNinjaPackage.syncNinja.stateTree.repository;

import SyncNinjaPackage.syncNinja.stateTree.models.StateDirectory;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface StateDirectoryRepository extends Neo4jRepository<StateDirectory, String> {

}
