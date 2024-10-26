package game;

import java.util.Scanner;

import scene.ExitScene;
import scene.Scene;
import scene.SceneManager;
import scene.StartMenuScene;

public class Game implements Runnable {
	private boolean running;
	private SceneManager manager;
	private Scanner sc;

	public Game() {
		System.out.println("ゲームを開始します。");
		this.running = true;
		this.sc = new Scanner(System.in);
		this.manager = new SceneManager(this);
		System.out.println("初期設定が完了しました。");
	}

	@Override
	public void run() {
		while (running) {
			render();
			input();
			update();
		}
		System.out.println("ゲームを終了します。");
		System.exit(0);
	}

	private void input() {
		manager.input(sc);
	}

	private void update() {
		manager.update();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void render() {
		manager.render();
	}
	
	public void exit() {
		running = false;
	}
}
