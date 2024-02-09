package SyncNinjaPackage.syncNinja.repository;

import SyncNinjaPackage.syncNinja.model.StateDirectory;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface StateDirectoryRepository extends Neo4jRepository<StateDirectory, String> {

}
