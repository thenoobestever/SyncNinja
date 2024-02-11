package SyncNinjaPackage.syncNinja.command;

import SyncNinjaPackage.syncNinja.model.Directory;
import SyncNinjaPackage.syncNinja.service.DirectoryService;
import SyncNinjaPackage.syncNinja.service.StatusService;
import SyncNinjaPackage.syncNinja.util.SpringAdapter;
import picocli.CommandLine;

@CommandLine.Command(name = "status")
public class StatusCommand implements Runnable{

    StatusService statusService = SpringAdapter.getBean(StatusService.class);
    DirectoryService directoryService = SpringAdapter.getBean(DirectoryService.class);
    @Override
    public void run() {
        String path = System.getProperty("user.dir");
        try {
            Directory directory= directoryService.getDirectory(path);
            statusService.getStatus(path);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
