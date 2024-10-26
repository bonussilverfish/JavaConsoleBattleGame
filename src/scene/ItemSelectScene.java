package scene;

import java.util.ArrayList;
import java.util.List;

import entity.item.Item;

public class ItemSelectScene extends MenuScene implements Scene {
	private static final int MEDICAL_PLANTS = 0;
	private static final int GOOD_MEDICAL_PLANTS = 1;
	private static final int BOMB = 2;
	private static final int STONE = 3;
	private static final int BACK = 4;

	private List<Item> items;

	public ItemSelectScene(SceneManager manager) {
		super(manager, "アイテム選択");
		this.items = new ArrayList<>();
		registerItems();
		items.stream().forEach(e -> add(e.getName()));
		add("戻る");
	}

	private void registerItems() {
		items.add(new Item("薬草", 5, () -> 30));
		items.add(new Item("いい薬草", 2, () -> 100));
		items.add(new Item("爆弾", 3, () -> 10));
		items.add(new Item("石ころ", 5, () -> 8));
	}

	@Override
	public void update() {
		var useResult = 0;
		if (index == BACK) {
			System.out.println("戦闘画面に戻ります。");
		} else if (index < 0 && index >= items.size()) {
			System.err.println("入力された値が不正です。正しく値を入力してください。");
		} else if (items.get(index).isUsable()) {
			switch (index) {
			case MEDICAL_PLANTS:
			case GOOD_MEDICAL_PLANTS:
				useResult = items.get(index).use();
				System.out.println(player.getName() + "は、" + items.get(index).getName() + "を使った！！");
				player.effect(-1 * useResult);
				System.out.println(player.getName() + "のHPが、【" + useResult + "】回復した。");
				break;
			case BOMB:
			case STONE:
				useResult = items.get(index).use();
				System.out.println(player.getName() + "は、" + items.get(index).getName() + "を使った！！");
				currentEnemy.effect(useResult);
				System.out.println(currentEnemy.getName() + "に、【" + useResult + "】のダメージ！！");
				break;
			}
		} else {
			index = UNKNOWN_COMMAND;
			System.err.println("そのアイテムはもう使えない！！");
		}
		super.update();
	}

	@Override
	public Scene nextScene() {
		switch (index) {
		case MEDICAL_PLANTS:
		case GOOD_MEDICAL_PLANTS:
		case BOMB:
		case STONE:
			return manager.getScene(SceneManager.ENEMY_ATTACK_SCENE);
		case BACK:
			return manager.getScene(SceneManager.BATTLE_SCENE);
		default:
			return this;
		}
	}
}
