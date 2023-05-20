package net.bukkitlabs.bukkitlabscloud.core.share.object;

import org.jetbrains.annotations.NotNull;

import java.net.SocketAddress;

public interface CloudServer {

    @NotNull
    String getName();

    @NotNull
    SocketAddress getAddress();
}
