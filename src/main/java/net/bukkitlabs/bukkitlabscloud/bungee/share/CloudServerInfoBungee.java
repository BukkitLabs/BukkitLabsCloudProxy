package net.bukkitlabs.bukkitlabscloud.bungee.share;

import net.bukkitlabs.bukkitlabscloud.core.share.CloudServerInfo;
import net.md_5.bungee.api.config.ServerInfo;
import org.jetbrains.annotations.NotNull;

import java.net.SocketAddress;

public class CloudServerInfoBungee implements CloudServerInfo {

    private final ServerInfo serverInfo;

    public CloudServerInfoBungee(@NotNull ServerInfo serverInfo) {
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
}
