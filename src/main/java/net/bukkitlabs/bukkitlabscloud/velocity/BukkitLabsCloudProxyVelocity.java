package net.bukkitlabs.bukkitlabscloud.velocity;

import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.event.proxy.ProxyShutdownEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.plugin.annotation.DataDirectory;
import com.velocitypowered.api.proxy.ProxyServer;
import net.bukkitlabs.bukkitlabscloud.core.BukkitLabsCloudProxyCore;
import net.bukkitlabs.bukkitlabscloud.velocity.event.PlayerConnectListenerVelocity;
import net.bukkitlabs.bukkitlabscloud.velocity.share.ProxyVelocity;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

import java.nio.file.Path;

@Plugin(
        id = "bukkitlabscloudproxy",
        name = "BukkitLabsCloudProxy",
        version = "1.0.0",
        description = "The Proxy Plugin for the BukkitLabsCloud",
        url = "bukkitlabs.net",
        authors = {"Asedem", "Finn"}
)
public class BukkitLabsCloudProxyVelocity {

    private static BukkitLabsCloudProxyVelocity instance;
    private final ProxyServer server;
    private final Logger logger;
    private final Path dataDirectory;
    private BukkitLabsCloudProxyCore bukkitLabsCloudProxyCore;

    @Inject
    public BukkitLabsCloudProxyVelocity(ProxyServer server, Logger logger, @DataDirectory Path dataDirectory) {
        this.server = server;
        this.logger = logger;
        this.dataDirectory = dataDirectory;
    }

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        setInstance(this);
        this.bukkitLabsCloudProxyCore = new BukkitLabsCloudProxyCore(new ProxyVelocity());
        this.bukkitLabsCloudProxyCore.onEnable();

        this.getServer().getEventManager().register(this, new PlayerConnectListenerVelocity(this.bukkitLabsCloudProxyCore));
    }

    @Subscribe
    public void onProxyShutdown(ProxyShutdownEvent event) {
        this.bukkitLabsCloudProxyCore.onDisable();
    }

    @NotNull
    public static BukkitLabsCloudProxyVelocity getInstance() {
        return instance;
    }

    private static void setInstance(@NotNull BukkitLabsCloudProxyVelocity instance) {
        BukkitLabsCloudProxyVelocity.instance = instance;
    }

    public ProxyServer getServer() {
        return server;
    }

    public Logger getLogger() {
        return logger;
    }

    public Path getDataDirectory() {
        return dataDirectory;
    }
}
