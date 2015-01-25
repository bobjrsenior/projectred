package com.mygdx.game;

import java.util.ArrayList;
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

public class nameDialog {
	public static nameDialog dialog;
	public static ArrayList<String> output = new ArrayList<String>();

	private String name;
	public String text;
	private String[] lines;
	private int num;
	private Sprite sprite;
	
	
	Texture rec;
	
	Texture img;
    Texture person;

    public BitmapFont  font;
    
    TiledMap tiledMap;
    OrthographicCamera camera;
    TiledMapRenderer tiledMapRenderer;

	Random rnd = new Random(System.nanoTime());
	
	//FileReader read = new FileReader();
	
	int width = (int)Gdx.graphics.getWidth();
	int height = (int)Gdx.graphics.getHeight()/3;
	int x = (int)(Gdx.graphics.getHeight() - height);
	int y = (int)(Gdx.graphics.getHeight() - height);
	
	public nameDialog()
	{
		dialog = this;
		//name = type;
		create();
	}

	public void getZombie()
	{
		num = rnd.nextInt();
		FileHandle file = Gdx.files.internal("Scripts/minor(Zombie).txt");
		lines = file.readString().split("[\n]");
		output.add(lines[rnd.nextInt(lines.length)]);
	}
	
	public void getAlien()
	{
		FileHandle file = Gdx.files.internal("Scripts/minor(Alien)");
		lines = file.readString().split("[\n]");
		output.add(lines[rnd.nextInt(lines.length)]);
		
	}
	
	public void getHuman()
	{
		num = rnd.nextInt();
		FileHandle file = Gdx.files.internal("Scripts/minor(Human).txt");
		lines = file.readString().split("[\n]");
		output.add(lines[rnd.nextInt(lines.length)]);
	}
	
	public void addLine(String line){
		output.add(line);
	}
	
	public void removeLine(){
		output.remove(output.size() - 1);
	}
	
	public void removeLine(int index){
		output.remove(index);
	}
	
	public void clear(){
		output.clear();
	}
	
	public void create(){
		font = new BitmapFont();
        font.setColor(Color.GREEN);
	}
	
	
	public void render(SpriteBatch batch)
	{
		//batch.begin();
		//sprite.draw(batch);
		//font.draw(batch, text, x, y);
		//batch.end();
	}

}
