package net.bukkitlabs.bukkitlabscloud.bungee.share;

import net.bukkitlabs.bukkitlabscloud.core.share.CloudSource;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.ComponentBuilder;
import org.jetbrains.annotations.NotNull;

public class CloudSourceBungee implements CloudSource {

    private final CommandSender sender;

    public CloudSourceBungee(@NotNull CommandSender sender) {
        this.sender = sender;
    }

    @Override
    public void sendMessage(@NotNull String message) {
        sender.sendMessage(new ComponentBuilder(ChatColor.translateAlternateColorCodes('&', message)).create());
    }
}
