package SyncNinjaPackage.syncNinja.service;

import SyncNinjaPackage.syncNinja.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BranchService {
    private BranchRepository branchRepository;
    private DirectoryService directoryService;
    private ResourceMessagingService resourceMessagingService;

    @Autowired
    public BranchService(BranchRepository branchRepository, DirectoryService directoryService, ResourceMessagingService resourceMessagingService) {
        this.branchRepository = branchRepository;
        this.directoryService = directoryService;
        this.resourceMessagingService = resourceMessagingService;
    }
    // create a method (create a branch) on checkout command
}
