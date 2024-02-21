package SyncNinjaPackage.syncNinja.repository.commitRepository;

import SyncNinjaPackage.syncNinja.model.commitTree.CommitNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface CommitNodeRepository extends Neo4jRepository<CommitNode,String> {
}
