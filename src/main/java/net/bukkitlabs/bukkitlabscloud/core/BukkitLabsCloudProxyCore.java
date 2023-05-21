package net.bukkitlabs.bukkitlabscloud.core;

import net.bukkitlabs.bukkitlabscloud.core.command.StatusCommand;
import net.bukkitlabs.bukkitlabscloud.core.packet.RegistrationListener;
import net.bukkitlabs.bukkitlabscloud.core.share.Proxy;
import net.bukkitlabs.bukkitlabscloud.core.share.action.CloudLogger;
import net.bukkitlabs.bukkitlabscloudapi.internal.event.PacketHandler;
import net.bukkitlabs.bukkitlabscloudapi.socket.client.PacketCommunicationClient;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class BukkitLabsCloudProxyCore {

    private CloudLogger logger;
    private final Proxy<?, ?, ?> proxy;
    private final PacketHandler packetHandler = new PacketHandler();
    private final PacketCommunicationClient client = new PacketCommunicationClient();

    public BukkitLabsCloudProxyCore(@NotNull Proxy<?, ?, ?> proxy) {
        this.proxy = proxy;
    }

    public void onEnable() {
        this.logger = this.proxy.getLogger();
        this.proxy.registerCommand(new StatusCommand(this), "status", "bukkitlabs.cloud.status");
        this.packetHandler.registerListener(new RegistrationListener(this));

        try {
            this.client.initialize("127.0.0.1", 8888, packetHandler);
            this.client.start();
            getLogger().log(CloudLogger.Level.INFO, "Client started!");
        } catch (IOException exception) {
            getLogger().log(CloudLogger.Level.ERROR, "Client can't connect with Master: ", exception);
        }
    }

    public void onDisable() {
        this.client.stop();
    }

    @NotNull
    public Proxy<?, ?, ?> getProxy() {
        return proxy;
    }

    @NotNull
    public CloudLogger getLogger() {
        return logger;
    }

    @NotNull
    public PacketCommunicationClient getClient() {
        return client;
    }
}
