package com.mygdx.game.Items;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

public class ItemRandomizer{
	FileHandle Food = Gdx.files.internal("SpawnLists/FoodList.txt");;
	String[] FoodList;
	FileHandle Drinks = Gdx.files.internal("SpawnLists/DrinkList.txt");;
	String[] DrinkList;
	FileHandle Spook = Gdx.files.internal("SpawnLists/SpookList.txt");;
	String[] SpookList;
	FileHandle AI = Gdx.files.internal("SpawnLists/AIList.txt");;
	String[] AIList;
	public ItemRandomizer(){
		FoodList = Food.readString().split("[\n]");
		for(int i = 0; i < FoodList.length; i++){
			FoodList[i]=FoodList[i].trim();
		}
		DrinkList = Drinks.readString().split("[\n]");
		for(int i = 0; i < DrinkList.length; i++){
			DrinkList[i]=DrinkList[i].trim();
		}
	}
	
	  
	public String Randomizer(String listName){
		Random rand = new Random(System.nanoTime());
		switch(listName){
		case "Food": return FoodList[rand.nextInt(FoodList.length)];
		case "Drink": return DrinkList[rand.nextInt(DrinkList.length)];
		case "Spook": return SpookList[rand.nextInt(SpookList.length)];
		case "AI": return AIList[rand.nextInt(AIList.length)];
		
		}
		return "Not found";
	}
}
