package com.mygdx.game.Items;

import com.mygdx.game.Character.Player;

public class Drink extends Item {
	public int quench;
	
	
	public Drink(float x, float y){
		super(x,y);
		itemType="Drink";
	}

	public void drink(Player player){
		player.drink(quench);
	}
}

