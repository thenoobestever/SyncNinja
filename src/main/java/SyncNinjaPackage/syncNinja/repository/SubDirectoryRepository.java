package SyncNinjaPackage.syncNinja.repository;

import SyncNinjaPackage.syncNinja.model.SubDirectory;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface SubDirectoryRepository extends Neo4jRepository<SubDirectory, String> {

}
