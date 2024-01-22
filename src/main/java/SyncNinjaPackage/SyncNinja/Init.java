package SyncNinjaPackage.SyncNinja;

import org.springframework.stereotype.Component;
import picocli.CommandLine;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
@CommandLine.Command(name = "init")
public class Init implements Runnable {
    @CommandLine.Option(names = "-path")
    public static String path;

    @Override
    public void run() {
        Path syncNinjaPath = FileSystems.getDefault().getPath(path,".syncNinja");
        if(Files.exists(syncNinjaPath) && Files.isDirectory(syncNinjaPath)){
            System.out.println("This repository is already initialized");
        } else {
            try {
                Files.createDirectory(syncNinjaPath);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
