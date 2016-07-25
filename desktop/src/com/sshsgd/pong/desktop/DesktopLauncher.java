package com.sshsgd.pong.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.sshsgd.pong.Game;
import com.sshsgd.pong.MyConstants;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = MyConstants.WORLD_WIDTH;
		config.height = MyConstants.WORLD_HEIGHT;
        config.foregroundFPS = 0;
        config.vSyncEnabled = false;
		new LwjglApplication(new Game(), config);
	}
}
