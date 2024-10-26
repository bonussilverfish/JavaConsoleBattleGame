package scene;

import java.util.Random;
import java.util.Scanner;

import game.Game;

public class EnemyAttackScene extends MenuScene implements Scene {
	private static final int DAMAGE_PROBABILITY = 70;
	private static final int CRITICAL_DAMAGE_PROBABILITY = 10;

	private Random random;

	public EnemyAttackScene(SceneManager manager) {
		super(manager, "敵の攻撃");
		this.random = new Random();
	}

	@Override
	public void input(Scanner sc) {
	}

	@Override
	public void update() {
		var hitRatio = random.nextInt(0, 101);
		if (hitRatio < DAMAGE_PROBABILITY) {
			var damage = random.nextInt(0, currentEnemy.getOffence());
			var criticalRatio = random.nextInt(0, 101);
			if (criticalRatio < CRITICAL_DAMAGE_PROBABILITY) {
				System.out.println(">>>>>急所にあたった！！<<<<<");
				damage *= 2;
			}
			player.effect(damage);
			System.out.println(player.getName() + "は、【" + damage + "】のダメージを受けた！！");
		} else {
			System.out.println(player.getName() + "は、敵の攻撃を避けた！！");
		}
		super.update();
	}

	@Override
	public Scene nextScene() {
		return manager.getScene(SceneManager.BATTLE_SCENE);
	}
}
