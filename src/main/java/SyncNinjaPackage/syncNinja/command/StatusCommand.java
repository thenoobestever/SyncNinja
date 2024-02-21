package SyncNinjaPackage.syncNinja.command;

import SyncNinjaPackage.syncNinja.service.ResourceMessagingService;
import SyncNinjaPackage.syncNinja.service.StatusService;
import SyncNinjaPackage.syncNinja.util.ResourceBundleEnum;
import SyncNinjaPackage.syncNinja.util.SpringAdapter;
import picocli.CommandLine;

import java.util.List;

@CommandLine.Command(name = "status")
public class StatusCommand implements Runnable{

    StatusService statusService = SpringAdapter.getBean(StatusService.class);
    ResourceMessagingService resourceMessagingService = SpringAdapter.getBean(ResourceMessagingService.class);
    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        String path = System.getProperty("user.dir");
        try {
            Object[] status = statusService.getStatus(path);
            List<String> tracked = (List<String>) status[0];
            List<String> untracked = (List<String>) status[1];
            String greenColor = "\u001B[32m";
            String redColorCode = "\u001B[31m";
            String resetColorCode = "\u001B[0m";
            System.out.println(resourceMessagingService.getMessage(ResourceBundleEnum.FILES_READY_TO_BE_COMMITED));
            for (int i = 0; i <tracked.size() ; i++){
                System.out.println(greenColor+ "\t" +tracked.get(i) + resetColorCode);
            }
            System.out.println("\n" + "\n");
            System.out.println(resourceMessagingService.getMessage(ResourceBundleEnum.UNTRACKED_FILES) + "\n");
            for (int i = 0; i <untracked.size() ; i++){
                System.out.println(redColorCode+ "\t"+untracked.get(i) + resetColorCode);
            }
            System.out.println();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time " + (endTime - startTime) + " MS");
    }
}
