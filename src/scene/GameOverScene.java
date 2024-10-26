package scene;

import java.util.Scanner;

public class GameOverScene extends GameScene implements Scene {
	public GameOverScene(SceneManager manager) {
		super(manager, "ゲームオーバ");
	}

	@Override
	public void input(Scanner sc) {
	}
	
	@Override
	public void render() {
		super.render();
		System.out.println("残念...、" + player.getName() + "は戦いに負けてしまった...");
	}

	@Override
	public Scene nextScene() {
		return manager.getScene(SceneManager.EXIT_SCENE);
	}
}
