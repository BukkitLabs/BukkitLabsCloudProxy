package net.bukkitlabs.bukkitlabscloud.bungee.share;

import net.bukkitlabs.bukkitlabscloud.bungee.BukkitLabsCloudProxyBungee;
import net.bukkitlabs.bukkitlabscloud.core.share.CloudGetter;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CloudGetterBungee extends CloudGetter<CloudPlayerBungee> {

    @Override
    public @NotNull List<CloudPlayerBungee> getAllPlayers() {
        return BukkitLabsCloudProxyBungee.getInstance()
                .getProxy()
                .getPlayers()
                .stream()
                .map(CloudPlayerBungee::new)
                .toList();
    }
}
