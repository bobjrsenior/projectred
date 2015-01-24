package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public class NPC extends Character{
	//Debug: Gdx.app.log("NPC", "Text");
	public Character follow;
	
	public NPC(float x, float y, Texture tex) {
		super(x,y,tex);
		char_index = addCharacter(this);
	}
	
	public void startFollow(Player leader){

	}

}
