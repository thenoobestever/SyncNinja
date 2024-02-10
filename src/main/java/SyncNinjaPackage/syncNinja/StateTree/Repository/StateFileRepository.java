package SyncNinjaPackage.syncNinja.StateTree.Repository;

import SyncNinjaPackage.syncNinja.StateTree.models.StateFile;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface StateFileRepository extends Neo4jRepository<StateFile,String> {
}
