package scene;

import java.util.Scanner;

public class GameClearScene extends GameScene implements Scene {
	public GameClearScene(SceneManager manager) {
		super(manager, "ゲームクリア");
	}

	@Override
	public void input(Scanner sc) {
	}
	
	@Override
	public void render() {
		super.render();
		System.out.println("おめでとうございます！！");
		System.out.println("あなたはゲームをクリアしました！！");
		System.out.println("世界は平和になった！！");
	}

	@Override
	public Scene nextScene() {
		return manager.getScene(SceneManager.EXIT_SCENE);
	}
}
