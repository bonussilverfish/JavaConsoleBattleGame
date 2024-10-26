package scene;

import java.util.Scanner;

public class NameInputScene extends GameScene implements Scene {
	public NameInputScene(SceneManager manager) {
		super(manager, "名前入力");
	}

	@Override
	public void input(Scanner sc) {
		System.out.println("あなたの名前を入力してください。");
		System.out.print(">>>>:");
		var name = sc.nextLine();
		player.setName(name);
	}

	@Override
	public Scene nextScene() {
		return manager.getScene(SceneManager.BATTLE_SCENE);
	}

}
