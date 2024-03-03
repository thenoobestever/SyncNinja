package SyncNinjaPackage.SyncNinja;

import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface DirectoryRepo extends Neo4jRepository<Directory, String> {
}
