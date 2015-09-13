package ninja.smirking.grep.wrapper;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * @author Connor Spencer Harries
 */
public class StandardOutputSender implements CommandSender {
    private final List<String> sentMessages;
    private final String name;

    public StandardOutputSender(String name) {
        this.sentMessages = new ArrayList<>();
        this.name = name;
    }

    public void assertSent(String message) {
        Assert.assertTrue("sentMessages should contain the message", sentMessages.contains(message));
    }

    @Override
    public void sendMessage(String message) {
        sentMessages.add(ChatColor.stripColor(message));
        System.out.printf("[%s]: %s%n", name, message);
    }

    @Override
    public void sendMessage(String[] messages) {
        Arrays.stream(messages).forEach(this::sendMessage);
    }

    @Override
    public Server getServer() {
        return null;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isPermissionSet(String name) {
        return false;
    }

    @Override
    public boolean isPermissionSet(Permission perm) {
        return false;
    }

    @Override
    public boolean hasPermission(String name) {
        return true;
    }

    @Override
    public boolean hasPermission(Permission perm) {
        return true;
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value) {
        return null;
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin) {
        return null;
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value, int ticks) {
        return null;
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, int ticks) {
        return null;
    }

    @Override
    public void removeAttachment(PermissionAttachment attachment) {

    }

    @Override
    public void recalculatePermissions() {

    }

    @Override
    public Set<PermissionAttachmentInfo> getEffectivePermissions() {
        return null;
    }

    @Override
    public boolean isOp() {
        return false;
    }

    @Override
    public void setOp(boolean value) {

    }
}
