package com.me.mygdxgame;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;


public class Main
{
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Hunter/Gatherer";
		cfg.useGL20 = true;
		cfg.width = 768;
		cfg.height = 480;
		
		new LwjglApplication(new MyGdxGame(), cfg);
	}
}
