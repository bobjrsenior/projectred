package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Building extends Obstacle{

	int obs_index;
	
	public Building(float x, float y, Texture tex) {
		super(x, y, tex);
		
		obs_index = addObstacle(this);
	}
	
	public void setColliderBuilding(){
		setCollider(new Rectangle(x,y,320,320));
	}
	
	public void setColliderHouse(){
		setCollider(new Rectangle(x,y,320,320));
	}
	
	public void setColliderFactory(){
		setCollider(new Rectangle(x,y,640,320));
	}
	
	public void setColliderCourt(){
		setCollider(new Rectangle(x,y,640,320));
	}
	
	public void setColliderSchool(){
		setCollider(new Rectangle(x,y,640,320));
	}
	
	public void setColliderStore(){
		setCollider(new Rectangle(x,y,640,320));
	}

}