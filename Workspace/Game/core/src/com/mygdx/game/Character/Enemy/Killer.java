package com.mygdx.game.Character.Enemy;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Spawner;
import com.mygdx.game.nameDialog;
import com.mygdx.game.Character.Character;
import com.mygdx.game.Character.NPC.Alien;

public class Killer extends Enemy{
	public static Killer k;
	
	public Killer(float x , float y){
		super(x,y);
		tex = new Texture("People/killer.png");
		followspeed=5;
		k=this;
	}
	
	@Override
	public void update(){
		super.update();
		if(Alien.a != null){
			startFollow(Alien.a);
		}
	}
	
	@Override
	public void hit(int index){
		super.hit(index);
		if(characters.get(index) instanceof Alien){
			Alien.a.health -= 10;
			if(Alien.a.health <= 0){
				for(int i = 0; i < 10; i++) nameDialog.dialog.getKiller();
				Spawner.s.Spawn("Corpse", Alien.a.x, Alien.a.y);
				Character.characters.remove(Alien.a);
				Alien.a=null;
				Killer.k.stopFollow();
				Character.characters.remove(Killer.k);
				Killer.k=null;
			}
			//Gdx.app.log("Player(e)", " " + characters.get(index).health);
		}
	}
}
