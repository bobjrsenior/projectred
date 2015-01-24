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
import com.badlogic.gdx.math.Vector3;

public class BasicMap extends ApplicationAdapter implements InputProcessor {
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
    NPC test_player2;
    Human npc;
    
    //Player test_player;
    Enemy test_npc;
    
    @Override
    public void create () {    	
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        batch = new SpriteBatch();

        camera = new OrthographicCamera();
        camera.setToOrtho(false,w,h);
        camera.update();
        
        player = new Player(75, 50,new Texture("player.png"));
        player.setCollider(15f, 15f);
        
        test_player2 = new NPC(75, 150,new Texture("person.png"));
        test_player2.setCollider(15f, 15f);
        
        //test_player2.startFollow(player);
        
        npc = new Human(300, 50,new Texture("person.png"));
        npc.setCollider(15f, 15f);

        //test_player = new Player(75, 50,new Texture("person.png"));
        //test_player.setCollider(15f, 15f);
        test_npc = new Enemy(75, 350,new Texture("alienFriend.png"));
        test_npc.setCollider(15f, 15f);
        test_npc.startFollow(player);

        person = new Texture("person.png");
        //sprite = new Sprite(person);
        //sprite.setPosition(w/2 -sprite.getWidth()/2, h/2 -sprite.getHeight()/2);
        tiledMap = new TmxMapLoader().load("Map/map2.tmx");
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
    	test_player2.update();
    	npc.update();
    	test_npc.update();
    	
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
        batch.draw(test_player2.tex, test_player2.x + camoffset.x, test_player2.y + camoffset.y);
        batch.draw(npc.tex, npc.x + camoffset.x, npc.y + camoffset.y);

        //batch.draw(test_player.tex, test_player.x, test_player.y);
        batch.draw(test_npc.tex, test_npc.x + camoffset.x, test_npc.y + camoffset.y);
        
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