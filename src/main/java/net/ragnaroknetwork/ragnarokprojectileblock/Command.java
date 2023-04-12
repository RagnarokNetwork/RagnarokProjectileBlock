package net.ragnaroknetwork.ragnarokprojectileblock;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class Command implements CommandExecutor {
    Plugin plugin = RagnarokProjectileBlock.getPlugin(RagnarokProjectileBlock.class);

    @Override
    public boolean onCommand (CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (!player.hasPermission("ragnarokprojectileblock.admin")) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4&l► &cYou do not have permission to execute this command!"));
                return true;
            }
        }

        if (args.length == 0) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4&lRagnarokProjectileBlock Help\n&c&l ► &c/rpb snowball <true/false>: &7Enable or disable snowball pvp.\n&c&l ► &c/rpb egg <true/false>: &7Enable or disable egg pvp.\n&c&l ► &c/rpb rod <true/false>: &7Enable or disable fishing rod pvp.\n&c&l ► &c/rbb reload: &7Reload the config file.\n&c&l ► &c/rbb values: &7Get all modifier values."));
            return true;
        }

        if (args[0].equalsIgnoreCase("reload")) {
            plugin.reloadConfig();
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&2&l► &aSuccessfully reloaded &2RagnarokProjectileBlock&a!"));
            return true;
        }

        else if (args[0].equalsIgnoreCase("egg")) {
            Boolean egg = plugin.getConfig().getBoolean("egg");

            if (args.length == 1) {
                if (egg) sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l► &7Eggs are &cenabled &7in pvp."));
                else sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l► &7Eggs are &cdisabled &7in pvp."));
                return true;
            }

            try {
                Boolean.parseBoolean(args[1].trim());
            } catch (NumberFormatException e){
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4&l► &cValue must be either true or false!"));
                return true;
            }

            Boolean newEgg = Boolean.parseBoolean(args[1].trim());

            plugin.getConfig().set("egg", newEgg);
            plugin.saveConfig();
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l► &7Egg pvp was set to &c" + args[1]));
            return true;
        }

        else if (args[0].equalsIgnoreCase("snowball")) {
            Boolean snowball = plugin.getConfig().getBoolean("snowball");

            if (args.length == 1) {
                if (snowball) sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l► &7Snowballs are &cenabled &7in pvp."));
                else sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l► &7Snowballs are &cdisabled &7in pvp."));
                return true;
            }

            try {
                Boolean.parseBoolean(args[1].trim());
            } catch (NumberFormatException e){
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4&l► &cValue must be either true or false!"));
                return true;
            }

            Boolean newSnowball = Boolean.parseBoolean(args[1].trim());

            plugin.getConfig().set("snowball", newSnowball);
            plugin.saveConfig();
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l► &7Snowball pvp was set to &c" + args[1]));
            return true;
        }

        else if (args[0].equalsIgnoreCase("rod")) {
            Boolean rod = plugin.getConfig().getBoolean("rod");

            if (args.length == 1) {
                if (rod) sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l► &7Fishing rods are &cenabled &7in pvp."));
                else sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l► &7Fishing rods are &cdisabled &7in pvp."));
                return true;
            }

            try {
                Boolean.parseBoolean(args[1].trim());
            } catch (NumberFormatException e){
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4&l► &cValue must be either true or false!"));
                return true;
            }

            Boolean newRod = Boolean.parseBoolean(args[1].trim());

            plugin.getConfig().set("rod", newRod);
            plugin.saveConfig();
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l► &7Fishing rod pvp was set to &c" + args[1]));
            return true;
        }

        else if (args[0].equalsIgnoreCase("values")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4&lValues\n&c&l ► &7Eggs: &c" + plugin.getConfig().getBoolean("egg") + "\n&c&l ► &7Snowballs: &c" + plugin.getConfig().getBoolean("snowball") + "\n&c&l ► &7Fishing rods &c" + plugin.getConfig().getBoolean("rod")));
            return true;
        }

        else if (args[0].equalsIgnoreCase("help")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4&lRagnarokProjectileBlock Help\n&c&l ► &c/rpb snowball <true/false>: &7Enable or disable snowball pvp.\n&c&l ► &c/rpb egg <true/false>: &7Enable or disable egg pvp.\n&c&l ► &c/rpb rod <true/false>: &7Enable or disable fishing rod pvp.\n&c&l ► &c/rbb reload: &7Reload the config file.\n&c&l ► &c/rbb values: &7Get all modifier values."));
            return true;
        }

        return true;
    }
}
