package net.bukkitlabs.bukkitlabscloud.bungee.share.action;

import net.bukkitlabs.bukkitlabscloud.bungee.BukkitLabsCloudProxyBungee;
import net.bukkitlabs.bukkitlabscloud.bungee.share.object.CloudSourceBungee;
import net.bukkitlabs.bukkitlabscloud.core.share.action.CloudCommand;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.TabExecutor;
import org.jetbrains.annotations.NotNull;

public class CloudCommandBungee extends Command implements TabExecutor {

    private final CloudCommand cloudCommand;
    private final String name;
    private final String permission;

    public CloudCommandBungee(@NotNull CloudCommand cloudCommand, @NotNull String name, @NotNull String permission, @NotNull String... aliases) {
        super(name, permission, aliases);
        this.cloudCommand = cloudCommand;
        this.name = name;
        this.permission = permission;
        BukkitLabsCloudProxyBungee.getInstance()
                .getProxy()
                .getPluginManager()
                .registerCommand(BukkitLabsCloudProxyBungee.getInstance(), this);
    }

    @Override
    public void execute(CommandSender commandSender, String[] strings) {
        cloudCommand.onCommand(
                new CloudSourceBungee(commandSender),
                this.name,
                this.permission,
                strings
        );
    }

    @Override
    public Iterable<String> onTabComplete(CommandSender commandSender, String[] strings) {
        return cloudCommand.onTab(
                new CloudSourceBungee(commandSender),
                this.name,
                this.permission,
                strings
        );
    }

    @NotNull
    public CloudCommand getCloudCommand() {
        return cloudCommand;
    }
}
