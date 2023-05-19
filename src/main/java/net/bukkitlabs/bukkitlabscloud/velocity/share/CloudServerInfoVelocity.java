package net.bukkitlabs.bukkitlabscloud.velocity.share;

import com.velocitypowered.api.proxy.server.ServerInfo;
import net.bukkitlabs.bukkitlabscloud.core.share.CloudServerInfo;
import org.jetbrains.annotations.NotNull;

import java.net.InetSocketAddress;

public class CloudServerInfoVelocity implements CloudServerInfo {

    private final ServerInfo serverInfo;

    public CloudServerInfoVelocity(@NotNull ServerInfo serverInfo) {
        this.serverInfo = serverInfo;
    }

    @Override
    public @NotNull String getName() {
        return serverInfo.getName();
    }

    @Override
    public @NotNull InetSocketAddress getAddress() {
        return serverInfo.getAddress();
    }
}
