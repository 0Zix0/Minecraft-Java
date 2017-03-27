package com.mineclone.util;

import org.joml.Matrix4f;
import org.joml.Vector3f;

import com.mineclone.entity.Entity;
import com.mineclone.gfx.Camera;
import com.mineclone.gfx.Display;

public class MathUtilities {

	public static Matrix4f createViewMatrix(Camera entity) {
		Vector3f negativePos = new Vector3f();
		entity.getPosition().negate(negativePos);
		Matrix4f res = new Matrix4f().rotateAffineXYZ(//0.0f,
											 (float)Math.toRadians(entity.getRotation().x),
											 (float)Math.toRadians(entity.getRotation().y),
											 (float)Math.toRadians(entity.getRotation().z))
									 .translate(negativePos);
		return res;
	}
	
	public static Matrix4f createModelMatrix(Entity entity) {
		Matrix4f res = new Matrix4f().translate(entity.getPosition())
									 .rotateAffineXYZ(//0.0f,
											 (float)Math.toRadians(entity.getRotation().x),
											 (float)Math.toRadians(entity.getRotation().y),
											 (float)Math.toRadians(entity.getRotation().z));
		return res;
	}
	
	public static Matrix4f createProjMatrix() {
		Matrix4f res = new Matrix4f().perspective((float)Math.toRadians(90.0f), (float) (Display.getWidth() / Display.getHeight()), 0.1f, 1000.0f);
		return res;
	}
}
