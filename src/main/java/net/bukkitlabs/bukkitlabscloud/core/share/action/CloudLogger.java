package net.bukkitlabs.bukkitlabscloud.core.share.action;

import org.jetbrains.annotations.NotNull;

public interface CloudLogger {

    void log(@NotNull Level level, @NotNull String message);

    enum Level {
        INFO,
        WARN,
        ERROR
    }
}
