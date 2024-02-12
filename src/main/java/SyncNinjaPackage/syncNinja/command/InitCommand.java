package SyncNinjaPackage.syncNinja.command;

import SyncNinjaPackage.syncNinja.StateTree.StateTreeServices.StateTreeService;
import SyncNinjaPackage.syncNinja.model.Directory;
import SyncNinjaPackage.syncNinja.service.DirectoryService;
import SyncNinjaPackage.syncNinja.util.SpringAdapter;
import picocli.CommandLine;

@CommandLine.Command(name = "init")
public class InitCommand implements Runnable {
    DirectoryService directoryService = SpringAdapter.getBean(DirectoryService.class);
    StateTreeService stateTreeService = SpringAdapter.getBean(StateTreeService.class);
    @Override
    public void run() {
        String path = System.getProperty("user.dir");
        try {
            Directory directory = directoryService.createDirectory(path);
            directoryService.createDirectoryMainBranch(directory, "main");
            stateTreeService.generateStateDirectoryNode(path);

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
