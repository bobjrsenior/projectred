package com.mygdx.game.Character;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Shape2D;
import com.mygdx.game.Inventory;
import com.mygdx.game.Obstacle;
import com.mygdx.game.nameDialog;
import com.mygdx.game.Character.Character;
import com.mygdx.game.Character.Enemy.Enemy;
import com.mygdx.game.Character.NPC.NPC;

public class Player extends Character implements InputProcessor{
	
	public static Player p;
	
	
	public Inventory inventory;
	
	private boolean[] walking = {false,false,false,false};
	private float walkdelay = .2f;
	private float[] walktimer = new float[4];
	
	
	public int thirst;
	public int hunger;
	
	public Player(float x, float y) {
		super(x, y);
		p = this;
		tex = new Texture("People/Player.png");
		char_index = addCharacter(this);
		inventory = new Inventory();
		hunger = 100;
		thirst = 100;
	}
	
	public void eat(int nutrition){
		hunger += nutrition;
		if(hunger > 100) hunger = 100;	
	}
	
	public void drink(int quench){
		hunger += quench;
		if(thirst > 100) thirst = 100;	
	}
	
	public void hit(int index){
		if(characters.get(index) instanceof Enemy){
			health -= 10;
			Gdx.app.log("Player", " " + health);
			nameDialog.dialog.getHuman();
		}
		else if(characters.get(index) instanceof NPC){
			((NPC) characters.get(index)).talk();
		}
	}
	
	public void hitOb(int index){
		
	}
	
	@Override
	public void update(){
		boolean hitting = false;
		super.update();
		if(walking[0]){
			walktimer[0] += Gdx.graphics.getDeltaTime();
			if(walktimer[0] >= walkdelay){
				walktimer[0] = 0;
	        	translate(-tilesize,0);
	        	for(int e = 0; e < characters.size(); e ++){
			    	if(distance(x,y,characters.get(e).x, characters.get(e).y) < 2 * Player.p.tilesize && isColliding(characters.get(e).getCollider()) && e != char_index){
			    		translate(tilesize,0);
			    		hit(e);
			    		hitting = true;
			    		break;
			    	}
	        	}
	        	if(!hitting){
	            	for(int e = 0; e < Obstacle.obstacles.size(); e ++){
	    		    	if(distance(x,y,Obstacle.obstacles.get(e).x, Obstacle.obstacles.get(e).y) < 2 * Player.p.tilesize && isColliding(Obstacle.obstacles.get(e).getCollider())){
	    		    		translate(tilesize,0);
	    		    		hitOb(e);
	    		    		hitting = true;
	    		    		break;
	    		    	}
	            	}
	        	}
	        	if(!hitting){
	            	for(int e = 0; e < Obstacle.hiddenobstacles.size(); e ++){
	    		    	if(distance(x,y,Obstacle.hiddenobstacles.get(e).x, Obstacle.hiddenobstacles.get(e).y) < 2 * Player.p.tilesize && isColliding(Obstacle.hiddenobstacles.get(e).getCollider())){
	    		    		translate(tilesize,0);
	    		    		hitOb(e);
	    		    		hitting = true;
	    		    		break;
	    		    	}
	            	}
	        	}
			}
		}
		if(walking[1]){
			walktimer[1] += Gdx.graphics.getDeltaTime();
			if(walktimer[1] >= walkdelay){
				walktimer[1] = 0;
	        	translate(tilesize,0);
	        	for(int e = 0; e < characters.size(); e ++){
			    	if(distance(x,y,characters.get(e).x, characters.get(e).y) < 2 * Player.p.tilesize && isColliding(characters.get(e).getCollider()) && e != char_index){
			    		translate(-tilesize,0);
			    		hit(e);
			    		hitting = true;
			    		break;
			    	}
	        	}
	        	if(!hitting){
	            	for(int e = 0; e < Obstacle.obstacles.size(); e ++){
	    		    	if(distance(x,y,Obstacle.obstacles.get(e).x, Obstacle.obstacles.get(e).y) < 2 * Player.p.tilesize && isColliding(Obstacle.obstacles.get(e).getCollider())){
	    		    		translate(-tilesize,0);
	    		    		hitOb(e);
	    		    		hitting = true;
	    		    		break;
	    		    	}
	            	}
	        	}
	        	if(!hitting){
	            	for(int e = 0; e < Obstacle.hiddenobstacles.size(); e ++){
	    		    	if(distance(x,y,Obstacle.hiddenobstacles.get(e).x, Obstacle.hiddenobstacles.get(e).y) < 2 * Player.p.tilesize && isColliding(Obstacle.hiddenobstacles.get(e).getCollider())){
	    		    		translate(-tilesize,0);
	    		    		hitOb(e);
	    		    		hitting = true;
	    		    		break;
	    		    	}
	            	}
	        	}
			}
		}
		if(walking[2]){
			walktimer[2] += Gdx.graphics.getDeltaTime();
			if(walktimer[2] >= walkdelay){
				walktimer[2] = 0;
	        	translate(0,tilesize);
	        	for(int e = 0; e < characters.size(); e ++){
			    	if(distance(x,y,characters.get(e).x, characters.get(e).y) < 2 * Player.p.tilesize && isColliding(characters.get(e).getCollider()) && e != char_index){
			    		translate(0,-tilesize);
			    		hit(e);
			    		hitting = true;
			    		break;
			    	}
	        	}
	        	if(!hitting){
	            	for(int e = 0; e < Obstacle.obstacles.size(); e ++){
	    		    	if(distance(x,y,Obstacle.obstacles.get(e).x, Obstacle.obstacles.get(e).y) < 2 * Player.p.tilesize && isColliding(Obstacle.obstacles.get(e).getCollider())){
	    		    		translate(0,-tilesize);
	    		    		hitOb(e);
	    		    		hitting = true;
	    		    		break;
	    		    	}
	            	}
	        	}
	        	if(!hitting){
	            	for(int e = 0; e < Obstacle.hiddenobstacles.size(); e ++){
	    		    	if(distance(x,y,Obstacle.hiddenobstacles.get(e).x, Obstacle.hiddenobstacles.get(e).y) < 2 * Player.p.tilesize && isColliding(Obstacle.hiddenobstacles.get(e).getCollider())){
	    		    		translate(0,-tilesize);
	    		    		hitOb(e);
	    		    		hitting = true;
	    		    		break;
	    		    	}
	            	}
	        	}
			}
		}
		if(walking[3]){
			walktimer[3] += Gdx.graphics.getDeltaTime();
			if(walktimer[3] >= walkdelay){
				walktimer[3] = 0;
	        	translate(0,-tilesize);
	        	for(int e = 0; e < characters.size(); e ++){
			    	if(distance(x,y,characters.get(e).x, characters.get(e).y) < 2 * Player.p.tilesize && isColliding(characters.get(e).getCollider()) && e != char_index){
			    		translate(0,tilesize);
			    		hit(e);
			    		hitting = true;
			    		break;
			    	}
	        	}
	        	if(!hitting){
	            	for(int e = 0; e < Obstacle.obstacles.size(); e ++){
	    		    	if(distance(x,y,Obstacle.obstacles.get(e).x, Obstacle.obstacles.get(e).y) < 2 * Player.p.tilesize && isColliding(Obstacle.obstacles.get(e).getCollider())){
	    		    		translate(0,tilesize);
	    		    		hitOb(e);
	    		    		hitting = true;
	    		    		break;
	    		    	}
	            	}
	        	}
	        	if(!hitting){
	            	for(int e = 0; e < Obstacle.hiddenobstacles.size(); e ++){
	    		    	if(distance(x,y,Obstacle.hiddenobstacles.get(e).x, Obstacle.hiddenobstacles.get(e).y) < 2 * Player.p.tilesize && isColliding(Obstacle.hiddenobstacles.get(e).getCollider())){
	    		    		translate(0,tilesize);
	    		    		hitOb(e);
	    		    		hitting = true;
	    		    		break;
	    		    	}
	            	}
	        	}
			}
		}
		
	}

	@Override
	public boolean keyDown(int keycode) {
        if(keycode == Input.Keys.LEFT || keycode == Input.Keys.A){
        	walking[0] = true;
        }
        if(keycode == Input.Keys.RIGHT || keycode == Input.Keys.D){
        	walking[1] = true;
        }
        if(keycode == Input.Keys.UP || keycode == Input.Keys.W){
        	walking[2] = true;
        }
        if(keycode == Input.Keys.DOWN || keycode == Input.Keys.S){
        	walking[3] = true;
        }
		return false;
	}
	
	@Override
	public boolean keyUp(int keycode){
        if(keycode == Input.Keys.LEFT || keycode == Input.Keys.A){
        	walking[0] = false;

        }
        if(keycode == Input.Keys.RIGHT || keycode == Input.Keys.D){
        	walking[1] = false;
        }
        if(keycode == Input.Keys.UP || keycode == Input.Keys.W){
        	walking[2] = false;
        }
        if(keycode == Input.Keys.DOWN || keycode == Input.Keys.S){
        	walking[3] = false;
        }
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
