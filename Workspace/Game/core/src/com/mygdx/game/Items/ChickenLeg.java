package com.mygdx.game.Items;

import com.badlogic.gdx.graphics.Texture;

public class ChickenLeg extends Food{
	
	
	public ChickenLeg(float x, float y){
		super(x,y);
		nutrition= 25;
		rarity = 50;
		img = new Texture("Items/Food/chickenleg.png");
		//sprite = new Sprite(img);
		///sprite.setPosition(posX, posY);
	}
	

}