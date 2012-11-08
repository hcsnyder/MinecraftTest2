package com.github.hsnyder1.BukkitWorld;

import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;



public class BukkitWorld extends JavaPlugin {

	
	public ChunkGenerator getDefaultWorldGenerator(String worldName, String uid) {
		return new BukkitWorldGenerator(this);
	}
}
