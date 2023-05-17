package net.bukkitlabs.bukkitlabscloud.velocity.share;

import com.velocitypowered.api.proxy.Player;
import net.bukkitlabs.bukkitlabscloud.core.share.CloudPlayer;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class CloudPlayerVelocity extends CloudSourceVelocity implements CloudPlayer {

    private final Player player;

    public CloudPlayerVelocity(@NotNull Player player) {
        super(player);
        this.player = player;
    }

    @Override
    public @NotNull UUID getUUID() {
        return player.getUniqueId();
    }

    @Override
    public @NotNull String getName() {
        return player.getUsername();
    }
}
