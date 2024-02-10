package SyncNinjaPackage.syncNinja.repository.stagingAreaRepository;

import SyncNinjaPackage.syncNinja.model.stagingArea.StagingDirectory;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface StagingFileRepository extends Neo4jRepository<StagingDirectory,String> {
}
