package com.mygdx.game.Items;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class ChickenLeg extends Food{
	
	
	public ChickenLeg(int posX, int posY){
		super();
		nutrition= 25;
		rarity = 50;
		img = new Texture("Items/Food/Chickenleg.png");
		sprite = new Sprite(img);
		sprite.setPosition(posX, posY);
	}
	

}