package net.bukkitlabs.bukkitlabscloud.core.util;

import net.bukkitlabs.bukkitlabscloud.core.share.object.CloudPlayer;
import net.bukkitlabs.bukkitlabscloudapi.socket.model.BukkitLabsPlayer;
import org.jetbrains.annotations.NotNull;

public class ClassWrapper {

    private ClassWrapper() {
    }

    @NotNull
    public static BukkitLabsPlayer toBukkitLabsPlayer(@NotNull final CloudPlayer<?> cloudPlayer) {
        return new BukkitLabsPlayer(
                cloudPlayer.getUUID(),
                cloudPlayer.getName(),
                cloudPlayer.getIP(),
                cloudPlayer.getServer() == null ?
                        null :
                        cloudPlayer.getServer().getName()
        );
    }
}
