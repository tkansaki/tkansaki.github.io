import java.awt.Color;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class main {
	public static void main(String[] args) throws java.io.IOException {
		
		EZ.initialize(750,800);
		EZ.setBackgroundColor(new Color(0,0,0));
		/*
		* = nothing
		0 = vertical wall
		1 = horizontal wall
		2 = bend down/left wall
		3 = bend down/right wall
		4 = bend up/left wall
		5 = bend up/right wall
		6 = T split wall up/down/left
		7 = T split wall up/left/right
		8 = T split wall up/down/right
		9 = T split wall down/left/right
		a = cap up
		b = cap right
		c = cap down
		d = cap left
		. = dot
		! = power pellet
		*/
		EZText start = EZ.addText(375, 268, "Loading", Color.orange, 50);
		Grid maze = new Grid();
		pacman hero = new pacman();
		score scoreboard = new score();
		maze.initialize(scoreboard, hero);
		maze.loadall();
		hero.setpacman();
		scoreboard.setscoreboard();
		boolean game = true;
		EZSound startsong = EZ.addSound("pacman_beginning.wav");
		EZSound background = EZ.addSound("pacman_siren2.wav");
		start.setMsg("Press Spacebar to Start");
		EZText freeze = EZ.addText(375, 250, "", Color.orange, 300);
		while(true) {
			int supress = 0;
			if(EZInteraction.isKeyDown(32)) {
				start.hide();
				break;
			}
			supress++;
			System.out.println(supress);
		}
		startsong.play();
		background.loop();
		while(game) {
			maze.randommaze();
			if(maze.speedr != 0) {
				maze.resetmaze();
			}
			maze.movemaze();
			maze.stop(freeze);
			hero.movepacman(maze, scoreboard);
			hero.animatepacman();
			if(hero.end() == 1) {
				game = false;
			}
			EZ.refreshScreen();
		}
		background.stop();
		EZText end = EZ.addText(375, 250, "Your Score: " + score.score, Color.orange, 50);
	}
}
