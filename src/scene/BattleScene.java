package scene;

import java.util.Scanner;

import game.Game;

public class BattleScene extends MenuScene implements Scene {
	private static final int BATTLE = 0;
	private static final int ITEM = 1;
	private static final int PAUSE_MENU = 2;

	public BattleScene(SceneManager manager) {
		super(manager, "戦闘");
		add("攻撃する", "アイテム", "ポーズメニュー");
	}

	@Override
	public void input(Scanner sc) {
		if (!isWin() && !isGameOver()) {
			super.input(sc);
		}
	}

	@Override
	public void update() {
		if (isWin() && !isGameClear()) {
			System.out.println(currentEnemy.getName() + "を、倒した！！");
			System.out.println("次の敵が現れた！！");
		}
		super.update();
	}

	@Override
	public void render() {
		super.render();
		currentEnemy.render();
		player.render();
	}

	@Override
	public Scene nextScene() {
		if (isGameClear()) {
			return manager.getScene(SceneManager.GAME_CLEAR_SCENE);
		} else if (isGameOver()) {
			return manager.getScene(SceneManager.GAME_OVER_SCENE);
		} else if (isWin()) {
			currentEnemy = manager.getNextEnemy();
			return this;
		} else {
			switch (index) {
			case BATTLE:
				return manager.getScene(SceneManager.ATTACK_SELECT_SCENE);
			case ITEM:
				return manager.getScene(SceneManager.ITEM_SELECT_SCENE);
			case PAUSE_MENU:
				return manager.getScene(SceneManager.PAUSE_MENU_SCENE);
			default:
				System.err.println("入力された値が不正です。正しく値を入力してください。");
				return this;
			}
		}
	}

	private boolean isGameClear() {
		return manager.getEnemyLevel() == manager.MAX_ENEMEY_LEVEL && isWin();
	}

	private boolean isGameOver() {
		return player.isDie();
	}

	private boolean isWin() {
		return currentEnemy.isDie();
	}
}
