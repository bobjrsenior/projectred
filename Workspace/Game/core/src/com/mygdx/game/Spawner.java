package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.Character.Player;
import com.mygdx.game.Character.Enemy.Zombie;
import com.mygdx.game.Character.NPC.Cow;
import com.mygdx.game.Items.ItemRandomizer;
import com.mygdx.game.Items.Bread;
import com.mygdx.game.Items.ChickenLeg;
import com.mygdx.game.Items.Donut;


public class Spawner {
	ItemRandomizer randy;
	public Spawner(){
		randy = new ItemRandomizer();
		//System.out.println(BasicMap.tiledMap.getLayers().getCount());
		MapObjects test = BasicMap.tiledMap.getLayers().get("Character Layer").getObjects();
		for(MapObject tile : test){
			if (tile instanceof RectangleMapObject) {
				Rectangle rec = ((RectangleMapObject) tile).getRectangle();
				Spawn(tile.getName(), rec.x , rec.y);
			}
		}
		
		test = BasicMap.tiledMap.getLayers().get("Buildings Layer").getObjects();
		System.out.println(test.getCount());
		for(MapObject tile : test){
			if (tile instanceof RectangleMapObject) {
				Rectangle rec = ((RectangleMapObject) tile).getRectangle();
				Spawn(tile.getName(), rec.x , rec.y);
			}
		}
		test = BasicMap.tiledMap.getLayers().get("Item Layer").getObjects();
		System.out.println(test.getCount());
		for(MapObject tile : test){
			if (tile instanceof RectangleMapObject) {
				Rectangle rec = ((RectangleMapObject) tile).getRectangle();
				Spawn(tile.getName(), rec.x , rec.y);
			}
		}
		
		test = BasicMap.tiledMap.getLayers().get("Blockade").getObjects();
		for(MapObject tile : test){
			if (tile instanceof RectangleMapObject) {
				Rectangle rec = ((RectangleMapObject) tile).getRectangle();
				Spawn(tile.getName(), rec.x , rec.y, rec.width, rec.height);
			}
		}
	}
	
	
	//Character Spawns
	public void Spawn(String object, float PosX, float PosY){
		Building temp;
		switch(object){
		case "Player":	new Player(PosX,PosY); break;
		case "Zombie":	new Zombie(PosX,PosY); break;
		case "Cow":	new Cow(PosX,PosY); break;
		case "House": temp = new Building(PosX,PosY); temp.setColliderHouse();break;
		case "Church": temp = new Building(PosX,PosY); temp.setColliderChurch();break;
		case "Courthouse": temp = new Building(PosX,PosY); temp.setColliderCourt();break;
		case "Factory": temp = new Building(PosX,PosY); temp.setColliderFactory();break;		
		case "RandomFood": String thing = randy.Randomizer("Food"); System.out.println(thing); Spawn(thing, PosX, PosY); break;
		case "Bread":	System.out.println("Spawned Bread"); new Bread(PosX,PosY); break;
		case "ChickenLeg":	new ChickenLeg(PosX,PosY); break;
		case "Donut":	new Donut(PosX,PosY); break;
		default: System.out.println("Didn't work");
		}
	}
	
	//Hidden Spawns
	public void Spawn(String object, float PosX, float PosY, float width, float height){
		switch(object){
		case "Hidden": new Building(PosX,PosY,width,height);break;
		default: System.out.println("Didn't work");
		}
	}
}
