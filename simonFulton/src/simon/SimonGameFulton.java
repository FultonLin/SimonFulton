package simon;

import guiPractice.GUIApplication;

public class SimonGameFulton extends GUIApplication {

	public SimonGameFulton() {
		
	}

	@Override
	protected void initScreen() {
		SimonScreenFulton ssf = new SimonScreenFulton(getWidth(), getHeight());
		setScreen(ssf);
	}

	public static void main(String[] args) {
		SimonGameFulton game = new SimonGameFulton();
		Thread app = new Thread(game);
		app.start();
	}
}
