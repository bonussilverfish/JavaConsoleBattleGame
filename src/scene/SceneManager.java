package scene;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entity.creature.Creature;
import game.Game;

public class SceneManager {
	public static final int START_MENU_SCENE = 0;
	public static final int BATTLE_SCENE = 1;
	public static final int ATTACK_SELECT_SCENE = 2;
	public static final int ITEM_SELECT_SCENE = 3;
	public static final int ENEMY_ATTACK_SCENE = 4;
	public static final int GAME_CLEAR_SCENE = 5;
	public static final int GAME_OVER_SCENE = 6;
	public static final int EXIT_SCENE = 7;
	public static final int PAUSE_MENU_SCENE = 8;
	public static final int NAME_INPUT_SCENE = 9;
	public static final int NEXT_ENEMY_ECENE = 10;
	
	public final int MAX_ENEMEY_LEVEL;
	
	private Game game;
	private List<Scene> scenes;
	private List<Creature> enemyList;
	private Creature player;
	private int enemyLevel;
	private Scene currentScene;
	
	public SceneManager(Game game) {
		this.game = game;
		this.scenes = new ArrayList<>();
		this.enemyList = new ArrayList<>();
		this.player = new Creature("プレイヤー1", 120);
		addEnemies();
		addScenes();
		this.MAX_ENEMEY_LEVEL = enemyList.size() - 1;
		this.enemyLevel = 0;
		this.currentScene = scenes.get(START_MENU_SCENE);
	}
	
	public void update( ) {
		currentScene.update();
	}
	
	public void render() {
		currentScene.render();
	}
	
	public void input(Scanner sc) {
		currentScene.input(sc);
	}
	
	public Creature getCurrentEnemey() {
		return enemyList.get(enemyLevel);
	}
	
	public Creature getNextEnemy() {
		enemyLevel++;
		return enemyList.get(enemyLevel);
	}
	
	private void addEnemies() {
		enemyList.add(new Creature("【Lv 1】スモークミュータント", 50, 15));
		enemyList.add(new Creature("【Lv 2】ミミックゾンビ", 60, 25));
		enemyList.add(new Creature("【Lv 3】ファイアースケルトン", 70, 30));
		enemyList.add(new Creature("【ボス】ゴールデンマザー", 80, 35));
	}

	private void addScenes() {
		scenes.add(new StartMenuScene(this));
		scenes.add(new BattleScene(this));
		scenes.add(new AttackSelectScene(this));
		scenes.add(new ItemSelectScene(this));
		scenes.add(new EnemyAttackScene(this));
		scenes.add(new GameClearScene(this));
		scenes.add(new GameOverScene(this));
		scenes.add(new ExitScene(this));
		scenes.add(new PauseMenuScene(this));
		scenes.add(new NameInputScene(this));
		scenes.add(new NextEnemyScene(this));
	}
	
	public Scene getScene(int index) {
		return scenes.get(index);
	}

	public Creature getPlayer() {
		return player;
	}

	public int getEnemyLevel() {
		return enemyLevel;
	}

	public void setCurrentScene(Scene currentScene) {
		this.currentScene = currentScene;
	}

	public void exit() {
		if (currentScene instanceof ExitScene) {
			game.exit();
		} else {
			throw new IllegalStateException(
					"不正な状態でのゲーム終了命令が発せられました。" + System.lineSeparator() + "ゲームを正常に終了させるには、現在の状態を終了シーンに移行させる必要があります。");
		}
	}
}
