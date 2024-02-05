package SyncNinjaPackage.syncNinja.repository;

import SyncNinjaPackage.syncNinja.model.Directory;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

public interface DirectoryRepository extends Neo4jRepository<Directory, String> {
}
