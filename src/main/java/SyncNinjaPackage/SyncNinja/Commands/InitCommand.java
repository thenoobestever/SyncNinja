package SyncNinjaPackage.SyncNinja.Commands;

import SyncNinjaPackage.SyncNinja.Services.DirectoryService;
import SyncNinjaPackage.SyncNinja.SpringAdapter;
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
