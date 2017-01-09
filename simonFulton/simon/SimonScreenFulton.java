package simon;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiPractice.components.Action;
import guiPractice.components.Button;
import guiPractice.components.ClickableScreen;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;

public class SimonScreenFulton extends ClickableScreen implements Runnable {
	
	private TextLabel label;
	private ButtonInterfaceFulton[] button;
	private ArrayList<MoveInterfaceFulton> sequence; 
	private ProgressInterfaceFulton progress;
	private int roundNumber;
	private boolean acceptingInput;
	private int sequenceIndex;
	private int lastSelectedButton;

	public SimonScreenFulton(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	@Override
	public void run() {
		label.setText("");
		nextRound();
	}

	private void nextRound() {
		acceptingInput = false;
		roundNumber += 1;
		progress.setRound(roundNumber);
		progress.setSequenceSize(sequence.size());
		changeText("Simon's turn");
		label.setText("");
		playSequence();
	}

	private void playSequence() {
		ButtonInterfaceFulton b = null;
		for(MoveInterfaceFulton m: sequence){
			if(b != null){
				b.dim();
			}
			b = m.getButton();
			b.highlight();
			try{
				Thread.sleep((long)(2000*(2.0/(roundNumber+2))));
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			b.dim();
		}
	}

	private void changeText(String s) {
		try{
			//better this way for simon game
			label.setText(s);
			Thread.sleep(1000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

	public void initAllObjects(ArrayList<Visible> viewObjects) {
		addButtons(viewObjects);
		progress = getProgress();
		label = new TextLabel(130,230,300,40,"Let's play Simon!");
		sequence = new ArrayList<MoveInterfaceFulton>();
		//add 2 moves to start
		lastSelectedButton = -1;
		sequence.add(randomMove());
		sequence.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progress);
		viewObjects.add(label);
	}

	

	private MoveInterfaceFulton randomMove() {
		int nextMove;
		while(true){
			nextMove = (int)(button.length*Math.random());
			if(nextMove != lastSelectedButton){
				break;
			}
			//code that randomly selects a ButtonInterfaceX
		}
		lastSelectedButton = nextMove;
		return getMove(button[nextMove]);
	}

	private MoveInterfaceFulton getMove(ButtonInterfaceFulton b) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	Placeholder until partner finishes implementation of ProgressInterface
	*/
	private ProgressInterfaceFulton getProgress() {
		return new Progress(200, 200, 50, 50);
	}

	private void addButtons(ArrayList<Visible> viewObjects) {
		 int numberOfButtons = 5;
		 button = new ButtonInterfaceFulton[numberOfButtons];
		 Color[] bColors = {Color.red,Color.blue,Color.green,Color.black,Color.yellow};
		 
		 for(int i = 0; i < numberOfButtons; i++){
			 final ButtonInterfaceFulton b = getAButton();
			 b.setColor(bColors[i]);
			 b.setX(160 + (int)(100*Math.cos(i*2*Math.PI/(numberOfButtons))));
			 b.setY(160 + (int)(100*Math.cos(i*2*Math.PI/(numberOfButtons))));
			 b.setAction(new Action(){
					public void act(){
						if(acceptingInput){
							Thread blink = new Thread(new Runnable(){
								public void run(){
									b.highlight();
									try{
										Thread.sleep(800);
									}catch(Exception e){
										e.printStackTrace();
									}
									b.dim();
								}
							});
							blink.start();
							
							if(b == sequence.get(sequenceIndex).getButton()){
								sequenceIndex += 1;
							}else{
								gameOver();
							}
							if(sequenceIndex == sequence.size()){
								Thread nextRound = new Thread(SimonScreenFulton.this);
								nextRound.start();
							}
						}
					}

			 });
			 viewObjects.add(button[i]);
		 }
	}
	
	private void gameOver() {
		progress.gameOver();
	}

	private ButtonInterfaceFulton getAButton() {
		return null;
	}

}
