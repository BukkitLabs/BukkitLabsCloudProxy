package net.bukkitlabs.bukkitlabscloud.core.packet;

import net.bukkitlabs.bukkitlabscloud.core.BukkitLabsCloudProxyCore;
import net.bukkitlabs.bukkitlabscloudapi.internal.event.Listener;
import net.bukkitlabs.bukkitlabscloudapi.internal.event.PacketCatch;
import net.bukkitlabs.bukkitlabscloudapi.socket.packet.ServerRegisterPacket;
import org.jetbrains.annotations.NotNull;

public class RegistrationListener implements Listener {

    private final BukkitLabsCloudProxyCore core;

    public RegistrationListener(@NotNull BukkitLabsCloudProxyCore core) {
        this.core = core;
    }

    @PacketCatch
    public void onServerRegister(ServerRegisterPacket packet) {
        core.getProxy().getAllPlayers().forEach(player -> {
            player.sendMessage("Name: " + packet.getName());
            player.sendMessage("IP: " + packet.getAddress().getHostString());
            player.sendMessage("Port: " + packet.getAddress().getPort());
        });
    }
}
