package SyncNinjaPackage.SyncNinja;

import org.springframework.stereotype.Component;
import picocli.CommandLine;

@Component
@CommandLine.Command(name = "hello")
public class Hello implements Runnable {

    @CommandLine.Option(names = "-u")
    public int number;
    @Override
    public void run() {
        System.out.println("HIIIIIIII " + number);
    }
}
