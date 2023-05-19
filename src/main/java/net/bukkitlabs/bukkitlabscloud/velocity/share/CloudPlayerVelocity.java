package net.bukkitlabs.bukkitlabscloud.velocity.share;

import com.velocitypowered.api.proxy.Player;
import com.velocitypowered.api.proxy.ServerConnection;
import com.velocitypowered.api.proxy.server.RegisteredServer;
import net.bukkitlabs.bukkitlabscloud.core.share.CloudPlayer;
import net.bukkitlabs.bukkitlabscloud.velocity.BukkitLabsCloudProxyVelocity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class CloudPlayerVelocity extends CloudSourceVelocity implements CloudPlayer<CloudServerVelocity> {

    private final Player player;

    public CloudPlayerVelocity(@NotNull Player player) {
        super(player);
        this.player = player;
    }

    @Override
    public @NotNull UUID getUUID() {
        return player.getUniqueId();
    }

    @Override
    public @NotNull String getName() {
        return player.getUsername();
    }

    @Override
    public @Nullable CloudServerVelocity getServer() {
        final ServerConnection server = player.getCurrentServer().orElse(null);
        return server == null ? null : new CloudServerVelocity(server.getServerInfo());
    }

    @Override
    public void connect(@NotNull CloudServerVelocity server) {
        final RegisteredServer registeredServer = BukkitLabsCloudProxyVelocity.getInstance()
                .getServer()
                .getServer(server.getName())
                .orElse(null);
        if (registeredServer == null) return;
        player.createConnectionRequest(registeredServer).connect();
    }
}
