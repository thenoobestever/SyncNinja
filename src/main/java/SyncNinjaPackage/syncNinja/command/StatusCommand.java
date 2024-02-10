package SyncNinjaPackage.syncNinja.command;

import SyncNinjaPackage.syncNinja.StateTree.StateTreeServices.StateTreeService;
import SyncNinjaPackage.syncNinja.model.Directory;
import SyncNinjaPackage.syncNinja.service.DirectoryService;
import SyncNinjaPackage.syncNinja.service.ResourceMessagingService;
import SyncNinjaPackage.syncNinja.service.StatusService;
import SyncNinjaPackage.syncNinja.util.ResourceBundleEnum;
import SyncNinjaPackage.syncNinja.util.SpringAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import picocli.CommandLine;

import java.io.IOException;
import java.util.Optional;

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
