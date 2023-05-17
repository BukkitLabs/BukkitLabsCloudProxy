package net.bukkitlabs.bukkitlabscloud.velocity;

import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.event.proxy.ProxyShutdownEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.plugin.annotation.DataDirectory;
import com.velocitypowered.api.proxy.ProxyServer;
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

    private final ProxyServer server;
    private final Logger logger;
    private final Path dataDirectory;

    @Inject
    public BukkitLabsCloudProxyVelocity(ProxyServer server, Logger logger, @DataDirectory Path dataDirectory) {
        this.server = server;
        this.logger = logger;
        this.dataDirectory = dataDirectory;
    }

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {

    }

    @Subscribe
    public void onProxyShutdown(ProxyShutdownEvent event) {

    }
}
