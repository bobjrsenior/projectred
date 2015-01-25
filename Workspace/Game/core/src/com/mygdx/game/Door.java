package com.mygdx.game;


public class Door {
	public int ID;
	
	public Door(int id){
		this.ID=id;
		
	}
	
	public void use(Character person){
		if(SceneManager.g.getScreen() instanceof BasicMap) SceneManager.g.setScreen(SceneManager.g.indoorScreen);
		else	SceneManager.g.setScreen(SceneManager.g.basicMapScreen);
		
		
	}
}
