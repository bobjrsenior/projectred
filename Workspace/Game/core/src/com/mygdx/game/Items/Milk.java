package com.mygdx.game.Items;

import com.badlogic.gdx.graphics.Texture;

public class Milk extends Drink{
	public Milk(float x, float y){
		super(x,y);
		quench = 40;
		rarity = 10;
		img = new Texture("Items/Drinks/milk.png");
		
	}
	

}