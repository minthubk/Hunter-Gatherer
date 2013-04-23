package com.me.mygdxgame;

public class Movement
{
	private int xvel;
	private int yvel;
	public int gx;
	public int gy;
	public int px;
	public int py;
	public int wx;
	public int wy;
	public int sx;
	public int sy;
	public int stonex;
	public int stoney;
	
	Gamedata data = new Gamedata();
	Map gamemap = new Map();
	
	public void collision()
	{
		/* Collision detection goes here */
		int[]map = gamemap.StringToInt();
		
		//gameover
		if((sx+48)>wx)
		{
			//setScreen(gameover);
		}
		
		if (map[(gy/48)*data.WIDTH+((gx+48)/48)] == 5)
		{
			System.out.println("Change map...");
			
			Gamedata.CurrentLevel+=1;
			
			if (Gamedata.CurrentLevel == 3)
			{
				sx = 450;
				wx = 600;
				wy = 240+150;
				sy = 240+150;
				stonex = 527;
			}
			if(Gamedata.CurrentLevel > 3)
			{
				sx = 1000;
				wx = 1000;
				stonex = 1000;
			}
			//Map.level = "data/texturemap3";
			gx = 50;
		}
		
		if((gx+48) >= stonex && gx <= (stonex+48))
		{
			if((gy+48)>stoney)
				stoney++;
			if(stoney==240+90)
			{
				sx=1000;
			}
		}
		
		if (map[(gy/48)*data.WIDTH+((gx)/48)] == 4)
		{
			System.out.println("Change map...");
			Gamedata.CurrentLevel-=1;
			gx = 768-(48*2)-5;
			
			if (Gamedata.CurrentLevel == 3)
			{
				wx = 600;
				stonex = 527;
				//sx= 450;
			}
			if (Gamedata.CurrentLevel == 2)
			{
				stonex= 1000;
				wx = 1000;
				sx = 1000;
			}
			//Map.level = "data/texturemap3";
		}
		
		xvel=0;
		yvel=0;
	 
		if ((gx+96) >= sx && (gy+48) >= sy)
		{
			// (TODO)
			// game.setScreen(game.level2);
			sx++;
		}
		
		/* Walking to the right. */
		if(gx < px)
		{
		    xvel = 1;
		    /* Non-walkable tiles. */
		    if ((map[(gy/48)*data.WIDTH+((gx+48)/48)] != 0) ||
			    (map[((gy+48)/48)*data.WIDTH+((gx+48)/48)] != 0))
		    {
			    xvel = 0;
			    gx -= 1;
		    }
		}
		/* Walking to the left. */
		if(gx > px)
		{
		    xvel = (-1);
		    /* Non-walkable tiles. */
			if ((map[(gy/48)*data.WIDTH+(gx/48)] != 0) ||
			    (map[((gy+48)/48)*data.WIDTH+(gx/48)] != 0))
			{
			    xvel = 0;
			    gx += 1;
			}
		}
		/* Walking upwards. */
		if(gy < py)
		{
		    yvel = 1;
		    /* Non-walkable tiles. */
			if ((map[((gy+48)/48)*data.WIDTH+(gx/48)] != 0) ||
			    (map[((gy+48)/48)*data.WIDTH+((gx+48)/48)] != 0))
			{
			    yvel = 0;
			    gy -= 1;
			}
		}
		/* Walking downwards. */
		if(gy > py)
		{
		    yvel = (-1);
		    /* Non-walkable tiles. */
		    if ((map[(gy/48)*data.WIDTH+(gx/48)] != 0) ||
		        (map[(gy/48)*data.WIDTH+((gx+48)/48)] != 0))
		    {
			    yvel = 0;
			    gy += 1;
		    }
		}
		gx=gx+xvel;
		gy=gy+yvel;
	}
}
