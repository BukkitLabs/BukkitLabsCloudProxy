package net.bukkitlabs.bukkitlabscloud.bungee.share.object;

import net.bukkitlabs.bukkitlabscloud.core.share.object.CloudPlayer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class CloudPlayerBungee extends CloudSourceBungee implements CloudPlayer<CloudServerBungee> {

    private final ProxiedPlayer player;

    public CloudPlayerBungee(@NotNull ProxiedPlayer player) {
        super(player);
        this.player = player;
    }

    @Override
    public @NotNull UUID getUUID() {
        return player.getUniqueId();
    }

    @Override
    public @NotNull String getName() {
        return player.getName();
    }

    @Override
    public @Nullable CloudServerBungee getServer() {
        return new CloudServerBungee(player.getServer().getInfo());
    }

    @Override
    public boolean hasPermission(@NotNull String permission) {
        return player.hasPermission(permission);
    }

    @Override
    public void connect(@NotNull CloudServerBungee server) {
        player.connect(server.getServerInfo());
    }
}
