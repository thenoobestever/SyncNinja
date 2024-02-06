package SyncNinjaPackage.syncNinja.util;

import org.springframework.context.MessageSource;
import java.util.Locale;

public enum ResourceBundleEnum {
    DIRECTORY_ALREADY_INITIALIZED("directory_already_initialized"),
    INVALID_INPUT("invalid_input"),
    DIRECTORY_NOT_INITIALIZED("directory_not_initialized"),
    BRANCH_NAME_EXISTS("branch_name_exists");

    private final String key;

    ResourceBundleEnum(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
