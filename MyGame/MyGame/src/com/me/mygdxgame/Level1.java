/* Game screen */

package com.me.mygdxgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

public class Level1 implements Screen 
{
	OrthographicCamera camera;
	SpriteBatch batch;
	Texture Log;
	Texture Gubbe;
	Texture House;
	Texture Wolf;
	Texture Pekare;
	Texture Grass;
	Texture Road;
	Texture Tree;
	Array<Rectangle> logs;
	Rectangle gubbe;
	Rectangle pekare;
	Rectangle grass;
	Rectangle wolf;
	Rectangle tree;
	Rectangle road;
	Rectangle house;
		
	int ScreenWIDTH;
	int ScreenHEIGHT;
	MyGdxGame game;
	public Level1 (MyGdxGame game)
	{
		this.game = game;
	}
	
	Gamedata data = new Gamedata();
	Map gamemap = new Map();
	Movement movement = new Movement();
	
	@Override
	public void render(float delta) 
	{
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		int[]map = gamemap.StringToInt();
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<16;j++)
			{
				batch.draw(Grass,j*48,i*48);
			}
		}
		
		// Draw items on map
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<16;j++)
			{
				int mapx = map[i*data.WIDTH+j];
				int v = i*48;
				int c = j*48;
				
				if(mapx == 1)
				{
					batch.draw(Tree,c,v);
				}
				if(mapx==2)
				{
					batch.draw(Road,c,v);
				}
				if(mapx == 3)
				{
					batch.draw(House,c,v);
				}
			}
		}
		
		batch.draw(Gubbe, gubbe.x, gubbe.y);
		
		batch.draw(Wolf, wolf.x, wolf.y);
		
		if(Gdx.input.isTouched())
		{
			Vector3 touchPos = new Vector3();
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touchPos);
			pekare.x = touchPos.x -6;
			pekare.y = touchPos.y -32;
		}
		
		//Movement movement = new movement;
		movement.gx = (int)gubbe.x;
		movement.gy = (int)gubbe.y;
		movement.px = (int)pekare.x;
		movement.py = (int)pekare.y;
		movement.wx = (int)wolf.x;
		movement.wy = (int)wolf.y;
		
		movement.collision();
		
		wolf.x = movement.wx;
		wolf.y = movement.wy;
		gubbe.x = movement.gx;
		gubbe.y = movement.gy;
		pekare.x = movement.px;
		pekare.y = movement.py;
		
		batch.end();
		
		/* Maby for a thing later... */ 
		/* Iterator<Rectangle> iter = logs.iterator();
		while(iter.hasNext())
		{
			Rectangle log = iter.next();
			if(log.overlaps(gubbe))
			{
				iter.remove();
				score +=1;
			}
		}
		*/
	}

	@Override
	public void resize(int width, int height) 
	{
	}
	
	public float data()
	{
		//Texture settings
		house = new Rectangle();
		house.width = 144;
		house.height = 96;
		
		gubbe = new Rectangle();
		gubbe.x = 768 / 2 - 48 / 2;
		gubbe.y = 480 / 2 - 48 / 2;
		gubbe.width = 48;
		gubbe.height = 48;
		
		wolf = new Rectangle();
		wolf.x = 768-48;
		wolf.y = 480/2;
		wolf.width = 48;
		wolf.height = 48;
		
		pekare = new Rectangle();
		pekare.x = gubbe.x;
		pekare.y = gubbe.y;
		pekare.width = 48;
		pekare.height = 48;
		
		grass = new Rectangle();
		grass.width = 48;
		grass.height = 48;
		
		road = new Rectangle();
		road.width = 48;
		road.height = 48;
		
		tree = new Rectangle();
		tree.width = 48;
		tree.height = 48;
		
		logs = new Array<Rectangle>();
		return 0;
	}

	@Override
	public void show() 
	{
		batch = new SpriteBatch();
		Log = new Texture(Gdx.files.internal("data/logs.png"));
		Gubbe = new Texture(Gdx.files.internal("data/gubbe.png"));
		Road = new Texture(Gdx.files.internal("data/road.png"));
		Pekare = new Texture(Gdx.files.internal("pekare.png"));
		Tree  = new Texture(Gdx.files.internal("data/tree.png"));
		House = new Texture(Gdx.files.internal("data/hus.png"));
		Wolf = new Texture(Gdx.files.internal("data/wolfleft.png"));
		
		Grass = new Texture(Gdx.files.internal ("data/grass.png"));
		Grass.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);
		Grass.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		House.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		Gubbe.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		Road.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		Pekare.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		Grass.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		Tree.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		Log.setFilter(TextureFilter.Linear, TextureFilter.Linear);		
		Wolf.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		data();
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 768, 480);
			
		ScreenWIDTH = Gdx.graphics.getWidth();
		ScreenHEIGHT = Gdx.graphics.getHeight();
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

	@Override
	public void dispose() 
	{
		Log.dispose();
		Pekare.dispose();
		batch.dispose();
		Tree.dispose();
		House.dispose();
		Grass.dispose();
		Gubbe.dispose();
	}
}
