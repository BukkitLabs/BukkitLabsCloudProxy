package net.bukkitlabs.bukkitlabscloud.velocity.share;

import com.velocitypowered.api.proxy.server.RegisteredServer;
import net.bukkitlabs.bukkitlabscloud.core.share.CloudServer;
import org.jetbrains.annotations.NotNull;

public class CloudServerVelocity implements CloudServer<CloudServerInfoVelocity> {

    private final RegisteredServer server;

    public CloudServerVelocity(@NotNull RegisteredServer server) {
        this.server = server;
    }

    @Override
    public @NotNull CloudServerInfoVelocity getServerInfo() {
        return new CloudServerInfoVelocity(server.getServerInfo());
    }
}
