package net.bukkitlabs.bukkitlabscloud.core.event;

import net.bukkitlabs.bukkitlabscloud.core.BukkitLabsCloudProxyCore;
import net.bukkitlabs.bukkitlabscloud.core.share.action.CloudLogger;
import net.bukkitlabs.bukkitlabscloud.core.share.object.CloudPlayer;
import net.bukkitlabs.bukkitlabscloud.core.util.ClassWrapper;
import net.bukkitlabs.bukkitlabscloudapi.internal.event.PacketCannotBeProcessedException;
import net.bukkitlabs.bukkitlabscloudapi.socket.packet.PlayerJoinPacket;
import net.bukkitlabs.bukkitlabscloudapi.socket.packet.PlayerQuitPacket;
import org.jetbrains.annotations.NotNull;

public class PlayerConnectListener {

    private final BukkitLabsCloudProxyCore core;

    public PlayerConnectListener(BukkitLabsCloudProxyCore core) {
        this.core = core;
    }

    public void onPlayerJoin(@NotNull final CloudPlayer<?> cloudPlayer) {
        try {
            core.getClient().getPacketHandler().call(new PlayerJoinPacket(
                    ClassWrapper.toBukkitLabsPlayer(cloudPlayer)
            ));
        } catch (PacketCannotBeProcessedException exception) {
            core.getLogger().log(CloudLogger.Level.ERROR, "Join packet can't be send: ", exception);
        }
    }

    public void onPlayerQuit(@NotNull final CloudPlayer<?> cloudPlayer) {
        try {
            core.getClient().getPacketHandler().call(new PlayerQuitPacket(
                    ClassWrapper.toBukkitLabsPlayer(cloudPlayer)
            ));
        } catch (PacketCannotBeProcessedException exception) {
            core.getLogger().log(CloudLogger.Level.ERROR, "Join packet can't be send: ", exception);
        }
    }
}
