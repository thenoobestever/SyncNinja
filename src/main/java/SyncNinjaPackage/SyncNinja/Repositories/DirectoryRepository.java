package SyncNinjaPackage.SyncNinja.Repositories;

import SyncNinjaPackage.SyncNinja.Models.Directory;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository
public interface DirectoryRepository extends Neo4jRepository<Directory, String> {
}
