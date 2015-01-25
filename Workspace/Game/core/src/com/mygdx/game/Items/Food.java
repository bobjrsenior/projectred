package com.mygdx.game.Items;

import com.mygdx.game.Player;

public class Food extends Item{
	public int nutrition;
	
	
	public Food(){
		super();
		itemType="Food";
	}

	public void eat(Player player){
		player.eat(nutrition);
	}
}
