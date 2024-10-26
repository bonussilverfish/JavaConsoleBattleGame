package scene;

import java.util.Scanner;

public interface Scene {
	void input(Scanner sc);
	void render();
	void update();
	Scene nextScene();
}
