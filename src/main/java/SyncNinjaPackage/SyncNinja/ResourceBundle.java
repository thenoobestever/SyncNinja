package SyncNinjaPackage.SyncNinja;

public enum ResourceBundle {
    DIRECTORY_ALREADY_INITIALIZED("This directory has already been initialized."),
    INVALID_INPUT("Invalid input provided.");

    private final String message;

    ResourceBundle(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
