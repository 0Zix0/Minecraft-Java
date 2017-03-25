package com.mineclone.state;

import com.mineclone.Application;

public class PlayingState extends GameState {

	public PlayingState(Application application) {
		super(application);
	}

	public void input() {
		System.out.println("[PlayingState] Input");
	}

	public void update() {
		System.out.println("[PlayingState] Update");
	}

	public void draw() {
		System.out.println("[PlayingState] Draw");
	}
}
