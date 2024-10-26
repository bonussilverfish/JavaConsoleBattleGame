package entity.item;

import entity.Entity;

public class Item extends Entity {
	private Usable usable;
	private final int MAX_COUNT;
	private int count;

	public Item(String name, int count, Usable usable) {
		super(name);
		this.usable = usable;
		this.MAX_COUNT = count;
		this.count = count;
	}

	@Override
	public void update() {
	}
	
	public boolean isUsable() {
		return count > 0;
	}
	
	public int use() {
		count--;
		return usable.use();
	}
}
