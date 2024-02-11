package SyncNinjaPackage.syncNinja.repository;

import SyncNinjaPackage.syncNinja.model.Commit;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.UUID;

public interface CommitRepository extends Neo4jRepository<Commit, UUID> {
}
