package simon;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import guiPractice.components.Component;

public class Progress extends Component implements ProgressInterfaceFulton {

	private String text;
	private int round;
	private int sequenceSize;
	
	public Progress(int x, int y, int w, int h) {
		super(x, y, w, h);
	}

	@Override
	public void gameOver() {
		text = "Game Over!";
	}

	@Override
	public void update(Graphics2D g) {
		g = clear(); //clears image and gets new graphics
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.black);
		text = "Round " + round + "\nSequence Size: " + sequenceSize;
		g.setFont(new Font("Consolas", Font.PLAIN, 12));
		if (text != null) {
			g.drawString(text, 4, getHeight()-5);			
		}
	}
	
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public void setRound(int roundNumber) {
		this.round = roundNumber;
	}

	@Override
	public void setSequenceSize(int size) {
		this.sequenceSize = size;
	}

}
