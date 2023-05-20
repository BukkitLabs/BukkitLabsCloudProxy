package net.bukkitlabs.bukkitlabscloud.core.share.action;

import net.bukkitlabs.bukkitlabscloud.core.share.object.CloudSource;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

public interface CloudCommand {

    void onCommand(@NotNull CloudSource source, @NotNull String label, @NotNull String permission, String[] args);

    @NotNull
    default List<String> onTab(@NotNull CloudSource source, @NotNull String label, @NotNull String permission, String[] args) {
        return Collections.emptyList();
    }
}
