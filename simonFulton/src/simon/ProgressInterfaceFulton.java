package simon;

import guiPractice.components.Visible;

public interface ProgressInterfaceFulton extends Visible {
	static void setRound(int roundNumber) {
	}

	static void setSequenceSize(int size) {
	}
	
	public int getRoundNumber();

	void gameOver();
}
