package scene;

import java.util.Scanner;

public class ExitScene extends GameScene implements Scene {
	public ExitScene(SceneManager manager) {
		super(manager, "終了");
	}

	@Override
	public void input(Scanner sc) {
	}

	@Override
	public void update() {
		manager.exit();
	}

	@Override
	public Scene nextScene() {
		return null;
	}

}
