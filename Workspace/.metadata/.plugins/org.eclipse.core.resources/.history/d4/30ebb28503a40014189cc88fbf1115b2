package com.mygdx.game;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class NPC extends Character{
	//Debug: Gdx.app.log("NPC", "Text");
	
	public boolean following;
	public Character follow;
	//In steps per second
	public float followspeed = 2;
	private float followtimer = 0;
	private float sightdistance = 250;
	
	public boolean wandering;
	public float wanderspeed = 2;
	public float wandertimer = 0;
	private Vector2 dest;
	
	Random rand = new Random(System.nanoTime());
	
	public NPC(float x, float y, Texture tex) {
		super(x,y,tex);

		char_index = addCharacter(this);
	}
	
	public void startFollow(Player leader){

		startWander();
	}
	
	@Override
	public void update(){
		super.update();
		if(following && Math.abs(distance(x,y, follow.x, follow.y)) < sightdistance){
			followtimer += Gdx.graphics.getDeltaTime();
			if(followtimer >= (1.0 / followspeed)){
				followtimer = 0;
				followStep();
			}
		}
		else if(wandering){
			wandertimer += Gdx.graphics.getDeltaTime();
			if(wandertimer >= (1.0 / wanderspeed)){
				wandertimer = 0;
				wanderStep();
			}
		}
	}
	
	public void talk(){
		
	}
	
	public void hit(int index){
		if(characters.get(index) instanceof Player){
			Gdx.app.log("NPC", "hit player");
		}
		else if(characters.get(index) instanceof Enemy){
			health -= 10;
		}
	}
	
	//Wander Stuff
	public void startWander(){
		dest = new Vector2(rand.nextInt(600) - 300, rand.nextInt(600) - 300);
		dest = dest.add(x, y);
		wandering = true;
	}
	
	public void stopWander(){
		wandering = false;
	}
	
	public void wanderStep(){
		int xdif = (int) (dest.x - x);
		int ydif = (int) (dest.y - y);
		if(Math.abs(xdif) + Math.abs(ydif) <=  tilesize){
			wandertimer = -rand.nextInt(3);
			startWander();
		}
		else if(Math.abs(xdif) > Math.abs(ydif)){
			translate(32 * Math.signum(xdif), 0);
        	for(int e = 0; e < characters.size(); e ++){
		    	if(isColliding(characters.get(e).getCollider()) && e != char_index){
		    		translate(-tilesize * Math.signum(xdif), 0);
		    		hit(e);
		    		break;
		    	}
        	}
		}
		else{
			translate(0, 32 * Math.signum(ydif));
        	for(int e = 0; e < characters.size(); e ++){
		    	if(isColliding(characters.get(e).getCollider()) && e != char_index){
		    		translate(-tilesize * Math.signum(ydif), 0);
		    		hit(e);
		    		break;
		    	}
        	}
		}
	}
	
	
	//Following stuff
	public void startFollow(){
		if(follow == null){
			Gdx.app.log("NPC", "Noone to follow");
		}
		else{
			following = true;
			stopWander();
		}
	}
	
	public void startFollow(Character c){
		following = true;
		follow = c;
	}
	
	public void stopFollow(){
		following = false;
		followtimer = 0;
		startWander();
	}
	
	public void followStep(){
		int xdif = (int) (follow.x - x);
		int ydif = (int) (follow.y - y);
		if(Math.abs(xdif) > Math.abs(ydif)){
			translate(32 * Math.signum(xdif), 0);
        	for(int e = 0; e < characters.size(); e ++){
		    	if(isColliding(characters.get(e).getCollider()) && e != char_index){
		    		translate(-tilesize * Math.signum(xdif), 0);
		    		break;
		    	}
        	}
		}
		else{
			translate(0, 32 * Math.signum(ydif));
        	for(int e = 0; e < characters.size(); e ++){
		    	if(isColliding(characters.get(e).getCollider()) && e != char_index){
		    		translate(-tilesize * Math.signum(ydif), 0);
		    		hit(e);
		    		break;
		    	}
        	}
		}

	}

}
