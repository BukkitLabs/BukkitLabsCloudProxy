package net.bukkitlabs.bukkitlabscloud.bungee.share;

import net.bukkitlabs.bukkitlabscloud.bungee.BukkitLabsCloudProxyBungee;
import net.bukkitlabs.bukkitlabscloud.core.share.Proxy;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ProxyBungee extends Proxy<CloudPlayerBungee, CloudServerBungee> {

    @Override
    public @NotNull List<CloudPlayerBungee> getAllPlayers() {
        return BukkitLabsCloudProxyBungee.getInstance()
                .getProxy()
                .getPlayers()
                .stream()
                .map(CloudPlayerBungee::new)
                .toList();
    }

    @Override
    public @NotNull List<CloudServerBungee> getAllServers() {
        return BukkitLabsCloudProxyBungee.getInstance()
                .getProxy()
                .getServers()
                .values()
                .stream()
                .map(CloudServerBungee::new)
                .toList();
    }

    @Override
    public void addServer(@NotNull CloudServerBungee server) {
        BukkitLabsCloudProxyBungee.getInstance()
                .getProxy()
                .getServers()
                .put(server.getName(), server.getServerInfo());
    }
}
