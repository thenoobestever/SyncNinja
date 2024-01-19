package SyncNinjaPackage.SyncNinja;

import picocli.CommandLine;

@CommandLine.Command(name = "hi")
public class HelloCommand implements Runnable {
    @Override
    public void run(){
        System.out.println("Hello world");
    }
}
