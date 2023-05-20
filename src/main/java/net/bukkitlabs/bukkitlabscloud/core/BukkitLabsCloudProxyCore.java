package net.bukkitlabs.bukkitlabscloud.core;

import net.bukkitlabs.bukkitlabscloud.core.command.StatusCommand;
import net.bukkitlabs.bukkitlabscloud.core.share.Proxy;
import org.jetbrains.annotations.NotNull;

public class BukkitLabsCloudProxyCore {

    private final Proxy<?, ?> proxy;

    public BukkitLabsCloudProxyCore(@NotNull Proxy<?, ?> proxy) {
        this.proxy = proxy;
    }

    public void onEnable() {
        this.proxy.registerCommand(new StatusCommand(), "status", "bukkitlabs.cloud.status");
    }

    public void onDisable() {

    }
}
