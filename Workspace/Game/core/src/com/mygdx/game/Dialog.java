package com.mygdx.game;

import java.util.Random;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

public class Dialog 
{
	private String name;
	private String text;
	private int num;
	private SpriteBatch batch;
	private Sprite sprite;
	
	Texture img;
    Texture person;

    BitmapFont font;
    
    TiledMap tiledMap;
    OrthographicCamera camera;
    TiledMapRenderer tiledMapRenderer;

	Random rnd = new Random();
	
	//takes in the race if minor and the name if Major
	public Dialog(String type)
	{
		name = type;
		
		if(name == "zombie")
			getZombie();
		else if (name == "Alien")
			getAlien();
		else if (name == "Human")
			getHuman();
	}

	public void getZombie()
	{
		num = rnd.nextInt();
		FileHandle file = Gdx.files.internal("minor(Zombie).txt");
		for (int i = 0; i < num; i++)
		{
			text = file.readString();
		}		
	}
	
	public void getAlien()
	{
		num = rnd.nextInt();
		FileHandle file = Gdx.files.internal("minor(Alien).txt");
		for (int i = 0; i < num; i++)
		{
			text = file.readString();
		}	
	}
	
	public void getHuman()
	{
		num = rnd.nextInt();
		FileHandle file = Gdx.files.internal("minor(Human).txt");
		for (int i = 0; i < num; i++)
		{
			text = file.readString();
		}	
	}
	
	public void create(){
		font = new BitmapFont();
        font.setColor(Color.GREEN);
	}
	
	
	public void render()
	{
		batch.begin();
		sprite.draw(batch);
		font.draw(batch, text, 50, 200);
		batch.end();
	}

}
