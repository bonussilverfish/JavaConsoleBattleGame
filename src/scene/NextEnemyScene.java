package scene;

import java.util.Scanner;

public class NextEnemyScene extends GameScene implements Scene {

	public NextEnemyScene(SceneManager manager) {
		super(manager, "");
	}

	@Override
	public void input(Scanner sc) {
	}

	@Override
	public void update() {
		currentEnemy = manager.getNextEnemy();
		super.update();
	}

	@Override
	public void render() {
		System.out.println("==============================");
		System.out.println("次の敵が現れた！！");
		System.out.println("==============================");
	}

	@Override
	public Scene nextScene() {
		return manager.getScene(SceneManager.BATTLE_SCENE);
	}

}
