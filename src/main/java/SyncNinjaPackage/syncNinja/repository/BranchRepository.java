package SyncNinjaPackage.syncNinja.repository;

import SyncNinjaPackage.syncNinja.model.Branch;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import java.util.Optional;
import java.util.UUID;

public interface BranchRepository extends Neo4jRepository<Branch, UUID> {
    Optional<Branch> findByName(String name);


}
