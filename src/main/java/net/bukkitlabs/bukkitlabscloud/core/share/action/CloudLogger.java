package net.bukkitlabs.bukkitlabscloud.core.share.action;

import org.jetbrains.annotations.NotNull;

public interface CloudLogger {

    void log(@NotNull Level level, @NotNull String message);

    void log(@NotNull Level level, @NotNull String message, @NotNull Exception exception);

    enum Level {
        INFO,
        WARN,
        ERROR
    }
}
