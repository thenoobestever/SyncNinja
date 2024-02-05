package SyncNinjaPackage.syncNinja.service;

import SyncNinjaPackage.syncNinja.util.ResourceBundleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class ResourceMessagingService {
    @Autowired
    private MessageSource messageSource;

    public String getMessage(ResourceBundleEnum resourceBundleEnum) {
        return messageSource.getMessage(resourceBundleEnum.getKey(), new Object[]{}, Locale.getDefault());
    }

    public String getMessage(ResourceBundleEnum resourceBundleEnum, Object[] args) {
        return messageSource.getMessage(resourceBundleEnum.getKey(), args, Locale.getDefault());
    }
}
