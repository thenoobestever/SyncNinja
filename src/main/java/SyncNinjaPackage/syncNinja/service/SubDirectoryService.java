package SyncNinjaPackage.syncNinja.service;

import SyncNinjaPackage.syncNinja.model.File;
import SyncNinjaPackage.syncNinja.model.SubDirectory;
import SyncNinjaPackage.syncNinja.repository.SubDirectoryRepository;
import SyncNinjaPackage.syncNinja.util.ResourceBundleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SubDirectoryService {
    private final SubDirectoryRepository subDirectoryRepository;
    private final FileService fileService;
    private final ResourceMessagingService resourceMessagingService;



    @Autowired
    public SubDirectoryService(SubDirectoryRepository subDirectoryRepository , FileService fileService, ResourceMessagingService resourceMessagingService) {
        this.subDirectoryRepository = subDirectoryRepository;
        this.fileService = fileService;
        this.resourceMessagingService = resourceMessagingService;
    }

    public void generateTree(String path){
        Path mainDirectory = Paths.get(path);
        List<Path> subList = null;
        try {
            subList = Files.walk(mainDirectory)
                    .collect(Collectors.toList());
            {
                for(int i = 0 ; i<subList.size() ; i++){
                    Path file = subList.get(i);
                    if(file.toFile().isDirectory()){
                        SubDirectory child = generateSubDirectoryNode(file.toString());
                        SubDirectory parent = subDirectoryRepository.findById(file.getParent().toString()).orElse(null);
                        if(parent!=null){
                            parent.addfile(child);
                            subDirectoryRepository.save(parent);
                        }
                    }
                    else{
                        File child = fileService.generateFileNode(file.toString());
                        SubDirectory parent = subDirectoryRepository.findById(file.getParent().toString()).orElse(null);

                        if(parent!=null){
                            parent.addfile(child);
                            subDirectoryRepository.save(parent);
                        }
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public SubDirectory generateSubDirectoryNode(String path){
        Optional<SubDirectory> file = subDirectoryRepository.findById(path);
        SubDirectory subDirectory = null;
        if(file.isPresent()){
            System.out.println(resourceMessagingService.getMessage(ResourceBundleEnum.SUB_DIRECTORY_ALREADY_EXISTS));
        }
        else{
            subDirectory = new SubDirectory(path);
            subDirectoryRepository.save(subDirectory);
        }
        return subDirectory;

    }
}
