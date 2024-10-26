package entity.creature;

import entity.Entity;

public class Creature extends Entity {
	private final int MAX_HP;
	private int hp;
	private int offence;
	
	public Creature(String name, int hp) {
		this(name, hp, 0);
	}

	public Creature(String name, int hp, int offence) {
		super(name);
		this.MAX_HP = hp;
		this.hp = hp;
		this.offence = offence;
	}

	@Override
	public void update() {
	}

	@Override
	public void render() {
		super.render();
		System.out.println("HP: " + hp);
		var ratio = (int) ((double) hp / MAX_HP * 10);
		for (var i = 0; i < ratio; i++) {
			System.out.print("||");
		}
		for (var i = 0; i < 10 - ratio; i++) {
			System.out.print("..");
		}
		System.out.println();
	}

	public void effect(int value) {
		if (hp - value >= MAX_HP) {
			hp = MAX_HP;
		} else {
			hp -= value;
		}
	}

	public int getOffence() {
		return offence;
	}

	public boolean isDie() {
		return hp <= 0;
	}
}
