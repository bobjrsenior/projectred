package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Shape2D;

public class Character {
	//Debug: Gdx.app.log("Character", "Text");
	
	public static ArrayList<Character> characters = new ArrayList<Character>();
	public int char_index;
	
	public int health = 100;
	public float x,y;
	
	public Texture tex;
	
	private Collisions collider;
	public boolean has_collider = false;
	
	
	public Character(float x, float y, Texture tex) {
		this.x = x;
		this.y = y;
		this.tex = tex;
		
		collider = new Collisions();
	}

	public Character(Texture tex) {
		Gdx.app.log("Character","Pos not set");
		this.x = 0;
		this.y = 0;
		this.tex = tex;
		
		collider = new Collisions();
	}
	
	//Can be called every frame if designated in map
	public void update(){
		
	}
	
	public int addCharacter(Character c){
		characters.add(c);
		return characters.size() - 1;
	}
	
	public void setCollider(){
		collider.setRectangle(x, y, 10, 10);
		has_collider = true;
	}
	
	public void setCollider(float width, float height){
		collider.setRectangle(x, y, width, height);
		has_collider = true;
	}
	
	public void setCollider(float radius){
		collider.setCircle(x, y, radius);
		has_collider = true;
	}
	
	public void setCollider(Shape2D shape){
		try{
			if(((Circle) shape).radius != 0){
				collider.setCircle(shape);
			}
		}
		catch (java.lang.ClassCastException e){
			collider.setRectangle(shape);
		}
		has_collider = true;
	}
	
	public Shape2D getCollider(){
		return collider.getCollider();
	}
	
	public void setPosition(float x, float y){
		this.x = x;
		this.y = y;
		if(has_collider){
			collider.setPosition(x, y);
		}
		else{
			Gdx.app.log("Character", "No Collider");
		}
	}
	
	public void translate(float x, float y){
		this.x += x;
		this.y += y;
		if(has_collider){
			collider.setPosition(this.x, this.y);
		}
		else{
			Gdx.app.log("Character", "No Collider");
		}
	}
	
	public boolean isColliding(Shape2D other){
		return collider.isColliding(other);
	}
}
