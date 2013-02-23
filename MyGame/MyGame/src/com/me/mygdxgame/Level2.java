/* Just saved as backup if i mess up :) */

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


public class Level2 implements Screen {

	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Texture Log;
	private Texture Gubbe;
	private Texture House;
	private Texture Pekare;
	private Texture Grass;
	private Texture Road;
	private Texture Tree;
	private Array<Rectangle> logs;
	private Rectangle gubbe;
	private Rectangle pekare;
	private Rectangle grass;
	private Rectangle tree;
	private Rectangle road;
	private Rectangle house;
	
	public static int WIDTH;
	public static int HEIGHT;
	
	long lastLogSpawn;
	
	int xvel = 2;
	int yvel = 2;
	
	private MyGdxGame game;
	public Level2 (MyGdxGame game)
	{
		this.game = game;		
	}
	
	Level1 gameScreen = new Level1(game);
	//Map - old map system
	int[][] map = new int[][] {	{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
								{1,0,0,0,0,0,0,0,0,1,0,1,0,1,1,1},
								{1,0,0,0,0,0,0,0,0,0,1,0,1,1,1,1},
								{1,0,3,5,5,0,1,0,0,1,0,1,1,0,1,1},
								{1,0,5,5,5,0,0,0,0,1,1,1,0,0,0,1},
								{1,0,1,1,0,0,0,0,0,1,1,1,0,0,0,1},
								{4,0,0,0,1,0,1,0,0,1,1,1,0,0,1,1},
								{4,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},
								{1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},
								{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};

								// 0 = grass
								// 1 = tree
								// 2 = road
								// 3 = house
								// 4 = change map
								// 5 = null
	
	@Override
	public void render(float delta) 
	{
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		camera.update();
		
		batch.setProjectionMatrix(camera.combined);
		
		batch.begin();

		//Some texture drawing
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<16;j++)
			{
				batch.draw(Grass,j*48,i*48);
			}
		}
		
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<16;j++)
			{
				int mapx = map[i][j];
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
		
		for(Rectangle log: logs)
		{
			batch.draw(Log, log.x, log.y);
		}
		
		batch.draw(Gubbe, gubbe.x, gubbe.y);

		//Touch-Input
		if(Gdx.input.isTouched())
		{
			Vector3 touchPos = new Vector3();
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touchPos);
			pekare.x = touchPos.x -6;
			pekare.y = touchPos.y -32;
		}
		
		Movement();
		
		batch.end();
	}
	
	private void Movement()
	{
		int x = (int)gubbe.x;
		int y = (int)gubbe.y;
	
		if (map[y/48][x/48] == 4)
		{
			game.setScreen(gameScreen);
		}
	
		xvel = 0;
		yvel = 0;

		/* Walking to the right. */
		if ((gubbe.x < (int)pekare.x) &&
			((map[y/48][(x+48)/48] == 0) ||
			 (map[(y+48)/48][(x+48)/48] == 0)) ||
			((map[y/48][x/48] == 0) ||
			 (map[(y+48)/48][x/48] == 0)))
	 	{
			xvel = 1;
		
			/* Non-walkable tiles. */
			if ((map[y/48][(x+48)/48] != 0) ||
				(map[(y+48)/48][(x+48)/48] != 0))
			{
				xvel = 0;
				x-=2;
			}
		}
	
		/* Walking to the left. */
		if ((gubbe.x > (int)pekare.x ) &&
		    (((map[(y+48)/48][x/48] == 0) ||
		      (map[y/48][x/48] == 0)) ||
	         ((map[(y+48)/48][(x+48)/48] == 0) ||
		      (map[y/48][(x+48)/48] == 0))))
		{
			xvel = -1;
		
			/* Non-walkable tiles. */
			if ((map[y/48][x/48] != 0) ||
				(map[(y+48)/48][x/48] != 0))
			{
				xvel = 0;
				x+=2;
			}
		}
	
		/* Walking upwards. */
		if ((gubbe.y < (int)pekare.y ) &&
              (((map[(y+48)/48][x/48] == 0) ||
	            (map[(y+48)/48][(x+48)/48] == 0)) ||
	           ((map[(y)/48][(x+48)/48] == 0) ||
	            (map[(y)/48][(x/48)] == 0))))
		{
			yvel = 1;
		
			/* Non-walkable tiles. */
			if ((map[(y+48)/48][x/48] != 0) || 
				(map[(y+48)/48][(x+48)/48] != 0))
			{
				yvel = 0;
				y-=2;
			}
		}
	
		/* Walking downwards. */
		if( (gubbe.y > (int)pekare.y) &&
			(((map[y/48][x/48] == 0) || 
			  (map[y/48][(x+48)/48] == 0)) || 
			 ((map[(y+48)/48][x/48] == 0) || 
			  (map[(y+48)/48][(x+48)/48] == 0)))) {
			yvel = -1;
		
			/* Non-walkable tiles. */
			if ((map[y/48][x/48] != 0) ||
				(map[y/48][(x+48)/48] != 0))
			{
				yvel=0;
				y+=2;
			}
		}
	
		gubbe.x += xvel;
		gubbe.y += yvel;
	}

	@Override
	public void resize(int width, int height) 
	{
	}

	@Override
	public void show() 
	{
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 768, 480);
			
		WIDTH = Gdx.graphics.getWidth();
		HEIGHT = Gdx.graphics.getHeight();
		
		batch = new SpriteBatch();
		Log = new Texture(Gdx.files.internal("data/logs.png"));
		Gubbe = new Texture(Gdx.files.internal("data/gubbe.png"));
		Road = new Texture(Gdx.files.internal("data/road.png"));
		Pekare = new Texture(Gdx.files.internal("pekare.png"));
		Tree  = new Texture(Gdx.files.internal("data/tree.png"));
		House = new Texture(Gdx.files.internal("data/hus.png"));

		this.Grass = new Texture(Gdx.files.internal ("data/grass.png"));
		this.Grass.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);
		this.Grass.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		House.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		Gubbe.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		Road.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		Pekare.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		Grass.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		Tree.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		Log.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		/*Texture settings*/
		
		house = new Rectangle();
		house.width = 144;
		house.height = 96;
		
		gubbe = new Rectangle();
		gubbe.x = 768 / 2 - 48 / 2;
		gubbe.y = 480 / 2 - 48 / 2;
		gubbe.width = 48;
		gubbe.height = 48;
		
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
