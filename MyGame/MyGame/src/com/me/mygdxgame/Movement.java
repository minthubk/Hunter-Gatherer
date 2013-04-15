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

	Gamedata data = new Gamedata();
	Map gamemap = new Map();
	
	public void collision()
	{
		/* Collision detection goes here */
		int[]map = gamemap.StringToInt();
		
		if (map[(gy/48)*data.WIDTH+((gx+48)/48)] == 5)
		{
			System.out.println("Change map...");
			
			Gamedata.CurrentLevel=3;
			gx = 50;
			sx = 500;
			wx = 600;
			wy = wy+120;
			sy = sy+120;
			//Map.level = "data/texturemap3";
		}
		if (map[(gy/48)*data.WIDTH+((gx)/48)] == 4)
		{
			System.out.println("Change map...");
			Gamedata.CurrentLevel=2;
			gx = 768-(48*2)-5;
			wx = 900;
			//Map.level = "data/texturemap3";
		}
		
		xvel=0;
		yvel=0;
	 
		if ((gx+96) >= sx)
		{
			// (TODO)
			// game.setScreen(game.level2);
			sx++;
		}
		
		/* Walking to the right. */
		if ((gx < px) &&
			((map[(gy/48)*data.WIDTH+((gx+48)/48)] == 0) ||
			 (map[((gy+48)/48)*data.WIDTH+((gx+48)/48)] == 0)) ||
			((map[(gy/48)*data.WIDTH+(gx/48)] == 0) ||
			 (map[((gy+48)/48)*data.WIDTH+(gx/48)] == 0)))
		{
		    xvel=1;
			
		    /* Non-walkable tiles. */
		    if ((map[(gy/48)*data.WIDTH+((gx+48)/48)] != 0) ||
			    (map[((gy+48)/48)*data.WIDTH+((gx+48)/48)] != 0))
		    {
			    xvel=0;
			    gx-=1;
		    }
		   }
		/* Walking to the left. */
		if ((gx > px ) &&
		    (((map[(gy+48)/48*data.WIDTH+(gx/48)] == 0) ||
		      (map[(gy/48)*data.WIDTH+(gx/48)] == 0)) ||
		     ((map[(gy+48)/48*data.WIDTH+(gx+48)/48] == 0) ||
		      (map[(gy/48)*data.WIDTH+((gx+48)/48)] == 0))))
		{
		    xvel=-1;
		
		    /* Non-walkable tiles. */
			if ((map[(gy/48)*data.WIDTH+(gx/48)] != 0) ||
			    (map[((gy+48)/48)*data.WIDTH+(gx/48)] != 0))
			{
			    xvel=0;
			    gx+=1;
			}
		}
		
		/* Walking upwards. */
		if ((gy < py ) &&
	         (((map[((gy+48)/48)*data.WIDTH+(gx/48)] == 0) ||
		       (map[((gy+48)/48)*data.WIDTH+((gx+48)/48)] == 0)) ||
		      ((map[((gy)/48)*data.WIDTH+((gx+48)/48)] == 0) ||
		       (map[((gy)/48)*data.WIDTH+((gx/48))] == 0))))
		{
		    yvel=1;
			
		    /* Non-walkable tiles. */
			if ((map[((gy+48)/48)*data.WIDTH+(gx/48)] != 0) || 
			    (map[((gy+48)/48)*data.WIDTH+((gx+48)/48)] != 0))
			{
			    yvel=0;
			    gy-=1;
			}
		}
		
		/* Walking downwards. */
		if( (gy > py) &&
		  (((map[(gy/48)*data.WIDTH+(gx/48)] == 0) || 
			(map[(gy/48)*data.WIDTH+((gx+48)/48)] == 0)) || 
		   ((map[((gy+48)/48)*data.WIDTH+(gx/48)] == 0) || 
			(map[((gy+48)/48)*data.WIDTH+((gx+48)/48)] == 0)))) 
		{
		    yvel=-1;
			
		    /* Non-walkable tiles. */
		    if ((map[(gy/48)*data.WIDTH+(gx/48)] != 0) ||
		        (map[(gy/48)*data.WIDTH+((gx+48)/48)] != 0))
		    {
			    yvel=0;
			    gy+=1;
		    }
		}
				
		gx+=xvel;
		gy+=yvel;
	}
}
