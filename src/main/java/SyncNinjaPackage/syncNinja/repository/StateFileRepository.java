package SyncNinjaPackage.syncNinja.repository;

import SyncNinjaPackage.syncNinja.model.StateFile;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface StateFileRepository extends Neo4jRepository<StateFile,String> {
}
