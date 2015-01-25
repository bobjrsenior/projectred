package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Shape2D;

public class Collisions {
	//Debug: Gdx.app.log("Collisions", "Text");	
	
	private Shape2D collider;
	//true = rectangle false = circle
	private boolean shape;

	public Collisions() {
		
	}
	
	public void setRectangle(float x, float y, float width, float height){
		collider = new Rectangle();
		((Rectangle) collider).set(x, y, width, height);
		shape = true;
	}
	
	public void setRectangle(Shape2D other){
		collider = new Rectangle((Rectangle) other);
		shape = true;
	}
	
	public void setCircle(float x, float y, float radius){
		collider = new Circle();
		((Circle) collider).set(x, y, radius);
		shape = false;
	}
	
	public void setCircle(Shape2D other){
		collider = new Circle((Circle) other);
		shape = true;
	}
	
	public void setPosition(float x, float y){
		if(shape){
			((Rectangle) collider).x = x;
			((Rectangle) collider).y = y;
		}
		else{
			((Circle) collider).x = x;
			((Circle) collider).y = y;
		}

	}
	
	public void setX(float x){
		if(shape){
			((Rectangle) collider).x = x;
		}
		else{
			((Circle) collider).x = x;
		}
	}
	
	public void setY(float y){
		if(shape){
			((Rectangle) collider).y = y;
		}
		else{
			((Circle) collider).y = y;
		}
	}
	
	public boolean isColliding(Shape2D other){
		try{
			if(((Circle) other).radius != 0){
				//true = rectangle false = circle
				if(shape){
					return Intersector.overlaps((Circle) other, (Rectangle) collider);
				}
				else{
					return Intersector.overlaps((Circle) other, (Circle) collider);
				}
			}
		}
		catch (java.lang.ClassCastException e){
			//true = rectangle false = circle
			if(shape){
				return Intersector.overlaps((Rectangle) collider, (Rectangle) other);
			}
			else{
				return Intersector.overlaps((Circle) collider, (Rectangle) other);
			}
		}
		return false;
	}

	public Shape2D getCollider() {
		return collider;
	}
	
}
