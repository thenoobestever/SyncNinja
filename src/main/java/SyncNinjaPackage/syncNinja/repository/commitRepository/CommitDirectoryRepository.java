package SyncNinjaPackage.syncNinja.repository.commitRepository;

import SyncNinjaPackage.syncNinja.model.commitTree.CommitDirectory;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface CommitDirectoryRepository extends Neo4jRepository <CommitDirectory,String> {

}
