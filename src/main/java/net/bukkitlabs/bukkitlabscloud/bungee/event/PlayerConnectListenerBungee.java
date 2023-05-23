package net.bukkitlabs.bukkitlabscloud.bungee.event;

import net.bukkitlabs.bukkitlabscloud.bungee.share.object.CloudPlayerBungee;
import net.bukkitlabs.bukkitlabscloud.core.BukkitLabsCloudProxyCore;
import net.bukkitlabs.bukkitlabscloud.core.event.PlayerConnectListener;
import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.event.ServerConnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import org.jetbrains.annotations.NotNull;

public class PlayerConnectListenerBungee implements Listener {

    private final PlayerConnectListener listener;

    public PlayerConnectListenerBungee(@NotNull final BukkitLabsCloudProxyCore core) {
        this.listener = new PlayerConnectListener(core);
    }

    @EventHandler
    public void onPlayerConnect(ServerConnectEvent event) {
        this.listener.onPlayerJoin(new CloudPlayerBungee(event.getPlayer()));
    }

    @EventHandler
    public void onPlayerDisconnect(PlayerDisconnectEvent event) {
        this.listener.onPlayerQuit(new CloudPlayerBungee(event.getPlayer()));
    }
}
