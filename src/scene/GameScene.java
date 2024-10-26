package scene;

import entity.creature.Creature;

public abstract class GameScene implements Scene {
	private String title;
	protected static SceneManager manager;
	protected static Creature player;
	protected static Creature currentEnemy;

	public GameScene(SceneManager sm, String title) {
		this.title = title;
		manager = sm;
		player = manager.getPlayer();
		currentEnemy = manager.getCurrentEnemey();
	}

	@Override
	public void render() {
		System.out.println("==============================");
		System.out.println("◆" + title + "画面です。");
		System.out.println("==============================");
	}

	@Override
	public void update() {
		setCurrentScene(nextScene());
	}

	protected void setCurrentScene(Scene nextScene) {
		manager.setCurrentScene(nextScene);
	}
}
