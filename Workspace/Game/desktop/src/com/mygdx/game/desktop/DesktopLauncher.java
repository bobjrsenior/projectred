package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
//import com.mygdx.game.MyGdxGame;
import com.mygdx.game.BasicMap;
//import com.mygdx.game.*;
//import com.mygdx.game.MyGdxGame;
//import com.mygdx.game.BasicMap;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		//new LwjglApplication(new TitleScreen(), config);
		//new LwjglApplication(new MyGdxGame(), config);
		new LwjglApplication(new BasicMap(), config);
	}
}