package net.bukkitlabs.bukkitlabscloud.core.share;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public interface CloudGetter {

    @Nullable
    CloudPlayer getPlayerByUUID(@NotNull UUID uuid);

    @Nullable
    CloudPlayer getPlayerByName(@NotNull String name);

    @NotNull
    List<CloudPlayer> getAllPlayers();

}
