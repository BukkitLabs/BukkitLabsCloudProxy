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
            case INFO -> this.logger.log(java.util.logging.Level.INFO, message);
            case WARN -> this.logger.log(java.util.logging.Level.WARNING, message);
            case ERROR -> this.logger.log(java.util.logging.Level.SEVERE, message);
        }
    }

    @Override
    public void log(@NotNull Level level, @NotNull String message, @NotNull Exception exception) {
        switch (level) {
            case INFO -> this.logger.log(java.util.logging.Level.INFO, message, exception);
            case WARN -> this.logger.log(java.util.logging.Level.WARNING, message, exception);
            case ERROR -> this.logger.log(java.util.logging.Level.SEVERE, message, exception);
        }
    }
}
