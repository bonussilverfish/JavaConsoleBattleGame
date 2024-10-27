package scene;

import entity.creature.skill.Skill;
import game.Game;

public class AttackSelectScene extends MenuScene implements Scene {
	private static final int NUMBER_OF_SKILLS = 3;
	private static final int HIT = 0;
	private static final int DOUBLE_KICK = 1;
	private static final int SUPER_ATTACK = 2;
	private static final int BACK = 3;

	private Skill[] skills;

	public AttackSelectScene(SceneManager manager) {
		super(manager, "攻撃選択");
		this.skills = new Skill[NUMBER_OF_SKILLS];
		registerSkills();
		for (var i = 0; i < skills.length; i++) {
			add(skills[i].getName());
		}
		add("戻る");
	}

	private void registerSkills() {
		skills[HIT] = new Skill("殴る", Integer.MAX_VALUE, () -> 20);
		skills[DOUBLE_KICK] = new Skill("連続蹴り", 10, () -> 35);
		skills[SUPER_ATTACK] = new Skill("最終奥義", 1, () -> 50);
	}

	@Override
	public void update() {
		if (index == BACK) {
			System.out.println("戦闘画面に戻ります。");
		} else if (index < 0 || index >= skills.length) {
			System.err.println("入力された値が不正です。正しく値を入力してください。");
		} else if (skills[index].isUsable()) {
			switch (index) {
			case HIT:
			case DOUBLE_KICK:
			case SUPER_ATTACK:
				var invokeValue = skills[index].invoke();
				System.out.println(currentEnemy.getName() + "に【" + invokeValue + "】のダメージ！！");
				currentEnemy.effect(invokeValue);
				break;
			}
			if (currentEnemy.isDie()) {
				index = BACK;
			}
		} else {
			index = UNKNOWN_COMMAND;
			System.err.println("その技はもう使えない！！");
		}
		super.update();
	}

	@Override
	public Scene nextScene() {
		switch (index) {
		case HIT:
		case DOUBLE_KICK:
		case SUPER_ATTACK:
			return manager.getScene(SceneManager.ENEMY_ATTACK_SCENE);
		case BACK:
			return manager.getScene(SceneManager.BATTLE_SCENE);
		default:
			return this;
		}
	}
}
