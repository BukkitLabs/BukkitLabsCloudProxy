package net.bukkitlabs.bukkitlabscloud.velocity.share;

import com.velocitypowered.api.proxy.server.RegisteredServer;
import net.bukkitlabs.bukkitlabscloud.core.share.CloudGetter;
import net.bukkitlabs.bukkitlabscloud.velocity.BukkitLabsCloudProxyVelocity;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CloudGetterVelocity extends CloudGetter<CloudPlayerVelocity, CloudServerVelocity> {

    @Override
    public @NotNull List<CloudPlayerVelocity> getAllPlayers() {
        return BukkitLabsCloudProxyVelocity.getInstance()
                .getServer()
                .getAllPlayers()
                .stream()
                .map(CloudPlayerVelocity::new)
                .toList();
    }

    @Override
    public @NotNull List<CloudServerVelocity> getAllServers() {
        return BukkitLabsCloudProxyVelocity.getInstance()
                .getServer()
                .getAllServers()
                .stream()
                .map(RegisteredServer::getServerInfo)
                .map(CloudServerVelocity::new)
                .toList();
    }
}
