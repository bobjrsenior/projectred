package com.mygdx.game.Character.Enemy;

import com.badlogic.gdx.graphics.Texture;

public class Zombie extends Enemy {

	public Zombie(float x , float y){
		super(x,y);
		tex = new Texture("People/Zombie.png");
	}
}
