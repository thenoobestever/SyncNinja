package SyncNinjaPackage.syncNinja.repository;

import SyncNinjaPackage.syncNinja.model.NinjaNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.UUID;

public interface NinjaNodeRepository extends Neo4jRepository<NinjaNode, UUID> {
}
