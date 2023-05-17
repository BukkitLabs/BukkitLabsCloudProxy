package net.bukkitlabs.bukkitlabscloud.bungee.share;

import net.bukkitlabs.bukkitlabscloud.core.share.CloudPlayer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class CloudPlayerBungee extends CloudSourceBungee implements CloudPlayer {

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
}
