package simon;

public class Move implements MoveInterfaceFulton {
	
	private ButtonInterfaceFulton button;

	public Move(ButtonInterfaceFulton b) {
		this.button = b;
	}

	@Override
	public ButtonInterfaceFulton getButton() {
		return button;
	}

}
