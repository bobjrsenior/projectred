package com.mygdx.game.Items;

import com.badlogic.gdx.graphics.Texture;

public class Bread extends Food{
	
	
	public Bread(float x, float y){
		super(x,y);
		nutrition = 10;
		rarity = 10;
		img = new Texture("Items/Food/bread.png");
		
	}
	

}
