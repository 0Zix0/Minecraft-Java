package com.mineclone.block;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.EnumSet;
import java.util.HashMap;

import org.joml.Vector2i;

public enum Block {

	AIR(0, "res/blocks/air.blk"),
	GRASS(1, "res/blocks/grass.blk");

	private static HashMap<Integer, Block> blocks = new HashMap<>();
	
	private int id;
	private String dataFile;
	
	private String name;
	private boolean isOpaque;
	private Vector2i topTextureCoords;
	private Vector2i sideTextureCoords;
	private Vector2i bottomTextureCoords;
	
	private Block(int id, String dataFile) {
		this.id = id;
		this.dataFile = dataFile;
		loadData();
	}
	
	private void loadData() {
		try(BufferedReader br = new BufferedReader(new FileReader(new File(dataFile)))) {
		    for(String line; (line = br.readLine()) != null; ) {
		    	if(line.equalsIgnoreCase("") || line.isEmpty()) continue;
		    	if(line.equalsIgnoreCase("Name")) {
		    		name = br.readLine();
		    	} else if(line.equalsIgnoreCase("ID")) {
		    		id = Integer.parseInt(br.readLine());
		    	} else if(line.equalsIgnoreCase("Opaque")) {
		    		isOpaque = Boolean.parseBoolean(br.readLine());
		    	} else if(line.equalsIgnoreCase("TextureTop")) {
		    		String v = br.readLine();
		    		String[] parts = v.split(" ");
		    		topTextureCoords = new Vector2i(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
		    	} else if(line.equalsIgnoreCase("TextureSide")) {
		    		String v = br.readLine();
		    		String[] parts = v.split(" ");
		    		sideTextureCoords = new Vector2i(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
		    	} else if(line.equalsIgnoreCase("TextureBottom")) {
		    		String v = br.readLine();
		    		String[] parts = v.split(" ");
		    		bottomTextureCoords = new Vector2i(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
		    	}
		    }
		} catch(IOException e) {
			
		}
	}
	
	public static Block get(int id) {
		if(!blocks.containsKey(id)) return null;
		return blocks.get(id);
	}
	
	static {
		for(Block b : EnumSet.allOf(Block.class)) {
			blocks.put(b.id, b);
		}
	}
}
