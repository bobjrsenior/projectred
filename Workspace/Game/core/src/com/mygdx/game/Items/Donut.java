package com.mygdx.game.Items;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Donut extends Food{
	
	
	public Donut(int posX, int posY){
		super();
		nutrition = 5;
		rarity = 5;
		img = new Texture("Items/Food/donut.png");
		sprite = new Sprite(img);
		sprite.setPosition(posX, posY);
	}
	

}