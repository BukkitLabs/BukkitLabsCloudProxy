package net.bukkitlabs.bukkitlabscloud.core.share.object;

import org.jetbrains.annotations.NotNull;

public interface CloudSource {

    void sendMessage(@NotNull String message);

    boolean hasPermission(@NotNull String permission);
}
