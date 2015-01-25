package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.Character.Player;
import com.mygdx.game.Character.Enemy.Zombie;

public class Spawner {
	
	public Spawner(){
		MapObjects test = BasicMap.tiledMap.getLayers().get("Character Layer").getObjects();
		System.out.println(BasicMap.tiledMap.getLayers().get("Character Layer").getObjects().getCount());
		for(MapObject tile : test){
			if (tile instanceof RectangleMapObject) {
				Rectangle rec = ((RectangleMapObject) tile).getRectangle();
				System.out.println(tile.getName());
				Spawn(tile.getName(), rec.x , rec.y);
			}
		}
	}
	
	
	//Character Spawns
	public void Spawn(String object, float PosX, float PosY){
		switch(object){
		case "Player":	new Player(PosX,PosY); System.out.println("You did it hurray"); break;
		case "Zombie":	new Zombie(PosX,PosY); break;
		default: System.out.println("Didn't work");
		}
	}
}
