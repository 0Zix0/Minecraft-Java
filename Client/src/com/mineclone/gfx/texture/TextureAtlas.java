package com.mineclone.gfx.texture;

import java.util.ArrayList;

public class TextureAtlas extends BasicTexture {
	
	private int textureSize;
	
	private final float texturesPerRow;
	private final float unitSize;
	
	public TextureAtlas(String path, int textureSize) {
		super(path);
		this.textureSize = textureSize;
		this.texturesPerRow = width / textureSize;
		this.unitSize = 1.0f / (float) texturesPerRow;
	}

	public ArrayList<Float> getTextureCoords(int x, int y) {
		float xMin = x * unitSize;
		float yMin = y * unitSize;
		
		float xMax = xMin + unitSize;
		float yMax = yMin + unitSize;
		
		ArrayList<Float> res = new ArrayList<>();
		
		res.add(xMax);
		res.add(yMax);

		res.add(xMin);
		res.add(yMax);

		res.add(xMin);
		res.add(yMin);

		res.add(xMax);
		res.add(yMin);
		//return new float[] {
		//		xMax, yMax,
		//		xMin, yMax,
		//		xMin, yMin,
		//		xMax, yMin
		//};
		return res;
	}
}
