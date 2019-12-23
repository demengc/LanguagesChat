package com.demeng7215.languageschat.commands;

import com.demeng7215.demapi.api.DemCommand;
import com.demeng7215.demapi.api.MessageUtils;
import com.demeng7215.languageschat.LanguagesChat;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FrancaisCmd extends DemCommand {

    private LanguagesChat i;

    public FrancaisCmd(LanguagesChat i) {
        super("francais");
        this.i = i;
    }

    @Override
    protected void run(CommandSender sender, String[] args) {

        if (!checkIsPlayer(sender, "&cVous devez être un joueur pour utiliser cette commande.")) return;

        final Player p = (Player) sender;

        if (LanguagesChat.getPermission().has(p, "language.french")) {
            MessageUtils.sendMessageToPlayer(p, "&cVotre langue est déjà le français.");
            return;
        }

        if (LanguagesChat.getPermission().has(p, "language.english"))
            LanguagesChat.getPermission().playerRemove(p, "language.english");

        LanguagesChat.getPermission().playerAdd(null, p, "language.french");
        MessageUtils.sendMessageToPlayer(p, "&aVotre langue est maintenant le français.");
    }
}
