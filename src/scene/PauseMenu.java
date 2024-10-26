package scene;

public class PauseMenu extends MenuScene implements Scene {
	private static final int BACK_BATTLE = 0;
	private static final int EXIT_BATTLE = 1;

	public PauseMenu(SceneManager manager) {
		super(manager, "ポーズメニュー");
		add("戦闘に戻る", "ゲームを終了する");
	}

	@Override
	public Scene nextScene() {
		switch (index) {
		case BACK_BATTLE:
			return manager.getScene(SceneManager.BATTLE_SCENE);
		case EXIT_BATTLE:
			return manager.getScene(SceneManager.EXIT_SCENE);
		default:
			System.err.println("入力された値が不正です。正しく値を入力してください。");
			return this;
		}
	}

}
