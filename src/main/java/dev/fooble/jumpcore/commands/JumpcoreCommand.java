package dev.fooble.jumpcore.commands;

import dev.fooble.jumpcore.Jumpcore;
import dev.fooble.jumpcore.commands.subcommands.NewSubcommand;
import dev.fooble.jumpcore.commands.subcommands.Subcommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JumpcoreCommand implements CommandExecutor, TabCompleter {

    Jumpcore main;

    public JumpcoreCommand(Jumpcore main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(args.length == 0) {
            //TODO: Show help and info
            return false;
        }

        for(Subcommand subcommand : getSubcommands()) {
            if(args[0].equalsIgnoreCase(subcommand.getName())) {
                if(args.length != subcommand.getSize()) {
                    sender.sendMessage("§cCommand not found! Use §7§o'" + subcommand.getUsage() + "'");
                    return false;
                }

                if(!sender.hasPermission(subcommand.getPermission())) {
                    sender.sendMessage("§cYou don't have permission to execute this command!");
                    return false;
                }

                subcommand.run(sender, args, main);
                return false;
            }
        }

        return false;
    }

    public Subcommand[] getSubcommands() {
        Subcommand[] subcommands = new Subcommand[1];
        subcommands[0] = new NewSubcommand();

        return subcommands;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        if(args.length == 1) {
            List<String> subcommands = new ArrayList<>();
            for(Subcommand subcommand : getSubcommands()) {
                subcommands.add(subcommand.getName());
            }
            return subcommands;
        }
        return new ArrayList<>();
    }
}
