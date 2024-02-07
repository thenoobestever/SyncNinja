package SyncNinjaPackage.syncNinja.repository;

import SyncNinjaPackage.syncNinja.model.File;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface FilesRepository extends Neo4jRepository<File,String> {
}
