package com.mygdx.game.Items;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Bread extends Food{
	
	
	public Bread(int posX, int posY){
		super();
		nutrition=10;
		img = new Texture("Items/Food/Bread.png");
		sprite = new Sprite(img);
		sprite.setPosition(posX, posY);
	}
	

}
