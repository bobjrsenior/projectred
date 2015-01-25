package com.mygdx.game.Items;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Item {
	public Texture img;
	public Sprite sprite;
	
	public static ArrayList<Item> items = new ArrayList<Item>();
	
	public String itemType;
	
	public int rarity;
	
	public float x;
	public float y;
	
	public Item(float x, float y){
		this.x = x;
		this.y = y;
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
