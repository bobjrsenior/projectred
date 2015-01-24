package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Shape2D;

public class Player {
	
	public float x,y;
	
	public Texture tex;
	
	private Collisions collider;
	public boolean has_collider = false;
	
	
	public Player(float x, float y, Texture tex) {
		this.x = x;
		this.y = y;
		this.tex = tex;
		
		collider = new Collisions();
	}

	public Player(Texture tex) {
		Gdx.app.log("User","Pos not set");
		this.x = 0;
		this.y = 0;
		this.tex = tex;
	}
	
	public void setCollider(float width, float height){
		collider.setRectangle(x, y, width, height);
	}
	
	public void setCollider(float radius){
		collider.setCircle(x, y, radius);
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
	}
	
	public Shape2D getCollider(){
		return collider.getCollider();
	}
	
	public void setPosition(float x, float y){
		this.x = x;
		this.y = y;
		collider.setPosition(x, y);
	}
	
	public void translate(float x, float y){
		this.x += x;
		this.y += y;
		collider.setPosition(this.x, this.y);
	}
	
	public boolean isColliding(Shape2D other){
		return collider.isColliding(other);
	}
}
