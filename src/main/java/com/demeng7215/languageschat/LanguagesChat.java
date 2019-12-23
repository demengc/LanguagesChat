package com.demeng7215.languageschat;

import com.demeng7215.demapi.DemAPI;
import com.demeng7215.demapi.api.DemConfigurationFile;
import com.demeng7215.demapi.api.MessageUtils;
import com.demeng7215.demapi.api.Registerer;
import com.demeng7215.languageschat.commands.EnglishCmd;
import com.demeng7215.languageschat.commands.FrancaisCmd;
import com.demeng7215.languageschat.listeners.ChatsListener;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class LanguagesChat extends JavaPlugin {

    public DemConfigurationFile config;

    private static Permission perms = null;

    @Override
    public void onEnable() {

        DemAPI.setPlugin(this);
        MessageUtils.setPrefix("&2[Languages] &a");

        try {
            config = new DemConfigurationFile("configuration.yml");
        } catch (Exception e) {
            e.printStackTrace();
        }

        MessageUtils.setPrefix(getConfiguration().getString("prefix"));

        setupPermissions();

        Registerer.registerCommand(new EnglishCmd(this));
        Registerer.registerCommand(new FrancaisCmd(this));

        Registerer.registerListeners(new ChatsListener());

        MessageUtils.sendColoredConsoleMessage("&aLanguagesChat has been successfully enabled.");
        MessageUtils.sendColoredConsoleMessage("&aThis is a custom plugin for PlayCubes, owned by Ticlick.");
    }

    @Override
    public void onDisable() {
        MessageUtils.sendColoredConsoleMessage("&aLanguagesChat has been successfully enabled.");
        MessageUtils.sendColoredConsoleMessage("&aThis is a custom plugin for PlayCubes, owned by Ticlick.");
    }

    public FileConfiguration getConfiguration() {
        return config.getConfig();
    }

    private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        perms = rsp.getProvider();
        return perms != null;
    }

    public static Permission getPermission() {
        return perms;
    }
}
