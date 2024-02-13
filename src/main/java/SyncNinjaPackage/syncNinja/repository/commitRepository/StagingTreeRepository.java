package SyncNinjaPackage.syncNinja.repository.commitRepository;

import SyncNinjaPackage.syncNinja.model.commitTree.StagingTree;
import SyncNinjaPackage.syncNinja.model.commitTree.commitDirectory;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface StagingTreeRepository extends Neo4jRepository<StagingTree,String> {
}
