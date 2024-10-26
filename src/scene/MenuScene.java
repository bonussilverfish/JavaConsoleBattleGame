package scene;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class MenuScene extends GameScene implements Scene {
	protected static final int UNKNOWN_COMMAND = 99;
	
	private List<String> menuList;
	protected int index;
	
	public MenuScene(SceneManager manager, String title) {
		super(manager, title);
		this.menuList = new ArrayList<>();
	}


	protected void add(String... menus) {
		for (var menu : menus) {
			menuList.add(menu);
		}
	}

	@Override
	public void input(Scanner sc) {
		System.out.println("選択するには指定された数値を入力してください。");
		System.out.print(">>");
		try {
			index = sc.nextInt();
		} catch (RuntimeException e) {
			System.err.println("入力された値が不正です。正しく値を入力してください。");
			index = UNKNOWN_COMMAND;
		} catch (Error e) {
			System.err.println("実行中に致命的なシステムエラーが発生しました。");
			setCurrentScene(manager.getScene(SceneManager.EXIT_SCENE));
		} finally {
			sc.nextLine();
		}
	}

	@Override
	public void update() {
		player.update();
		currentEnemy.update();
		super.update();
	}

	@Override
	public void render() {
		super.render();
		for (var i = 0; i < menuList.size(); i++) {
			System.out.println(i + ": " + menuList.get(i));
		}
	}
}
