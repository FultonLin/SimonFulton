package simon;

import guiPractice.GUIApplication;

public class SimonGameFulton extends GUIApplication {

	public SimonGameFulton() {
		SimonGameFulton game = new SimonGameFulton();
		Thread app = new Thread(game);
		app.start();
	}

	@Override
	protected void initScreen() {
		SimonScreenFulton ssf = new SimonScreenFulton(getWidth(), getHeight());
		setScreen(ssf);
	}

}
