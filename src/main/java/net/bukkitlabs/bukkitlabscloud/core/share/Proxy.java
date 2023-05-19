package net.bukkitlabs.bukkitlabscloud.core.share;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.net.SocketAddress;
import java.util.List;
import java.util.UUID;

public abstract class Proxy<T extends CloudPlayer, V extends CloudServer> {

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

    @Nullable
    public V getServerByName(@NotNull String name) {
        return this.getAllServers()
                .stream()
                .filter(server -> server.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Nullable
    public V getServerByName(@NotNull SocketAddress address) {
        return this.getAllServers()
                .stream()
                .filter(server -> server.getAddress().equals(address))
                .findFirst()
                .orElse(null);
    }

    @NotNull
    public abstract List<T> getAllPlayers();

    @NotNull
    public abstract List<V> getAllServers();

    public abstract void addServer(@NotNull V server);
}
