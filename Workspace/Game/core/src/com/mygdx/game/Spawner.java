package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.Character.Player;
import com.mygdx.game.Character.Enemy.Zombie;
import com.mygdx.game.Character.NPC.Cow;
import com.mygdx.game.Character.NPC.Alien;
import com.mygdx.game.Items.ItemRandomizer;
import com.mygdx.game.Items.Bread;
import com.mygdx.game.Items.ChickenLeg;
import com.mygdx.game.Items.Donut;
import com.mygdx.game.Items.Milk;


public class Spawner {
	ItemRandomizer randy;
	public static Spawner s;
	
	public Spawner(){
		randy = new ItemRandomizer();
		s = this;
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
		case "Alien":	new Alien(PosX,PosY); break;
		case "Cow":	new Cow(PosX,PosY); break;
		case "House": temp = new Building(PosX,PosY); temp.setColliderHouse();break;
		case "Church": temp = new Building(PosX,PosY); temp.setColliderChurch();break;
		case "Courthouse": temp = new Building(PosX,PosY); temp.setColliderCourt();break;
		case "Factory": temp = new Building(PosX,PosY); temp.setColliderFactory();break;		
		case "RandomFood": Spawn(randy.Randomizer("Food"), PosX, PosY); break;
		case "Bread":	 new Bread(PosX,PosY); break;
		case "ChickenLeg":	new ChickenLeg(PosX,PosY); break;
		case "Donut":	new Donut(PosX,PosY); break;
		case "RandomDrink": Spawn(randy.Randomizer("Drink"), PosX, PosY); break;
		case "Milk": new Milk(PosX,PosY); break;
		case "RandomSpook": Spawn(randy.Randomizer("Spook"), PosX, PosY); break;
		case "RandomAI": Spawn(randy.Randomizer("AI"), PosX, PosY); break;
		case "Corpse": new Corpse(PosX,PosY); break;
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
