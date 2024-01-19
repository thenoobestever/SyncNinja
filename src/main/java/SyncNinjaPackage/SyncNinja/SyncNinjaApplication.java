package SyncNinjaPackage.SyncNinja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import picocli.CommandLine;

@SpringBootApplication
public class SyncNinjaApplication {
	public static void main(String[] args) {
		SpringApplication.run(SyncNinjaApplication.class,args);
		new CommandLine(new HelloCommand()).execute(args);
	}
}