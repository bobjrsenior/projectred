package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Enemy extends Character{
	//Debug: Gdx.app.log("Enemy", "Text");
	
	
	public boolean following;
	public Character follow;
	//In steps per second
	public float followspeed = 3;
	private float followtimer = 0;
	
	public Enemy(float x, float y, Texture tex){
		super(x,y,tex);
	}
	
	@Override
	public void update(){
		super.update();
		if(following){
			followtimer += Gdx.graphics.getDeltaTime();
			if(followtimer >= (1.0 / followspeed)){
				followtimer = 0;
				followStep();
			}
		}
	}
	
	public void startFollow(){
		if(follow == null){
			Gdx.app.log("Enemy", "Noone to follow");
		}
		else{
			following = true;
		}
	}
	
	public void startFollow(Character c){
		following = true;
		follow = c;
	}
	
	public void stopFollow(){
		following = false;
		followtimer = 0;
	}
	
	public void followStep(){
		int xdif = (int) (follow.x - x);
		int ydif = (int) (follow.y - y);
		if(Math.abs(xdif) > Math.abs(ydif)){
			translate(32 * Math.signum(xdif), 0);
		}
		else{
			translate(0, 32 * Math.signum(ydif));
		}
	}
	
	
}
