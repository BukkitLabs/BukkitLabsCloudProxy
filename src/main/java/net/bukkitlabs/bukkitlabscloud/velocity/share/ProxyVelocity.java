package net.bukkitlabs.bukkitlabscloud.velocity.share;

import com.velocitypowered.api.proxy.server.RegisteredServer;
import com.velocitypowered.api.proxy.server.ServerInfo;
import net.bukkitlabs.bukkitlabscloud.core.share.Proxy;
import net.bukkitlabs.bukkitlabscloud.core.share.action.CloudCommand;
import net.bukkitlabs.bukkitlabscloud.velocity.BukkitLabsCloudProxyVelocity;
import net.bukkitlabs.bukkitlabscloud.velocity.share.action.CloudCommandVelocity;
import net.bukkitlabs.bukkitlabscloud.velocity.share.object.CloudPlayerVelocity;
import net.bukkitlabs.bukkitlabscloud.velocity.share.object.CloudServerVelocity;
import org.jetbrains.annotations.NotNull;

import java.net.InetSocketAddress;
import java.util.List;

public class ProxyVelocity implements Proxy<CloudPlayerVelocity, CloudServerVelocity> {

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

    @Override
    public void addServer(@NotNull CloudServerVelocity server) {
        BukkitLabsCloudProxyVelocity.getInstance()
                .getServer()
                .registerServer(server.getServerInfo());
    }

    @Override
    public void removeServer(@NotNull CloudServerVelocity server) {
        BukkitLabsCloudProxyVelocity.getInstance()
                .getServer()
                .unregisterServer(server.getServerInfo());
    }

    @Override
    public @NotNull CloudServerVelocity constructServer(@NotNull String name, @NotNull InetSocketAddress address) {
        return new CloudServerVelocity(new ServerInfo(name, address));
    }

    @Override
    public void registerCommand(@NotNull CloudCommand cloudCommand, @NotNull String name, @NotNull String permission, @NotNull String... aliases) {
        new CloudCommandVelocity(cloudCommand, name, permission, aliases);
    }
}
