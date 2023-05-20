package net.bukkitlabs.bukkitlabscloud.bungee.share.object;

import net.bukkitlabs.bukkitlabscloud.core.share.object.CloudServer;
import net.md_5.bungee.api.config.ServerInfo;
import org.jetbrains.annotations.NotNull;

import java.net.SocketAddress;

public class CloudServerBungee implements CloudServer {

    private final ServerInfo serverInfo;

    public CloudServerBungee(@NotNull ServerInfo serverInfo) {
        this.serverInfo = serverInfo;
    }

    @Override
    public @NotNull String getName() {
        return serverInfo.getName();
    }

    @Override
    public @NotNull SocketAddress getAddress() {
        return serverInfo.getSocketAddress();
    }

    public ServerInfo getServerInfo() {
        return serverInfo;
    }
}
