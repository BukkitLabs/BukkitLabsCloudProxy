package net.bukkitlabs.bukkitlabscloud.velocity.event;

import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.connection.DisconnectEvent;
import com.velocitypowered.api.event.connection.LoginEvent;
import net.bukkitlabs.bukkitlabscloud.core.BukkitLabsCloudProxyCore;
import net.bukkitlabs.bukkitlabscloud.core.event.PlayerConnectListener;
import net.bukkitlabs.bukkitlabscloud.velocity.share.object.CloudPlayerVelocity;
import org.jetbrains.annotations.NotNull;

public class PlayerConnectListenerVelocity {

    private final PlayerConnectListener listener;

    public PlayerConnectListenerVelocity(@NotNull final BukkitLabsCloudProxyCore core) {
        this.listener = new PlayerConnectListener(core);
    }

    @Subscribe
    public void onPlayerConnect(LoginEvent event) {
        listener.onPlayerJoin(new CloudPlayerVelocity(event.getPlayer()));
    }

    @Subscribe
    public void onPlayerDisconnect(DisconnectEvent event) {
        listener.onPlayerQuit(new CloudPlayerVelocity(event.getPlayer()));
    }
}