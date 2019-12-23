package com.demeng7215.languageschat.commands;

import com.demeng7215.demapi.api.DemCommand;
import com.demeng7215.demapi.api.MessageUtils;
import com.demeng7215.languageschat.LanguagesChat;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EnglishCmd extends DemCommand {

    private LanguagesChat i;

    public EnglishCmd(LanguagesChat i) {
        super("english");
        this.i = i;
    }

    @Override
    protected void run(CommandSender sender, String[] args) {

        if (!checkIsPlayer(sender, "&cYou must be a player to execute this command.")) return;

        final Player p = (Player) sender;

        if (LanguagesChat.getPermission().has(p, "language.english")) {
            MessageUtils.sendMessageToPlayer(p, "&cYour language is already English.");
            return;
        }

        if (LanguagesChat.getPermission().has(p, "language.french"))
            LanguagesChat.getPermission().playerRemove(p, "language.french");

        LanguagesChat.getPermission().playerAdd(null, p, "language.english");
        MessageUtils.sendMessageToPlayer(p, "&aYour language is now English.");
    }
}
