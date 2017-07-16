package com.mineclone.world.chunk;

import com.mineclone.block.Block;
import com.mineclone.block.Block.BlockData;

public class ChunkBlock {

	public byte id = 1;
	
	public ChunkBlock(Block block) {
		this.id = block.getID();
	}
	
	public ChunkBlock(byte id) {
		this.id = id;
	}
	
	public BlockData getData() {
		return Block.get(id).getData();
	}
	
	public Block getBlock() {
		return Block.get(id);
	}
}
