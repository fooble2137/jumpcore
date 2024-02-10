package dev.fooble.jumpcore.commands.subcommands;

import dev.fooble.jumpcore.Jumpcore;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NewSubcommand extends Subcommand {

    @Override
    public String getName() {
        return "new";
    }

    @Override
    public int getSize() {
        return 2;
    }

    @Override
    public String getPermission() {
        return "jumpcore.parkour.new";
    }

    @Override
    public String getUsage() {
        return "/jumpcore new <name>";
    }

    @Override
    public void run(CommandSender sender, String[] args, Jumpcore main) {
        if(!(sender instanceof Player p)) {
            sender.sendMessage("§cThis command can only be used by players!");
            return;
        }

        String name = args[1];
        //TODO: New
        p.sendMessage(name);
    }
}