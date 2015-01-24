package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class BasicMap extends ApplicationAdapter implements InputProcessor {
    Texture img;
    Texture person;
    SpriteBatch batch;
    Sprite sprite;
    
    TiledMap tiledMap;
    OrthographicCamera camera;
    TiledMapRenderer tiledMapRenderer;
    
    Player test_player;
    Enemy test_npc;
    
    @Override
    public void create () {    	
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        batch = new SpriteBatch();

        camera = new OrthographicCamera();
        camera.setToOrtho(false,w,h);
        camera.update();
        test_player = new Player(75, 50,new Texture("person.png"));
        test_player.setCollider(15f, 15f);
        test_npc = new Enemy(75, 350,new Texture("person.png"));
        test_npc.setCollider(15f, 15f);
        test_npc.startFollow(test_player);
        person = new Texture("person.png");
        sprite = new Sprite(person);
        sprite.setPosition(w/2 -sprite.getWidth()/2, h/2 -sprite.getHeight()/2);
        tiledMap = new TmxMapLoader().load("map3.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
        Gdx.input.setInputProcessor(this);
        
    	InputProcessor inputProcessorOne = test_player;
    	InputProcessor inputProcessorTwo = this;
    	InputMultiplexer inputMultiplexer = new InputMultiplexer();
    	inputMultiplexer.addProcessor(inputProcessorOne);
    	inputMultiplexer.addProcessor(inputProcessorTwo);
    	Gdx.input.setInputProcessor(inputMultiplexer);
    }
    
    public void dispose() {
    	batch.dispose();
    	person.dispose();
    }

    @Override
    public void render () {
    	//Call various classes update methods
    	test_npc.update();
    	
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        tiledMapRenderer.setView(camera);
        tiledMapRenderer.render();
        batch.begin();
        sprite.draw(batch);
        batch.draw(test_player.tex, test_player.x, test_player.y);
        batch.draw(test_npc.tex, test_npc.x, test_npc.y);
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
}