package SyncNinjaPackage.syncNinja.repository.StateTreeRepository;

import SyncNinjaPackage.syncNinja.model.StateTreeModel.StateDirectory;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface StateDirectoryRepository extends Neo4jRepository<StateDirectory, String> {

}
