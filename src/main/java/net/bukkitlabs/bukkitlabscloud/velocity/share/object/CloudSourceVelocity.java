package net.bukkitlabs.bukkitlabscloud.velocity.share.object;

import com.velocitypowered.api.command.CommandSource;
import de.rytrox.impulse.color.ChatColor;
import net.bukkitlabs.bukkitlabscloud.core.share.object.CloudSource;
import org.jetbrains.annotations.NotNull;

public class CloudSourceVelocity implements CloudSource {

    private final CommandSource source;

    public CloudSourceVelocity(@NotNull CommandSource source) {
        this.source = source;
    }

    @Override
    public void sendMessage(@NotNull String message) {
        source.sendMessage(ChatColor.translate('&', message));
    }

    @Override
    public boolean hasPermission(@NotNull String permission) {
        return true;
    }
}
