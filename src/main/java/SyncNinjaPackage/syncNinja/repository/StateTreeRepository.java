package SyncNinjaPackage.syncNinja.repository;

import SyncNinjaPackage.syncNinja.model.StateTree;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface StateTreeRepository extends Neo4jRepository<StateTree , String> {

}
