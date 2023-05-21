package net.bukkitlabs.bukkitlabscloud.velocity.share.action;

import net.bukkitlabs.bukkitlabscloud.core.share.action.CloudLogger;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

public class CloudLoggerVelocity implements CloudLogger {

    private final Logger logger;

    public CloudLoggerVelocity(@NotNull Logger logger) {
        this.logger = logger;
    }

    @Override
    public void log(@NotNull Level level, @NotNull String message) {
        switch (level) {
            case INFO -> this.logger.info(message);
            case WARN -> this.logger.warn(message);
            case ERROR -> this.logger.error(message);
        }
    }

    @Override
    public void log(@NotNull Level level, @NotNull String message, @NotNull Exception exception) {
        switch (level) {
            case INFO -> this.logger.info(message, exception);
            case WARN -> this.logger.warn(message, exception);
            case ERROR -> this.logger.error(message, exception);
        }
    }
}
