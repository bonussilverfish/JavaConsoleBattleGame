package core;

import game.Game;

public class GameLauncher {
	private GameLauncher() {
		Thread gameThread = new Thread(new Game());
		gameThread.start();
	}
	
	public static void main(String[] args) {
		new GameLauncher();
	}
}
