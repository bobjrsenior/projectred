package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Shape2D;

public class Player extends Character implements InputProcessor{
	//Debug: Gdx.app.log("Player", "Text");
	
	public int thirst;
	public int hunger;
	
	public Player(float x, float y, Texture tex) {
		super(x, y, tex);
		char_index = addCharacter(this);
	}
	
	@Override
	public boolean keyUp(int keycode){
		Gdx.app.log("Player", "" + x + " : " + y);
		boolean hitting = false;
        if(keycode == Input.Keys.LEFT || keycode == Input.Keys.A){
        	translate(-tilesize,0);
        	for(int e = 0; e < characters.size(); e ++){
		    	if(isColliding(characters.get(e).getCollider()) && e != char_index){
		    		translate(tilesize,0);
		    		hit(e);
		    		hitting = true;
		    		break;
		    	}
        	}
        	if(!hitting){
            	for(int e = 0; e < Obstacle.obstacles.size(); e ++){
    		    	if(isColliding(Obstacle.obstacles.get(e).getCollider())){
    		    		translate(tilesize,0);
    		    		hitOb(e);
    		    		break;
    		    	}
            	}
        	}
        }
        if(keycode == Input.Keys.RIGHT || keycode == Input.Keys.D){
        	translate(tilesize,0);
        	for(int e = 0; e < characters.size(); e ++){
		    	if(isColliding(characters.get(e).getCollider()) && e != char_index){
		    		translate(-tilesize,0);
		    		hitting = true;
		    		break;
		    	}
        	}
        	if(!hitting){
            	for(int e = 0; e < Obstacle.obstacles.size(); e ++){
    		    	if(isColliding(Obstacle.obstacles.get(e).getCollider())){
    		    		translate(-tilesize,0);
    		    		hitOb(e);
    		    		break;
    		    	}
            	}
        	}
        }
        if(keycode == Input.Keys.UP || keycode == Input.Keys.W){
        	translate(0,tilesize);
        	for(int e = 0; e < characters.size(); e ++){
		    	if(isColliding(characters.get(e).getCollider()) && e != char_index){
		    		translate(0,-tilesize);
		    		hitting = true;
		    		break;
		    	}
        	}
        	if(!hitting){
            	for(int e = 0; e < Obstacle.obstacles.size(); e ++){
    		    	if(isColliding(Obstacle.obstacles.get(e).getCollider())){
    		    		translate(0,-tilesize);
    		    		hitOb(e);
    		    		break;
    		    	}
            	}
        	}
        }
        if(keycode == Input.Keys.DOWN || keycode == Input.Keys.S){
        	translate(0,-tilesize);
        	for(int e = 0; e < characters.size(); e ++){
		    	if(isColliding(characters.get(e).getCollider()) && e != char_index){
		    		translate(0,tilesize);
		    		hitting = true;
		    		break;
		    	}
        	}
        	if(!hitting){
            	for(int e = 0; e < Obstacle.obstacles.size(); e ++){
    		    	if(isColliding(Obstacle.obstacles.get(e).getCollider())){
    		    		translate(0,tilesize);
    		    		hitOb(e);
    		    		break;
    		    	}
            	}
        	}
        }
        return false;
	}
	
	public void hit(int index){
		if(characters.get(index) instanceof Enemy){
			health -= 10;
			Gdx.app.log("Player", " " + health);
		}
		else if(characters.get(index) instanceof NPC){
			((NPC) characters.get(index)).talk();
		}
	}
	
	public void hitOb(int index){
		
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
}
