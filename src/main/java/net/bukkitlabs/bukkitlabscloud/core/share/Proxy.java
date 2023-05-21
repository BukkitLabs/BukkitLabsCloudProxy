package net.bukkitlabs.bukkitlabscloud.core.share;

import net.bukkitlabs.bukkitlabscloud.core.share.action.CloudCommand;
import net.bukkitlabs.bukkitlabscloud.core.share.action.CloudLogger;
import net.bukkitlabs.bukkitlabscloud.core.share.object.CloudPlayer;
import net.bukkitlabs.bukkitlabscloud.core.share.object.CloudServer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.List;
import java.util.UUID;

public interface Proxy<T extends CloudPlayer, V extends CloudServer, K extends CloudLogger> {

    @Nullable
    default T getPlayerByUUID(@NotNull UUID uuid) {
        return this.getAllPlayers()
                .stream()
                .filter(player -> player.getUUID().equals(uuid))
                .findFirst()
                .orElse(null);
    }

    @Nullable
    default T getPlayerByName(@NotNull String name) {
        return this.getAllPlayers()
                .stream()
                .filter(player -> player.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Nullable
    default V getServerByName(@NotNull String name) {
        return this.getAllServers()
                .stream()
                .filter(server -> server.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Nullable
    default V getServerByName(@NotNull SocketAddress address) {
        return this.getAllServers()
                .stream()
                .filter(server -> server.getAddress().equals(address))
                .findFirst()
                .orElse(null);
    }

    @NotNull
    List<T> getAllPlayers();

    @NotNull
    List<V> getAllServers();

    void addServer(@NotNull V server);

    void removeServer(@NotNull V server);

    @NotNull
    V constructServer(@NotNull String name, @NotNull InetSocketAddress address);

    void registerCommand(@NotNull CloudCommand cloudCommand, @NotNull String name, @NotNull String permission, @NotNull String... aliases);

    @NotNull
    K getLogger();
}
