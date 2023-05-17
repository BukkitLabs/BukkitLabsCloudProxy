package net.bukkitlabs.bukkitlabscloud.velocity.share;

import net.bukkitlabs.bukkitlabscloud.core.share.CloudGetter;
import net.bukkitlabs.bukkitlabscloud.velocity.BukkitLabsCloudProxyVelocity;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CloudGetterVelocity extends CloudGetter<CloudPlayerVelocity> {

    @Override
    public @NotNull List<CloudPlayerVelocity> getAllPlayers() {
        return BukkitLabsCloudProxyVelocity.getInstance()
                .getServer()
                .getAllPlayers()
                .stream()
                .map(CloudPlayerVelocity::new)
                .toList();
    }
}
