package SyncNinjaPackage.syncNinja.service;

import SyncNinjaPackage.syncNinja.model.Branch;
import SyncNinjaPackage.syncNinja.model.Directory;
import SyncNinjaPackage.syncNinja.repository.BranchRepository;
import SyncNinjaPackage.syncNinja.util.ResourceBundleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.Optional;

@Service
public class BranchService {
    BranchRepository branchRepository;
    DirectoryService directoryService;

    @Autowired
    public BranchService(BranchRepository branchRepository, DirectoryService directoryService) {
        this.branchRepository = branchRepository;
        this.directoryService = directoryService;
    }

    public void createBranch(String name, String path){
        Optional<Branch> branch = branchRepository.findByName(name);
        if (branch.isPresent()){
            if(directoryService.getDirectory(path) != null){return;}
            System.out.println(ResourceBundleEnum.BRANCH_NAME_EXISTS.getMessage(new Object[] {name}));
        }
        else{
            Directory directory = directoryService.getDirectory(path);
            if (directory != null){
                Branch new_branch = new Branch(name,directory);
                branchRepository.save(new_branch);
            }
        }
    }
}
