package net.bukkitlabs.bukkitlabscloud.velocity.share;

import com.velocitypowered.api.command.CommandSource;
import de.rytrox.impulse.color.ChatColor;
import net.bukkitlabs.bukkitlabscloud.core.share.CloudSource;
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
}
