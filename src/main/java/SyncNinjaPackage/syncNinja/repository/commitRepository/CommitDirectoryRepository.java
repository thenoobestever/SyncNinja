package SyncNinjaPackage.syncNinja.repository.commitRepository;

import SyncNinjaPackage.syncNinja.model.commitTree.commitDirectory;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface CommitDirectoryRepository extends Neo4jRepository <commitDirectory,String> {

}
