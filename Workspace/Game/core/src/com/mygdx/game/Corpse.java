package com.mygdx.game;

import java.util.*;
import com.badlogic.gdx.graphics.Texture;

public class Corpse {
		Texture tex;
		int corpseTimer;
		public static ArrayList<Corpse> corpses = new ArrayList<Corpse>();
		float x;
		float y;
		
		public Corpse(float x, float y){
			this.x=x;
			this.y=y;
			tex = new Texture("People/deadGuy1");
			corpseTimer=0;
			corpses.add(this);
		}
}
