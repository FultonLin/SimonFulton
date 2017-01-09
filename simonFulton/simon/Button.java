package simon;

import java.awt.Color;
import java.awt.Graphics2D;

import guiPractice.components.Action;
import guiPractice.components.Component;

public class Button extends Component implements ButtonInterfaceFulton {

	private Color color;
	private final Color DIM = new Color(105, 105, 105);
	public Action action;
	
	public Button(int x, int y, int w, int h) {
		super(x, y, w, h);
	}

	@Override
	public void act() {
		action.act();
	}

	@Override
	public boolean isHovered(int x, int y) {
		if(inBetween(x, getX(), getX() + getWidth()) && inBetween(y, getY(), getY() + getHeight()))
			return true;
		else 
			return false;
	}
	
	public boolean inBetween(int x, int y, int z){
		if(x > y && x < z)
			return true;
		else 
			return false;
	}

	@Override
	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public void setAction(Action a) {
		this.action = a;
	}

	@Override
	public void highlight() {
		this.color = color;
		update();
	}

	@Override
	public void dim() {
		this.color = DIM;
		update();
	}

	@Override
	public void update(Graphics2D g) {
		g.setColor(this.color);
		g.drawOval(getX(), getY(), getWidth(), getHeight());
		g.fillOval(getX(), getY(), getWidth(), getHeight());
	}

}
