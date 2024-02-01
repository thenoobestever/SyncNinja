package SyncNinjaPackage.syncNinja.repository;

import SyncNinjaPackage.syncNinja.model.Branch;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Component
@Repository
public interface BranchRepository extends Neo4jRepository<Branch, String> {
    Optional<Branch> findByName(String name);
}
