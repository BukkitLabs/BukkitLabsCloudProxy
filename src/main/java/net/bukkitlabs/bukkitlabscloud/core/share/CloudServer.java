package net.bukkitlabs.bukkitlabscloud.core.share;

import org.jetbrains.annotations.NotNull;

public interface CloudServer<T extends CloudServerInfo> {

    @NotNull T getServerInfo();
}
