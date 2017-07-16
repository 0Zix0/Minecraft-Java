package com.mineclone.world.chunk;

import org.joml.Vector3f;

import com.mineclone.block.Block;
import com.mineclone.world.WorldConstants;

public class ChunkSection {

	private ChunkBlock[] blocks;
	private Vector3f position;
	
	public ChunkSection() {
		this.blocks = new ChunkBlock[WorldConstants.CHUNK_VOLUME];
		this.position = new Vector3f();
	}
	
	public Vector3f getPosition() {
		return position;
	}
	
	public ChunkBlock getBlock(int x, int y, int z) {
		if(x < 0) return new ChunkBlock(Block.AIR);
		if(y < 0) return new ChunkBlock(Block.AIR);
		if(z < 0) return new ChunkBlock(Block.AIR);
		if(x > WorldConstants.CHUNK_SIZE) return new ChunkBlock(Block.AIR);
		if(y > WorldConstants.CHUNK_SIZE) return new ChunkBlock(Block.AIR);
		if(z > WorldConstants.CHUNK_SIZE) return new ChunkBlock(Block.AIR);
		return blocks[blockIndex(x, y, z)];
	}
	
	public void setBlock(int x, int y, int z, ChunkBlock block) {
		if(x < 0) return;
		if(y < 0) return;
		if(z < 0) return;
		if(x > WorldConstants.CHUNK_SIZE) return;
		if(y > WorldConstants.CHUNK_SIZE) return;
		if(z > WorldConstants.CHUNK_SIZE) return;
		blocks[blockIndex(x, y, z)] = block;
	}
	
	private int blockIndex(int x, int y, int z) {
		return y * WorldConstants.CHUNK_SIZE * WorldConstants.CHUNK_SIZE + z * WorldConstants.CHUNK_SIZE + x;
	}
}
