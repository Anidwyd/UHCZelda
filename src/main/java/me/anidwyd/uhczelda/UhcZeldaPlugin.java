package me.anidwyd.uhczelda;

import me.anidwyd.uhczelda.commands.StartCommand;
import me.anidwyd.uhczelda.commands.ZeldaBaseCommand;
import me.anidwyd.uhczelda.managers.GameManager;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;

public final class UhcZeldaPlugin extends JavaPlugin {

    private GameManager gameManager;

    @Override
    public void onEnable() {
        gameManager = new GameManager(this);

        // register events
        String packageName = getClass().getPackage().getName();

        for (Class<?> clazz : new Reflections(packageName + ".listeners")
                .getSubTypesOf(Listener.class)
        ) {
            try {
                Listener listener = (Listener) clazz
                        .getDeclaredConstructor()
                        .newInstance();
                getServer().getPluginManager().registerEvents(listener, this);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }

        // commands
        getCommand("zelda").setExecutor(new ZeldaBaseCommand());
        getCommand("start").setExecutor(new StartCommand());

        // Plugin startup logic
        System.out.println("[ZeldaUHC] Plugin enabled.");
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("[ZeldaUHC] Plugin disabled.");

        gameManager.cleanup();
    }

}
