/* Handles the map positions. */

package com.me.mygdxgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

public class Map
{
	Gamedata data = new Gamedata();
	int []mapvar = new int[data.HEIGHT*data.WIDTH];
	private String fileContent;
	public static String level;
	
	public void Levels()
	{
		if(Gamedata.CurrentLevel == 2)
		{
			level = "data/texturemap2";
		}
		if(Gamedata.CurrentLevel == 3)
		{
			level = "data/texturemap3";
		}
		if(Gamedata.CurrentLevel == 4)
		{
			level = "data/texturemap4";
		}
		if(Gamedata.CurrentLevel == 5)
		{
			level = "data/texturemap5";
		}
	}
	
	public int[] StringToInt()
	{
		Levels();
		
		FileHandle handle = Gdx.files.internal(level);
		fileContent = handle.readString();
		String[] MString = fileContent.split("");
		int a = data.HEIGHT-1;
		int b = 0;
		int var = 0;
		for(int y=1;y<=data.HEIGHT;y++)
		{
			b=0;
			for(int x=1;x<=data.WIDTH;x++)
			{
				mapvar[var] = Integer.valueOf(MString[(a*data.WIDTH+b)+1]);
				b++;
				var++;
			}
			a--;
		}
		return mapvar;
	}
}
