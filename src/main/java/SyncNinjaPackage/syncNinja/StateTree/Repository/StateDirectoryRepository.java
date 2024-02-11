package SyncNinjaPackage.syncNinja.StateTree.Repository;

import SyncNinjaPackage.syncNinja.StateTree.models.StateDirectory;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface StateDirectoryRepository extends Neo4jRepository<StateDirectory, String> {

}
