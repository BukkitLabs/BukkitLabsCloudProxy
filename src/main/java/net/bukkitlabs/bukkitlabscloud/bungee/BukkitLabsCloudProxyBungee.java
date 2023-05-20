package net.bukkitlabs.bukkitlabscloud.bungee;

import net.bukkitlabs.bukkitlabscloud.bungee.share.ProxyBungee;
import net.bukkitlabs.bukkitlabscloud.core.BukkitLabsCloudProxyCore;
import net.md_5.bungee.api.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public final class BukkitLabsCloudProxyBungee extends Plugin {

    private static BukkitLabsCloudProxyBungee instance;
    private BukkitLabsCloudProxyCore bukkitLabsCloudProxyCore;

    @Override
    public void onEnable() {
        BukkitLabsCloudProxyBungee.setInstance(this);
        this.bukkitLabsCloudProxyCore = new BukkitLabsCloudProxyCore(new ProxyBungee());
        this.bukkitLabsCloudProxyCore.onEnable();
    }

    @Override
    public void onDisable() {
        this.bukkitLabsCloudProxyCore.onDisable();
    }

    @NotNull
    public static BukkitLabsCloudProxyBungee getInstance() {
        return instance;
    }

    private static void setInstance(@NotNull BukkitLabsCloudProxyBungee instance) {
        BukkitLabsCloudProxyBungee.instance = instance;
    }
}
