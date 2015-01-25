package com.mygdx.game;

import com.badlogic.gdx.Game;

 public class SceneManager extends Game {

         TitleScreen mainMenuScreen;
         BasicMap basicMapScreen;
         Indoors indoorScreen;

        @Override
         public void create() {
             mainMenuScreen = new TitleScreen(this);
             basicMapScreen = new BasicMap(this);
             indoorScreen = new Indoors(this);
             setScreen(mainMenuScreen);   
         }
  }

