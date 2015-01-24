package com.mygdx.game;

import java.util.Random;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.*;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

public class Dialog 
{
	private String name;
	private String text;
	private int num;
	private Texture dialogBox;
	private SpriteBatch batch;
	private Sprite sprite;

	Random rnd = new Random();
	
	//FileReader read = new FileReader();
	
	int width = (int)Gdx.graphics.getWidth();
	int height = (int)Gdx.graphics.getHeight()/3;
	int x = 0;
	int y = (int)Gdx.graphics.getHeight() - height;
	Rectangle rec = new Rectangle(x, y, width, height);
	
	Sprite = new sprite(rec);
	
	public Dialog(String type)
	{
		name = type;
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
	
	public String write()
	{
		batch.begin();
		sprite.draw(batch);
		
		batch.end();
	}

}
