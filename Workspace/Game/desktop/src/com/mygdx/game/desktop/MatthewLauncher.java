package com.mygdx.game.desktop;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
//import com.mygdx.game.MyGdxGame;
//import com.mygdx.game.BasicMap;
import com.mygdx.game.SceneManager;

public class MatthewLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		//new LwjglApplication(new StufTest(), config);
		//new LwjglApplication(new MyGdxGame(), config);
		new LwjglApplication(new SceneManager(), config);
	}
}