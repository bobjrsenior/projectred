package com.mygdx.game.Items;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

public class ItemRandomizer{
	FileHandle Food = Gdx.files.internal("SpawnLists/FoodList.txt");;
	String[] FoodList;
	public ItemRandomizer(){
		FoodList = Food.readString().split("[\n]");
		for(int i = 0; i < FoodList.length; i++){
			FoodList[i]=FoodList[i].trim();
		}
	}
	
	  
	public String Randomizer(String listName){
		Random rand = new Random(System.nanoTime());
		switch(listName){
		case "Food": return FoodList[rand.nextInt(FoodList.length)];
		}
		return "Not found";
	}
}
