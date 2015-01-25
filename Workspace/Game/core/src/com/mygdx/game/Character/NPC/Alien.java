package com.mygdx.game.Character.NPC;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Spawner;
import com.mygdx.game.nameDialog;
import com.mygdx.game.Character.Player;
import com.mygdx.game.Character.Enemy.Enemy;

public class Alien extends NPC{
	public static Alien a;

	public Alien(float x, float y) {
		super(x, y);
		tex = new Texture("People/alienfriend.png");
		char_index = addCharacter(this);
		a=this;
		Spawner.s.SpookSpawn("Killer");
	}
	/*
	public Alien(float x, float y) {
		super(x, y);
		char_index = addCharacter(this);
	}
	*/
	
	@Override
	public void hit(int index){
		if(characters.get(index) instanceof Player){
			nameDialog.dialog.getAlien();
		}
		else if(characters.get(index) instanceof Enemy){
			health -= 10;
			if(health <= 0){
				Spawner.s.Spawn("Corpse", a.x, a.y);
				a.tex.dispose();
				a=null;
			}
		}
	}
}
