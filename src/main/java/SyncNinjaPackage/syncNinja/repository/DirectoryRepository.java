package SyncNinjaPackage.syncNinja.repository;

import SyncNinjaPackage.syncNinja.model.Directory;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface DirectoryRepository extends Neo4jRepository<Directory, String> {


}
