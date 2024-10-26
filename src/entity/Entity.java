package entity;

public abstract class Entity {
	private String name;
	
	public Entity(String name) {
		this.name = name;
	}
	
	public void render() {
		System.out.println("名前: " + name);
	}
	
	public abstract void update();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
