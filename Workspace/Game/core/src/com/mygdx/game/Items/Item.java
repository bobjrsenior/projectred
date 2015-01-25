package com.mygdx.game.Items;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.Character;

public class Item {
	Texture img;
	public Sprite sprite;
	
	public static ArrayList<Item> items = new ArrayList<Item>();
	
	public String itemType;
	
	
	public Item(){
		items.add(this);
	}
	
	public String getType(){
		return itemType;
	}
	public void setPosition(float PosX, float PosY){
		sprite.setPosition(PosX , PosY);
	}
	
	public void get(){
		setPosition(-100,-100);
	}
	
	public void drop(float PosX , float PosY){
		setPosition(PosX , PosY);
	}
}
