package com.mygdx.game.Character.NPC;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.nameDialog;
import com.mygdx.game.Character.Player;
import com.mygdx.game.Character.Enemy.Enemy;

public class Cow extends NPC{

	public Cow(float x, float y) {
		super(x, y);
		tex = new Texture("People/Cow.png");
		char_index = addCharacter(this);
	}
	
	@Override
	public void hit(int index){
		if(characters.get(index) instanceof Player){
			nameDialog.dialog.addLine("Moo");
		}
		else if(characters.get(index) instanceof Enemy){
			health -= 10;
		}
	}

}
