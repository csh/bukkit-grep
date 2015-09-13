package ninja.smirking.grep.wrapper;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author Connor Spencer Harries
 */
public class WrappedSender implements CommandSender {
    private final CommandSender sender;
    private final Pattern pattern;

    public WrappedSender(CommandSender sender, String pattern) {
        this.pattern = Pattern.compile(escape(pattern), Pattern.CASE_INSENSITIVE);
        this.sender = sender;
    }

    @Override
    public void sendMessage(String message) {
        if(pattern.matcher(ChatColor.stripColor(message)).matches()) {
            sender.sendMessage(message);
        }
    }

    @Override
    public void sendMessage(String[] messages) {
        List<String> queue = Arrays.stream(messages)
                .filter(message -> pattern.matcher(message).matches())
                .collect(Collectors.toList());
        if(queue.size() > 0) {
            sender.sendMessage(queue.toArray(new String[queue.size()]));
        }
    }

    @Override
    public Server getServer() {
        return sender.getServer();
    }

    @Override
    public String getName() {
        return sender.getName();
    }

    @Override
    public boolean isPermissionSet(String name) {
        return sender.isPermissionSet(name);
    }

    @Override
    public boolean isPermissionSet(Permission perm) {
        return sender.isPermissionSet(perm);
    }

    @Override
    public boolean hasPermission(String name) {
        return sender.hasPermission(name);
    }

    @Override
    public boolean hasPermission(Permission perm) {
        return sender.hasPermission(perm);
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value) {
        return sender.addAttachment(plugin, name, value);
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin) {
        return sender.addAttachment(plugin);
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value, int ticks) {
        return sender.addAttachment(plugin, name, value, ticks);
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, int ticks) {
        return sender.addAttachment(plugin, ticks);
    }

    @Override
    public void removeAttachment(PermissionAttachment attachment) {
        sender.removeAttachment(attachment);
    }

    @Override
    public void recalculatePermissions() {
        sender.recalculatePermissions();
    }

    @Override
    public Set<PermissionAttachmentInfo> getEffectivePermissions() {
        return sender.getEffectivePermissions();
    }

    @Override
    public boolean isOp() {
        return sender.isOp();
    }

    @Override
    public void setOp(boolean value) {
        sender.setOp(value);
    }

    private static String escape(String pattern) {
        pattern = pattern.replace("*", ".*");
        return (".*").concat(pattern).concat(".*");
    }
}
