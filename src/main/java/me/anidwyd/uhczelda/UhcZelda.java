package me.anidwyd.uhczelda;

import lombok.Getter;
import me.anidwyd.uhczelda.game.GameManager;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;

@Getter
public final class UhcZelda extends JavaPlugin {

    private static UhcZelda plugin;
    private GameManager gameManager;

    @Override
    public void onEnable() {
        plugin = this;
        gameManager = new GameManager();

        // register listeners
        String packageName = getClass().getPackage().getName();
        for (Class<?> clazz : new Reflections(packageName + ".listeners")
                .getSubTypesOf(Listener.class)
        ) {
            try {
                Listener listener = (Listener) clazz
                    .getDeclaredConstructor()
                    .newInstance();
                getServer().getPluginManager().registerEvents(listener, plugin);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }

        // Plugin startup logic
        System.out.println("[ZeldaUHC] Plugin enabled.");
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("[ZeldaUHC] Plugin disabled.");
    }

}
