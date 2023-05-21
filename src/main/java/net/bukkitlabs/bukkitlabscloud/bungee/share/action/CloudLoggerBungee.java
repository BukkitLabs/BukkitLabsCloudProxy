package net.bukkitlabs.bukkitlabscloud.bungee.share.action;

import net.bukkitlabs.bukkitlabscloud.core.share.action.CloudLogger;
import org.jetbrains.annotations.NotNull;

import java.util.logging.Logger;

public class CloudLoggerBungee implements CloudLogger {

    private final Logger logger;

    public CloudLoggerBungee(@NotNull Logger logger) {
        this.logger = logger;
    }

    @Override
    public void log(@NotNull Level level, @NotNull String message) {
        switch (level) {
            case INFO -> this.logger.info(message);
            case WARN -> this.logger.warning(message);
            case ERROR -> this.logger.severe(message);
        }
    }
}
