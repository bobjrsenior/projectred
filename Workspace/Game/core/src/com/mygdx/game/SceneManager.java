package com.mygdx.game;

import com.badlogic.gdx.Game;

 public class SceneManager extends Game {

         TitleScreen mainMenuScreen;
         BasicMap basicMapScreen;
         Indoors indoorScreen;
         public static SceneManager g;

        @Override
         public void create() {
        	 g=this;
             mainMenuScreen = new TitleScreen(this);
             basicMapScreen = new BasicMap(this);
             indoorScreen = new Indoors(this);
             setScreen(mainMenuScreen);   
         }
  }

