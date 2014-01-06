package io.github.garemoko.MokoMod;

import net.citizensnpcs.api.npc.NPC;

import net.citizensnpcs.api.npc.NPCRegistry;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class MokoModCommandExecutor implements CommandExecutor {
	private MokoMod plugin; // pointer to your main class, unrequired if you
							// don't need methods from the main class

	public MokoModCommandExecutor(MokoMod plugin) {
		this.plugin = plugin;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {

		if (cmd.getName().equalsIgnoreCase("moko")) { // If the player typed
														// /moko then do the
														// following...
			if (args.length == 0) {
				for (String line : this.plugin.getConfig().getStringList(
						"helptext")) {
					sender.sendMessage(line);
				}
				return true;
			}
			if (args[0].equalsIgnoreCase("hello")) {
				sender.sendMessage("Hello World!");
				NPCRegistry myNPCRegistry = net.citizensnpcs.api.CitizensAPI
						.getNPCRegistry();
				NPC myNPC = myNPCRegistry.createNPC(EntityType.PIG, "porky");
				Player player = (Player) sender;
				myNPC.spawn(player.getTargetBlock(null, 200).getLocation()
						.add(0, 1, 0));
				return true;
			} else if (args[0].equalsIgnoreCase("castle")) {
				if (args.length == 1) {
					for (String line : this.plugin.getConfig().getStringList(
							"helptext-castle")) {
						sender.sendMessage(line);
					}
					return true;
				} else if (args[1].equalsIgnoreCase("set")) {
					String castleName = "Unnamed";
					if (args.length == 3) {
						castleName = args[2];
					}
					Player player = (Player) sender;
					Location castleLocation = player.getLocation();
					sender.sendMessage("Castle " + castleName + " set at ("
							+ castleLocation.getBlockX() + "),("
							+ castleLocation.getBlockZ() + "),("
							+ castleLocation.getBlockY() + ")");
				}
			}

		} // If this has happened the function will return true.
			// If this hasn't happened the a value of false will be returned.
		return false;
	}
}
