package dev.fooble.jumpcore.commands.subcommands;

import dev.fooble.jumpcore.Jumpcore;
import org.bukkit.command.CommandSender;

public abstract class Subcommand {

    public abstract String getName();
    public abstract int getSize();
    public abstract String getPermission();
    public abstract String getUsage();
    public abstract void run(CommandSender sender, String[] args, Jumpcore main);

}