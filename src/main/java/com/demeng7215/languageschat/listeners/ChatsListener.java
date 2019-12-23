package com.demeng7215.languageschat.listeners;

import com.demeng7215.demapi.api.MessageUtils;
import com.demeng7215.languageschat.LanguagesChat;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.ArrayList;
import java.util.List;

public class ChatsListener implements Listener {

    private LanguagesChat i;

    public void ChatsListener(LanguagesChat i) {
        this.i = i;
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e) {

        if (e.getMessage().startsWith("/")) return;

        Player p = e.getPlayer();

        if (!LanguagesChat.getPermission().has(p, "language.english") &&
                !LanguagesChat.getPermission().has(p, "language.french")) {
            MessageUtils.sendMessageToPlayer(e.getPlayer(), "&cPlease set a language using &f/english &aor &f/francais&a.");
            MessageUtils.sendMessageToPlayer(e.getPlayer(), "&cVeuillez définir une langue avec &f/english &aou &f/francais&a.");
            e.setCancelled(true);
            return;
        }

        List<Player> receivers = new ArrayList<>();

        if (LanguagesChat.getPermission().has(p, "language.english"))
            for (Player englishPlayer : Bukkit.getOnlinePlayers())
                if (LanguagesChat.getPermission().has(englishPlayer, "language.english"))
                    receivers.add(englishPlayer);

        if (LanguagesChat.getPermission().has(p, "language.french"))
            for (Player frenchPlayer : Bukkit.getOnlinePlayers())
                if (LanguagesChat.getPermission().has(frenchPlayer, "language.french"))
                    receivers.add(frenchPlayer);

                e.getRecipients().clear();
                e.getRecipients().addAll(receivers);
    }
}
