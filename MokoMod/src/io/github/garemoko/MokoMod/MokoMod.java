package io.github.garemoko.MokoMod;

import org.bukkit.plugin.java.JavaPlugin;

public final class MokoMod extends JavaPlugin {

	public static boolean citizensEnabled = false;

	@Override
	public void onEnable() {
		// This will throw a NullPointerException if you don't have the command
		// defined in your plugin.yml file!
		getCommand("Moko").setExecutor(new MokoModCommandExecutor(this));

		// save config.yml if it does not exist
		this.saveDefaultConfig();
	}

	@Override
	public void onDisable() {
		getLogger().info("onDisable has been invoked!");
	}

}
