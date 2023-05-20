package net.bukkitlabs.bukkitlabscloud.core.command;

import net.bukkitlabs.bukkitlabscloud.core.share.action.CloudCommand;
import net.bukkitlabs.bukkitlabscloud.core.share.object.CloudPlayer;
import net.bukkitlabs.bukkitlabscloud.core.share.object.CloudSource;
import org.jetbrains.annotations.NotNull;

public class StatusCommand implements CloudCommand {

    @Override
    public void onCommand(@NotNull CloudSource source, @NotNull String label, @NotNull String permission, String[] args) {
        if (!source.hasPermission(permission)) {
            source.sendMessage("&cYou don't have the permission to perform this command!");
            return;
        }
        if (!(source instanceof CloudPlayer<?> cloudPlayer)) {
            source.sendMessage("&cOnly a Player can perform this command!");
            return;
        }
        cloudPlayer.sendMessage("&7Status: &cDisconnected");
    }
}
