package scene;

public class StartMenuScene extends MenuScene implements Scene {
	public static final int START = 0;
	public static final int EXIT = 1;

	public StartMenuScene(SceneManager manager) {
		super(manager, "開始メニュー");
		add("ゲーム開始", "ゲーム終了");
	}

	@Override
	public Scene nextScene() {
		switch (index) {
		case START:
			return manager.getScene(SceneManager.NAME_INPUT_SCENE);
		case EXIT:
			return manager.getScene(SceneManager.EXIT_SCENE);
		default:
			System.err.println("正しく次のシーンに遷移することができませんでした。");
			return this;
		}
	}

}
