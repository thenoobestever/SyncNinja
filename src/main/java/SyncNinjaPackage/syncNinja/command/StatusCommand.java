package SyncNinjaPackage.syncNinja.command;

import SyncNinjaPackage.syncNinja.service.StateTreeService;
import SyncNinjaPackage.syncNinja.util.SpringAdapter;
import picocli.CommandLine;

import java.io.IOException;

@CommandLine.Command(name = "status")
public class StatusCommand implements Runnable{

    StateTreeService stateTreeService = SpringAdapter.getBean(StateTreeService.class);
    @Override
    public void run() {
        String path = System.getProperty("user.dir");
        try {
            stateTreeService.getStatus(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
