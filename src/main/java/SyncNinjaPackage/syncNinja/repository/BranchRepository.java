package SyncNinjaPackage.syncNinja.repository;

import SyncNinjaPackage.syncNinja.model.Branch;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import java.util.Optional;

public interface BranchRepository extends Neo4jRepository<Branch, String> {
    Optional<Branch> findByName(String name);
}
