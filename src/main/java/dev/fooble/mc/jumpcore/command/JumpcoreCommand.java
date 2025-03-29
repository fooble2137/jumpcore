package dev.fooble.mc.jumpcore.command;

import dev.fooble.mc.jumpcore.Text;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class JumpcoreCommand implements CommandExecutor, TabCompleter {

    private final List<SubCommand> subCommands = new ArrayList<>();

    public JumpcoreCommand() {
        subCommands.add(new HelpSubCommand(subCommands));
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if(args.length == 0) {
            sender.sendMessage(Text.create("""
                    
                    <b><gradient:#FFE259:#FFA751>Jumpcore</gradient></b> <gray>0.1-ALPHA <dark_gray>- <color:#fff173>Made by Fooble</color>
                    """));
            return true;
        }

        if(!(sender instanceof Player player)) {
            sender.sendMessage(Text.create("<red>Only players can use this command!"));
            return true;
        }

        for(SubCommand subCommand : subCommands) {
            if(subCommand.getName().equalsIgnoreCase(args[0])) {
                if(!player.hasPermission(subCommand.getPermission())) {
                    player.sendMessage(Text.create("<red>You do not have permission to use this command!"));
                    return true;
                }

                subCommand.execute(player, args);
                return true;
            }
        }

        player.sendMessage(Text.create("<red>Unknown subcommand! Use <gray>/jumpcore help <red>to see all available subcommands."));
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if(args.length != 1) {
            return List.of();
        }

        final List<String> list = new ArrayList<>();
        for(SubCommand subCommand : subCommands) {
            list.add(subCommand.getName());
        }
        list.sort(String::compareToIgnoreCase);

        final List<String> result = new ArrayList<>();
        for(String s : list) {
            if(s.toLowerCase().startsWith(args[0].toLowerCase())) {
                result.add(s);
            }
        }

        return result;
    }
}
