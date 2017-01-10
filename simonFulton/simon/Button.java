package simon;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;

import guiPractice.components.Action;
import guiPractice.components.Component;

public class Button extends Component implements ButtonInterfaceFulton {

	private static final int WIDTH = 50;
	private static final int HEIGHT = 50;
	private Color color;
	private final Color DIM = new Color(105, 105, 105);
	public Action action;
	private boolean highlight;
	private Color displayColor;
	
	public Button() {
		super(0, 0, WIDTH, HEIGHT);
	}

	@Override
	public void act() {
		action.act();
	}

	@Override
	public boolean isHovered(int x, int y) {
		return x > getX() && x < getX()+getWidth() && y > getY() && y<getY()+getHeight();
	}

	public void setColor(Color color) {
		this.color = color;
        displayColor = DIM;
        update();
	}
	
	public void setAction(Action a) {
		this.action = a;
		update();
	}

	public void highlight() {
	    displayColor = this.color;
		highlight = true;
		update();
	}

	public void dim() {
		displayColor = DIM;
		highlight = false;
		update();
	}

	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if(displayColor != null){ 
			g.setColor(displayColor);
		}else{
			g.setColor(Color.gray);
		}
		g.fillOval(0, 0, WIDTH, HEIGHT);
		g.setColor(Color.black);
		g.drawOval(0, 0, WIDTH-1, HEIGHT-1);
		if(highlight){
			g.setColor(Color.white);
			Polygon p = new Polygon();
		}
	}

}
