package com.mygdx.game;

import java.awt.event.KeyListener;
import java.util.*;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sun.glass.events.KeyEvent;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	
	Scanner scan = new Scanner(System.in);
	Movement go = new Movement();
	KeyListener kl;
	boolean con = true; //continue
	
	//Title screen
	
	
	//Movements (WASD)
	//Move Up (W)
	public void keyPressed(KeyEvent w) 
	{
		go.move('w');
	}
	
	
}
