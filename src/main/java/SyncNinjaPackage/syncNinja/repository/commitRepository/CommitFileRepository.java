package SyncNinjaPackage.syncNinja.repository.commitRepository;

import SyncNinjaPackage.syncNinja.model.commitTree.CommitFile;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface CommitFileRepository extends Neo4jRepository<CommitFile,String> {
}
