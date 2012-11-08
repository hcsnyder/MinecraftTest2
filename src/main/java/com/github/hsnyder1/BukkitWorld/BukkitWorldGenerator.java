package com.github.hsnyder1.BukkitWorld;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.*;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;

public class BukkitWorldGenerator extends ChunkGenerator{
	
	private String worldBiome = "ICE_PLAINS";

	BukkitWorld plugin;
	
	public BukkitWorldGenerator(BukkitWorld instance){

		this.plugin = instance;
	}
	
	public List<BlockPopulator> getDefaultPopulators(World world){
		ArrayList<BlockPopulator> populators = new ArrayList<BlockPopulator>();
		
		populators.add(new BukkitWorldTreePopulator());
		
		return populators;
	}
	
	public Location getFixedSpawnLocation(World world, Random random) {
		return new Location(world, 0, 5, 0);
	}
	
	public int coordsToInt(int x, int y, int z) {
		return (x * 16 + z) * 128 + y;
	}
	
	public byte[] generate(World world, Random random, int chunkX, int chunkZ, BiomeGrid biome) {
		byte[] blocks = new byte[32768];
		int x, y, z;
		
		
		for(x=0; x<16; ++x) {
			for(z=0; z<16; ++z) {
				blocks[this.coordsToInt(x, 0, z)] = (byte) Material.BEDROCK.getId();
			}
			for(y=1; y<20; ++y) {
				blocks[this.coordsToInt(x, y, z)] = (byte) Material.DIRT.getId();

			}
			blocks[this.coordsToInt(x, 20, z)] = (byte) Material.SNOW.getId();
			biome.setBiome(x, z, Biome.valueOf(worldBiome.toUpperCase()));
		}
		
		return blocks;
	}
}
