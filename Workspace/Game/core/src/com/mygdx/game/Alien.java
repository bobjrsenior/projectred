package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public class Alien extends NPC{

	public Alien(float x, float y, Texture tex) {
		super(x, y, tex);
		char_index = addCharacter(this);
	}

}