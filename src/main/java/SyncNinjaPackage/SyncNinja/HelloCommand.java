package SyncNinjaPackage.SyncNinja;

import org.springframework.stereotype.Component;
import picocli.CommandLine;

@CommandLine.Command(name = "",
        subcommands = {
                Hello.class })
@Component
public class HelloCommand implements Runnable {
    @Override
    public void run(){
        System.out.println("Hello world");
    }
}
