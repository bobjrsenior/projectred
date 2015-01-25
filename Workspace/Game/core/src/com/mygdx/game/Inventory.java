package com.mygdx.game;

import java.util.ArrayList;

import com.mygdx.game.Character.Character;
import com.mygdx.game.Character.Player;
import com.mygdx.game.Items.Food;
import com.mygdx.game.Items.Item;


public class Inventory {
	
	private String text;
	ArrayList<Item> inventory = new ArrayList<Item>();
	
	public void get(Item item)
	{
		inventory.add(item);
		item.get();
	}
	
	public void drop(Character person , Item item)
	{
		inventory.add(item);
		item.drop(person.x , person.y);
	}
	
	public String use(Player person , Food item)
	{
		for(int i = 0; i < inventory.size() - 1; i++)
		{
			if (inventory.get(i) == item)
			{
				item.eat(person);
				inventory.remove(i);
				text = "Used " + item;
				return text;
			}	
		}
		
		return "none";
	}
}
