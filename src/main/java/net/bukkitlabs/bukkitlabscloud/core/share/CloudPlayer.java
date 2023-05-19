package net.bukkitlabs.bukkitlabscloud.core.share;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public interface CloudPlayer<T extends CloudServer> extends CloudSource {

    @NotNull
    UUID getUUID();

    @NotNull
    String getName();

    @Nullable
    T getServer();

    void connect(@NotNull T server);
}
