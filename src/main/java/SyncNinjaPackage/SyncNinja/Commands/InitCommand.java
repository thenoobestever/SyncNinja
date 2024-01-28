package SyncNinjaPackage.SyncNinja.Commands;

import SyncNinjaPackage.SyncNinja.Services.DirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import picocli.CommandLine;

@Component
@CommandLine.Command(name = "init")
public class InitCommand implements CommandLineRunner {
    DirectoryService directoryService;

    @Autowired
    public InitCommand(DirectoryService directoryService) {
        this.directoryService = directoryService;
    }

    @Override
    public void run(String... args) throws Exception {
        String path = System.getProperty("user.dir");
        directoryService.saveDirectory(path);
    }
}
