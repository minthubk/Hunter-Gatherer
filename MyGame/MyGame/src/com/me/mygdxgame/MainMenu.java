/* http://steigert.blogspot.se/2012/03/4-libgdx-tutorial-tablelayout.html
 * 
 *  (TODO) Menu 
*/

package com.me.mygdxgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainMenu implements Screen
{	
	private Texture background;
	private Texture startgame;
	private Texture info;
	private Texture exitgame;
	private SpriteBatch spriteBatch;
	
	private MyGdxGame game;
	public MainMenu (MyGdxGame game)
	{
		this.game = game;
	}
	
	Level1 gameScreen = new Level1(game);
	Gamedata data = new Gamedata();
	Map gamemap = new Map();
	
	@Override
	public void render (float delta)
	{
		GL20 gl = Gdx.graphics.getGL20();
		gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		spriteBatch.begin();
		spriteBatch.draw(background, 0, 0);
		spriteBatch.draw(startgame, 280, 330);
		spriteBatch.draw(info, 280, 210);
		spriteBatch.draw(exitgame, 280, 90);
		spriteBatch.end();
		
		handleInput();
	}
	
	private void handleInput()
	{
		if(Gdx.input.justTouched())
		{
			System.out.printf("Changing to game screen.. \n");
			Gamedata.CurrentLevel = 2;
			//Map.level = "data/texturemap2";
			game.setScreen(gameScreen);
		}
	}
	
	@Override
    public void show() 
	{
		background = new Texture ( Gdx.files.internal("data/background.png"));
		startgame = new Texture ( Gdx.files.internal("data/startgame.png"));
		info = new Texture ( Gdx.files.internal("data/info.png"));
		exitgame = new Texture ( Gdx.files.internal("data/exit.png"));
		spriteBatch = new SpriteBatch();
    }
	
    @Override
    public void resize(int width, int height) 
    {
    }
    
    @Override
    public void hide() 
    {
    }
    
    @Override
    public void pause() 
    {
    }
    
    @Override
    public void resume() 
    {
    }
    
    public void dispose() 
    {
    }
}
