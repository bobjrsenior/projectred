package com.mygdx.game;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Enemy extends Character{
	//Debug: Gdx.app.log("Enemy", "Text");

	public boolean following;
	public Character follow;
	//In steps per second
	public float followspeed = 2;
	private float followtimer = 0;
	private float sightdistance = 250;
	
	public boolean wandering = true;
	public float wanderspeed = 2;
	public float wandertimer = 0;
	private Vector2 dest;
	private int stuckcount = 0;
	
	Random rand = new Random(System.nanoTime());
	
	public Enemy(float x, float y){
		super(x,y);
		tex = new Texture("People/zombie.png");
		char_index = addCharacter(this);
		startWander();
	}
	/*
	public Enemy(float x, float y){
		super(x,y,new Texture("People/zombie.png"));
		char_index = addCharacter(this);
		startWander();
	}
	*/
	@Override
	public void update(){
		super.update();
		if(following && Math.abs(distance()) < sightdistance){
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
	
	public void hit(int index){
		if(characters.get(index) instanceof Player){
			((Player) characters.get(index)).health -= 10;
			Gdx.app.log("Player(e)", " " + characters.get(index).health);
		}
		else if(characters.get(index) instanceof Enemy){
			//
		}
	}
	
	public void hitOb(int index){

	}
	
	public float distance(){
		Vector2 otherpos = follow.getPosition();
		return otherpos.dst(x, y);
	}
	
	//Wander Stuff
	public void startWander(){
		stuckcount = 0;
		dest = new Vector2(rand.nextInt(600) - 300, rand.nextInt(600) - 300);
		dest = dest.add(x, y);
		wandering = true;
		wandering = true;
	}
	
	public void stopWander(){
		wandering = false;
	}
	
	public void wanderStep(){
		boolean hitting = false;
		int xdif = (int) (dest.x - x);
		int ydif = (int) (dest.y - y);
		if(Math.abs(xdif) + Math.abs(ydif) <=  tilesize){
			wandertimer = -rand.nextInt(3);
			startWander();
		}
		else if(Math.abs(xdif) > Math.abs(ydif)){
			translate(tilesize * Math.signum(xdif), 0);
        	for(int e = 0; e < characters.size(); e ++){
		    	if(isColliding(characters.get(e).getCollider()) && e != char_index){
		    		translate(-tilesize * Math.signum(xdif), 0);
		    		stuckcount ++;
		    		hit(e);
		    		hitting = true;
		    		break;
		    	}
        	}
        	if(!hitting){
            	for(int e = 0; e < Obstacle.obstacles.size(); e ++){
    		    	if(isColliding(Obstacle.obstacles.get(e).getCollider())){
    		    		translate(-tilesize * Math.signum(xdif), 0);
    		    		stuckcount ++;
    		    		hitOb(e);
    		    		break;
    		    	}
            	}
        	}
		}
		else{
			translate(0, tilesize * Math.signum(ydif));
        	for(int e = 0; e < characters.size(); e ++){
		    	if(isColliding(characters.get(e).getCollider()) && e != char_index){
		    		translate(-tilesize * Math.signum(ydif), 0);
		    		stuckcount ++;
		    		hit(e);
		    		hitting = true;
		    		break;
		    	}
        	}
        	if(!hitting){
            	for(int e = 0; e < Obstacle.obstacles.size(); e ++){
    		    	if(isColliding(Obstacle.obstacles.get(e).getCollider())){
    		    		translate(-tilesize * Math.signum(ydif), 0);
    		    		stuckcount ++;
    		    		hitOb(e);
    		    		break;
    		    	}
            	}
        	}
		}
		if(stuckcount >= 3){
			startWander();
		}
		
	}
	
	//Following stuff
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
		startWander();
		following = false;
		followtimer = 0;
	}
	
	public void followStep(){
		boolean hitting = false;
		int xdif = (int) (follow.x - x);
		int ydif = (int) (follow.y - y);
		if(Math.abs(xdif) > Math.abs(ydif)){
			translate(tilesize * Math.signum(xdif), 0);
        	for(int e = 0; e < characters.size(); e ++){
		    	if(isColliding(characters.get(e).getCollider()) && e != char_index){

		    		translate(-tilesize * Math.signum(xdif), 0);
		    		hit(e);
		    		hitting = true;
		    		break;
		    	}
        	}
        	if(!hitting){
            	for(int e = 0; e < Obstacle.obstacles.size(); e ++){
    		    	if(isColliding(Obstacle.obstacles.get(e).getCollider())){
    		    		translate(-tilesize * Math.signum(xdif), 0);
    		    		hitOb(e);
    		    		break;
    		    	}
            	}
        	}
		}
		else{
			translate(0, tilesize * Math.signum(ydif));
        	for(int e = 0; e < characters.size(); e ++){
		    	if(isColliding(characters.get(e).getCollider()) && e != char_index){
		    		translate(-tilesize * Math.signum(ydif), 0);
		    		hit(e);
		    		hitting = true;
		    		break;
		    	}
        	}
        	for(int e = 0; e < Obstacle.obstacles.size(); e ++){
		    	if(isColliding(Obstacle.obstacles.get(e).getCollider())){
		    		translate(-tilesize * Math.signum(ydif), 0);
		    		hitOb(e);
		    		break;
		    	}
        	}
    	}
	}
	
}
