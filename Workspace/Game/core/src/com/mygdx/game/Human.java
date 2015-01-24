package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Human extends NPC{

	//Dialog dialog = new Dialog("Human");
	
	public Human(float x, float y, Texture tex) {
		super(x, y, tex);
		char_index = addCharacter(this);
	}
	
	public void getDialog(){
		//return dialog.getHuman();
	}
	
	/*@Override
	public void hit(int index){
		if(characters.get(index) instanceof Player){
			Gdx.app.log("NPC", "Say something");
		}
		else if(characters.get(index) instanceof Enemy){
			health -= 10;
		}
	}*/
}
