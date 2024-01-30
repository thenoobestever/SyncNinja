package SyncNinjaPackage.syncNinja.util;

import java.util.ResourceBundle;

public enum ResourceBundleEnum {
    DIRECTORY_ALREADY_INITIALIZED,
    INVALID_INPUT;

    final ResourceBundle resourceBundle = ResourceBundle.getBundle("messages");

    public String getMessage(){
        String key = this.name().toLowerCase();
        return resourceBundle.getString(key);
    }
}
