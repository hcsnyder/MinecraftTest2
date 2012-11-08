package com.github.hsnyder1.BukkitWorld;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;

public class BukkitWorldTreePopulator extends BlockPopulator{

	public void populate(World world, Random random, Chunk chunk) {
		if(random.nextInt(100) <= 30) {
			TreeType type;
			if(random.nextInt(100) <=10) {
				type = TreeType.TALL_REDWOOD;
			}
			else {
				type = TreeType.REDWOOD;
			}
		
				world.generateTree(chunk.getBlock(6 + random.nextInt(4), 21, 6 + random.nextInt(4)).getLocation(), type);
	
		}
	}
}
