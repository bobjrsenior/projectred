package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.BasicMap;
import com.mygdx.game.SceneManager;
import com.mygdx.game.TitleScreen;


public class TestLauncher {

	public static void main(String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Title";
		//config.fullscreen = true;
		config.width = 1280;
		config.height = 720;
		//new LwjglApplication(new StufTest(), config);
		//new LwjglApplication(new MyGdxGame(), config);
		//new LwjglApplication(new SceneManager(), "Test", 1280, 720);
		new LwjglApplication(new SceneManager(), config);

	}

}
