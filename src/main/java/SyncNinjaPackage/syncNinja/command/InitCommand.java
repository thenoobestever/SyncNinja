package SyncNinjaPackage.syncNinja.command;

import SyncNinjaPackage.syncNinja.service.DirectoryService;
import SyncNinjaPackage.syncNinja.util.SpringAdapter;
import picocli.CommandLine;

@CommandLine.Command(name = "init")
public class InitCommand implements Runnable {
    DirectoryService directoryService = SpringAdapter.getBean(DirectoryService.class);
    @Override
    public void run() {
        String path = System.getProperty("user.dir");
        directoryService.saveDirectory(path);
    }
}
