package net.bukkitlabs.bukkitlabscloud.bungee.share;

import net.bukkitlabs.bukkitlabscloud.core.share.CloudServer;
import net.md_5.bungee.api.connection.Server;
import org.jetbrains.annotations.NotNull;

public class CloudServerBungee implements CloudServer<CloudServerInfoBungee> {

    private final Server server;

    public CloudServerBungee(@NotNull Server server) {
        this.server = server;
    }

    @Override
    public @NotNull CloudServerInfoBungee getServerInfo() {
        return new CloudServerInfoBungee(server.getInfo());
    }
}
