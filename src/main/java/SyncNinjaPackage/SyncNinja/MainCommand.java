package SyncNinjaPackage.SyncNinja;

import org.springframework.stereotype.Component;
import picocli.CommandLine;

@CommandLine.Command(name = "",
        subcommands = {
                Init.class })
@Component
public class MainCommand implements Runnable {
    @Override
    public void run(){

    }
}
