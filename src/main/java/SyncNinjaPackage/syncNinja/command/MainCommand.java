package SyncNinjaPackage.syncNinja.command;

import SyncNinjaPackage.syncNinja.util.SpringAdapter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import picocli.CommandLine;

@CommandLine.Command(name = "",
        subcommands = {
                InitCommand.class , StatusCommand.class , AddCommand.class}
)
@Component
public class MainCommand implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        CommandLine commandLine = new CommandLine(SpringAdapter.getBean(MainCommand.class));
        commandLine.execute(args);
    }
}
