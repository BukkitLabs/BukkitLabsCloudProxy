package net.bukkitlabs.bukkitlabscloud.core.share;

import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public interface CloudPlayer extends CloudSource {

    @NotNull
    UUID getUUID();

    @NotNull
    String getName();
}
