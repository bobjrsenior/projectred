package com.mygdx.game;

import java.util.ArrayList;

//import javax.xml.stream.events.Characters;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Items.Item;

public class Renderer {
	ArrayList<Item> itemRenders;
	ArrayList<Character> characterRenders;
	ArrayList<Obstacle> obstacleRenders;
	ArrayList<nameDialog> dialogRenders;
	
	SpriteBatch batch;
	
	public Renderer(){
		
		batch = new SpriteBatch();
		
		itemRenders = Item.items;
		characterRenders = Character.characters;
		obstacleRenders = Obstacle.obstacles;
		
		
		
	}
	
	public void Render(){
		
		for(int i = 0; i < characterRenders.size()-1; i++){
			Character c = characterRenders.get(i);
			c.update();	
		}
		
		batch.begin();
		
		for(int i = 0; i < itemRenders.size()-1; i++){
			Item j = itemRenders.get(i);
			j.sprite.draw(batch);
		}
		
		for(int i = 0; i < characterRenders.size()-1; i++){
			Character c = characterRenders.get(i);
			batch.draw(c.tex, c.x + BasicMap.camoffset.x, c.y + BasicMap.camoffset.y);	
		}
		
		for(int i = 0; i < obstacleRenders.size()-1; i++){
			Obstacle o = obstacleRenders.get(i);
			batch.draw(o.tex, o.x + BasicMap.camoffset.x, o.y + BasicMap.camoffset.y);	
		}
		
		
		batch.end();
	}
	

}
