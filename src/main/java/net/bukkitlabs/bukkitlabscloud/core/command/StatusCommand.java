package net.bukkitlabs.bukkitlabscloud.core.command;

import net.bukkitlabs.bukkitlabscloud.core.BukkitLabsCloudProxyCore;
import net.bukkitlabs.bukkitlabscloud.core.share.action.CloudCommand;
import net.bukkitlabs.bukkitlabscloud.core.share.object.CloudPlayer;
import net.bukkitlabs.bukkitlabscloud.core.share.object.CloudSource;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class StatusCommand implements CloudCommand {

    private final BukkitLabsCloudProxyCore core;

    public StatusCommand(@NotNull BukkitLabsCloudProxyCore core) {
        this.core = core;
    }

    @Override
    public void onCommand(@NotNull CloudSource source, @NotNull String label, @NotNull String permission, String[] args) {
        if (!source.hasPermission(permission)) {
            source.sendMessage("&cYou don't have the permission to perform this command!");
            return;
        }
        if (!(source instanceof CloudPlayer<?> player)) {
            source.sendMessage("&cOnly a Player can perform this command!");
            return;
        }
        player.sendMessage("&7Status: &cDisconnected");
        try {
            this.core.getClient().stopServer();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
