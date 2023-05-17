package net.bukkitlabs.bukkitlabscloud.bungee;

import net.md_5.bungee.api.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public final class BukkitLabsCloudProxyBungee extends Plugin {

    private static BukkitLabsCloudProxyBungee instance;

    @Override
    public void onEnable() {
        BukkitLabsCloudProxyBungee.setInstance(this);
    }

    @Override
    public void onDisable() {

    }

    @NotNull
    public static BukkitLabsCloudProxyBungee getInstance() {
        return instance;
    }

    private static void setInstance(@NotNull BukkitLabsCloudProxyBungee instance) {
        BukkitLabsCloudProxyBungee.instance = instance;
    }
}
