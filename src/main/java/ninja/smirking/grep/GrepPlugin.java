package ninja.smirking.grep;

import com.google.common.base.Joiner;

import ninja.smirking.grep.wrapper.WrappedSender;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

/**
 * @author Connor Spencer Harries
 */
public class GrepPlugin extends JavaPlugin {
    private static final Joiner JOINER = Joiner.on(" ");

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length < 2) {
            sender.sendMessage("Usage: /grep <pattern> <command>");
        } else {
            sender.sendMessage(colour("Beginning command execution!"));
            WrappedSender wrapped = new WrappedSender(sender, args[0]);
            String commandString = JOINER.join(Arrays.copyOfRange(args, 1, args.length));
            sender.getServer().dispatchCommand(wrapped, commandString);
            sender.sendMessage(colour("Command execution complete!"));
        }
        return true;
    }

    private String colour(String message) {
        return new StringBuilder().append(ChatColor.GREEN).append(message).toString();
    }
}
