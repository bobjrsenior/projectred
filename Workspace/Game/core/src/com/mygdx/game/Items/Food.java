package com.mygdx.game.Items;

import com.mygdx.game.Character.Player;

public class Food extends Item{
	public int nutrition;
	
	
	public Food(float x, float y){
		super(x,y);
		itemType="Food";
	}

	public void eat(Player player){
		player.eat(nutrition);
	}
}
