package entity.creature.skill;

public class Skill {
	private String name;
	private final int MAX_COUNT;
	private int count;
	private Invokable invokable;

	public Skill(String name, int count, Invokable invokable) {
		this.name = name;
		this.count = count;
		this.MAX_COUNT = count;
		this.invokable = invokable;
	}
	
	public int invoke() {
		count--;
		return invokable.invoke();
	}

	public boolean isUsable() {
		return count > 0;
	}

	public String getName() {
		return name;
	}

	public int getCount() {
		return count;
	}
	
	public int getMaxCount() {
		return MAX_COUNT;
	}
}
