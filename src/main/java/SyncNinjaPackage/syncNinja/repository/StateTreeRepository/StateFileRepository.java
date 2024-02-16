package SyncNinjaPackage.syncNinja.repository.StateTreeRepository;

import SyncNinjaPackage.syncNinja.model.StateTreeModel.StateFile;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface StateFileRepository extends Neo4jRepository<StateFile,String> {
}
