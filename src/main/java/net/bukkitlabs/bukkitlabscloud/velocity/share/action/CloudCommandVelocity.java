package net.bukkitlabs.bukkitlabscloud.velocity.share.action;

import com.velocitypowered.api.command.SimpleCommand;
import net.bukkitlabs.bukkitlabscloud.core.share.action.CloudCommand;
import net.bukkitlabs.bukkitlabscloud.velocity.BukkitLabsCloudProxyVelocity;
import net.bukkitlabs.bukkitlabscloud.velocity.share.object.CloudSourceVelocity;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CloudCommandVelocity implements SimpleCommand {

    private final CloudCommand cloudCommand;
    private final String name;
    private final String permission;

    public CloudCommandVelocity(@NotNull CloudCommand cloudCommand, @NotNull String name, @NotNull String permission, @NotNull String... aliases) {
        this.cloudCommand = cloudCommand;
        this.name = name;
        this.permission = permission;
        BukkitLabsCloudProxyVelocity.getInstance()
                .getServer()
                .getCommandManager()
                .register(BukkitLabsCloudProxyVelocity.getInstance()
                        .getServer()
                        .getCommandManager()
                        .metaBuilder(name)
                        .aliases(aliases)
                        .build(), this);
    }

    @Override
    public void execute(Invocation invocation) {
        cloudCommand.onCommand(
                new CloudSourceVelocity(invocation.source()),
                this.name,
                this.permission,
                invocation.arguments()
        );
    }

    @Override
    public List<String> suggest(Invocation invocation) {
        return cloudCommand.onTab(
                new CloudSourceVelocity(invocation.source()),
                this.name,
                this.permission,
                invocation.arguments()
        );
    }

    @NotNull
    public CloudCommand getCloudCommand() {
        return cloudCommand;
    }
}
