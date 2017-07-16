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

	private static HashMap<Byte, Block> blocks = new HashMap<>();
	
	private byte id;
	private String dataFile;
	private BlockData blockData;
	
	private Block(int id, String dataFile) {
		this.id = (byte)id;
		this.dataFile = dataFile;
		loadData();
	}
	
	public byte getID() {
		return id;
	}
	
	public BlockData getData() {
		return blockData;
	}
	
	private void loadData() {
		String name = "N/A";
		boolean isOpaque = false;
		Vector2i topTextureCoords = new Vector2i();
		Vector2i sideTextureCoords = new Vector2i();
		Vector2i bottomTextureCoords = new Vector2i();
		try(BufferedReader br = new BufferedReader(new FileReader(new File(dataFile)))) {
		    for(String line; (line = br.readLine()) != null; ) {
		    	if(line.equalsIgnoreCase("") || line.isEmpty()) continue;
		    	if(line.equalsIgnoreCase("Name")) {
		    		name = br.readLine();
		    	} else if(line.equalsIgnoreCase("ID")) {
		    		id = Byte.parseByte(br.readLine());
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
		    blockData = new BlockData(name, isOpaque, topTextureCoords, sideTextureCoords, bottomTextureCoords);
		} catch(IOException e) {
			blockData = null;
			e.printStackTrace();
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
	
	public static class BlockData {
		private String name;
		private boolean isOpaque;
		private Vector2i topTextureCoords;
		private Vector2i sideTextureCoords;
		private Vector2i bottomTextureCoords;
		
		public BlockData(String name, boolean isOpaque, Vector2i topTextureCoords, Vector2i sideTextureCoords,
				Vector2i bottomTextureCoords) {
			this.name = name;
			this.isOpaque = isOpaque;
			this.topTextureCoords = topTextureCoords;
			this.sideTextureCoords = sideTextureCoords;
			this.bottomTextureCoords = bottomTextureCoords;
		}
		
		public String getName() {
			return name;
		}
		
		public boolean isOpaque() {
			return isOpaque;
		}
		
		public Vector2i getTopTextureCoords() {
			return topTextureCoords;
		}
		
		public Vector2i getSideTextureCoords() {
			return sideTextureCoords;
		}
		
		public Vector2i getBottomTextureCoords() {
			return bottomTextureCoords;
		}
	}
}
