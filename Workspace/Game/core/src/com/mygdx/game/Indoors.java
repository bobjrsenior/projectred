package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector3;

public class Indoors extends ApplicationAdapter implements InputProcessor, Screen {
    Texture img;
    Texture person;
    SpriteBatch batch;
    Sprite sprite;
    
    TiledMap tiledMap;
    OrthographicCamera camera;
    TiledMapRenderer tiledMapRenderer;
    
    Vector3 initialcampos;
    Vector3 camoffset;
    
    Player player;
    //NPC test_player2;
    //Human npc;
    
    //Player test_player;
    //Enemy test_npc;
    
    SceneManager game;
    
    public Indoors(SceneManager g){
    	game = g;
    	
    }
    
    @Override
    public void create () {

        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        batch = new SpriteBatch();

        camera = new OrthographicCamera();
        camera.setToOrtho(false,w,h);
        camera.update();
        
        player = new Player(-100, -100);
        player.setCollider(15f, 15f);
        

        person = new Texture("person.png");
        //sprite = new Sprite(person);
        //sprite.setPosition(w/2 -sprite.getWidth()/2, h/2 -sprite.getHeight()/2);
        tiledMap = new TmxMapLoader().load("Map/indoorsMap.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
        Gdx.input.setInputProcessor(this);
        
    	InputProcessor inputProcessorOne = player;
    	InputProcessor inputProcessorTwo = this;
    	InputMultiplexer inputMultiplexer = new InputMultiplexer();
    	inputMultiplexer.addProcessor(inputProcessorOne);
    	inputMultiplexer.addProcessor(inputProcessorTwo);
    	Gdx.input.setInputProcessor(inputMultiplexer);
    	
    	initialcampos = new Vector3(camera.position);
    	camoffset = new Vector3(0,0,0);
    }
    
    public void dispose() {
    	batch.dispose();
    	person.dispose();
    }

    @Override
    public void render () {
    	//Call various classes update methods
    	
    	//Make the camera centered around the player
    	Vector3 translation = new Vector3(player.x - camera.position.x,player.y - camera.position.y,0);
    	camera.translate(translation);
    	//Figure out how much the camera moved from it's original position
    	camoffset = new Vector3(initialcampos.x - camera.position.x, initialcampos.y - camera.position.y,0);
  	
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        tiledMapRenderer.setView(camera);
        tiledMapRenderer.render();
        
        batch.begin();
        batch.draw(player.tex, player.x + camoffset.x, player.y + camoffset.y);
        //lower left person
        
        batch.end();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if(keycode == Input.Keys.NUM_1)
            tiledMap.getLayers().get(0).setVisible(!tiledMap.getLayers().get(0).isVisible());
        if(keycode == Input.Keys.NUM_2)
            tiledMap.getLayers().get(1).setVisible(!tiledMap.getLayers().get(1).isVisible());
        return false;
    }

    @Override
    public boolean keyTyped(char character) {

        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

	@Override
	public void show() {
		create();
		
	}

	@Override
	public void render(float delta) {
		render();
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}
}