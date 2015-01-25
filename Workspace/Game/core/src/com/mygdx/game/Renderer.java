package com.mygdx.game;

import java.util.ArrayList;

//import javax.xml.stream.events.Characters;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Items.Item;
import com.mygdx.game.Character.Character;

public class Renderer {
	ArrayList<Item> itemRenders;
	ArrayList<Character> characterRenders;
	ArrayList<Obstacle> obstacleRenders;
	ArrayList<String> dialogRenders;
	ArrayList<Corpse> corpseRenders;
	
	SpriteBatch batch;
	
	public Renderer(){
		
		batch = new SpriteBatch();
		
		itemRenders = Item.items;
		characterRenders = Character.characters;
		obstacleRenders = Obstacle.obstacles;
		dialogRenders = nameDialog.output;
	}
	
	public void Dispose(){
		for(int i = 0; i < itemRenders.size()-1; i++){
			Item j = itemRenders.get(i);
			j.img.dispose();
		}
		
		for(int i = 0; i < characterRenders.size()-1; i++){
			Character c = characterRenders.get(i);
			c.tex.dispose();
		}
		
		for(int i = 0; i < obstacleRenders.size()-1; i++){
			Obstacle o = obstacleRenders.get(i);
			o.tex.dispose();
		}
		for(int i = 0; i <corpseRenders.size()-1; i++){
			Corpse o = corpseRenders.get(i);
			o.tex.dispose();
		}
		nameDialog.dialog.font.dispose();
		batch.dispose();
	}
	
	public void Render(){
		
		for(int i = 0; i < characterRenders.size(); i++){
			Character c = characterRenders.get(i);
			c.update();	
		}
		//System.out.println(characterRenders.size());
		
		batch.begin();
		
		for(int i = 0; i < itemRenders.size(); i++){
			Item j = itemRenders.get(i);
			//j.sprite.draw(batch);
			batch.draw(j.img, j.x + BasicMap.camoffset.x, j.y + BasicMap.camoffset.y);
		}
		
		for(int i = 0; i < characterRenders.size(); i++){
			Character c = characterRenders.get(i);
			batch.draw(c.tex, c.x + BasicMap.camoffset.x, c.y + BasicMap.camoffset.y);	
		}
		
		for(int i = 0; i < obstacleRenders.size(); i++){
			Obstacle o = obstacleRenders.get(i);
			batch.draw(o.tex, o.x + BasicMap.camoffset.x, o.y + BasicMap.camoffset.y);	
		}

		String text = "";
		for(String s : dialogRenders){
			text += s + "\n";
		}
		
		nameDialog.dialog.font.drawMultiLine(batch, text, nameDialog.dialog.x, nameDialog.dialog.y);
		
		batch.end();
	}
	

}
