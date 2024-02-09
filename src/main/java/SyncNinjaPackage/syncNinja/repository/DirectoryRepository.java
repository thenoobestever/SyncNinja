package SyncNinjaPackage.syncNinja.repository;

import SyncNinjaPackage.syncNinja.model.Branch;
import SyncNinjaPackage.syncNinja.model.Directory;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


public interface DirectoryRepository extends Neo4jRepository<Directory, String> {


}
