package com.mygdx.game;

import java.util.ArrayList;

public class Inventory {
	
	private String text;
	ArrayList<String> inventory = new ArrayList<String>();
	
	public void add(String item)
	{
		inventory.add(item);
	}
	
	public String use(String item)
	{
		for(int i = 0; i < inventory.size() - 1; i++)
		{
			if (inventory.get(i) == item)
			{
				inventory.remove(i);
				text = "Used " + item;
				return text;
			}
		}
		return "none";
	}
}
