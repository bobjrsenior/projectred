package com.mygdx.game.Character.NPC;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.nameDialog;
import com.mygdx.game.Character.Player;
import com.mygdx.game.Character.Enemy.Enemy;

public class Human extends NPC{

	//nameDialog dialog = new nameDialog("Human");
	
	public Human(float x, float y) {
		super(x, y);
		tex = new Texture("People/Player.png");
		char_index = addCharacter(this);
		//getDialog();
	}
	/*
	public Human(float x, float y) {
		super(x, y, new Texture("People/Player.png"));
		char_index = addCharacter(this);
	}
	*/
	
	public void getDialog(){
		//dialog.getHuman();
		//dialog.create();
		//dialog.render();
	}
	
	@Override
	public void hit(int index){
		if(characters.get(index) instanceof Player){
			nameDialog.dialog.getHuman();
		}
		else if(characters.get(index) instanceof Enemy){
			health -= 10;
		}
	}
}
