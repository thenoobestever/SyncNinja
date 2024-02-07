package SyncNinjaPackage.syncNinja;

//import SyncNinjaPackage.SyncNinja.Commands.MainCommand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SyncNinjaApplication {
    private final ApplicationContext context;

    public SyncNinjaApplication(ApplicationContext context) {
        this.context = context;
    }

    public static void main(String[] args) {

        SpringApplication.run(SyncNinjaApplication.class, args);

    }
}