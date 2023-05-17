package net.bukkitlabs.bukkitlabscloud.core.share;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public abstract class CloudGetter<T extends CloudPlayer> {

    @Nullable
    public T getPlayerByUUID(@NotNull UUID uuid) {
        return this.getAllPlayers()
                .stream()
                .filter(player -> player.getUUID().equals(uuid))
                .findFirst()
                .orElse(null);
    }

    @Nullable
    public T getPlayerByName(@NotNull String name) {
        return this.getAllPlayers()
                .stream()
                .filter(player -> player.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @NotNull
    public abstract List<T> getAllPlayers();

}
