import java.awt.Color;

public class score {
	EZText f;
	static int score = 0;
	EZSound chomp = EZ.addSound("pacman_chomp2.wav");
	
	public void setscoreboard() {
		f = EZ.addText(120, 50, "Score: " + score, Color.orange, 50);
	}
	
	public void add1() {
		score++;
		f.setMsg("Score: " + score);
		chomp.play();
	}
}