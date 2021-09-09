import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class pacman {
	static EZImage[] pacman = new EZImage[5];
	int movex = 0;
	int movey = 0;
	int animatetimer = 0;
	double speedcontrol = 0;
	int speedmultiplier = 1;
	
	public void setpacman() {
		pacman[0] = EZ.addImage("pacmanopen.png", 375, 375);
		pacman[1] = EZ.addImage("pacmanopen.png", 375, 375);
		pacman[2] = EZ.addImage("pacmanopen.png", 375, 375);
		pacman[3] = EZ.addImage("pacmanopen.png", 375, 375);
		pacman[4] = EZ.addImage("pacmanclose.png", 375, 375);
		pacman[1].rotateBy(90);
		pacman[2].rotateBy(180);
		pacman[3].rotateBy(270);
		pacman[1].hide();
		pacman[2].hide();
		pacman[3].hide();
		pacman[4].hide();
	}
	
	public void movepacman(Grid maze, score scoreboard) throws FileNotFoundException {
		if (EZInteraction.isKeyDown('w')) {
			movey = -3 * speedmultiplier;
			movex = 0;
		}else if (EZInteraction.isKeyDown('s')) {
			movey = 3 * speedmultiplier;
			movex = 0;
		}else if (EZInteraction.isKeyDown('a')) {
			movex = -3 * speedmultiplier;
			movey = 0;
		} else if (EZInteraction.isKeyDown('d')) {
			movex = 3 * speedmultiplier;
			movey = 0;
		}
		
		for(int k = 0; k < 2; k++) {//cases
				for(int i = 0; i < 20; i++) {
					for(int j = 0; j < 15; j++) {
						if(maze.getypos(k, j, i) - pacman[0].getYCenter() < 0 && 
						maze.getypos(k, j, i) - pacman[0].getYCenter() > -50 && 
						maze.getxpos(k, j, i) - pacman[0].getXCenter() <= 25 && 
						maze.getxpos(k, j, i) - pacman[0].getXCenter() >= -25) {
							if(maze.typereturn(k, j, i) == '.') {
								maze.gone(k, j, i);
							}else if(maze.typereturn(k, j, i) == '!') {
								maze.gonep(k, j, i);
							}else {
								movey = 0;
								for(int anime = 0; anime < 5; anime++) {
									pacman[anime].translateBy(0, 1);
								}
							}
							
						}
						if(maze.getypos(k, j, i) - pacman[0].getYCenter() > 0 && 
						maze.getypos(k, j, i) - pacman[0].getYCenter() < 50 && 
						maze.getxpos(k, j, i) - pacman[0].getXCenter() <= 25 && 
						maze.getxpos(k, j, i) - pacman[0].getXCenter() >= -25) {
							if(maze.typereturn(k, j, i) == '.') {
								maze.gone(k, j, i);
							}else if(maze.typereturn(k, j, i) == '!') {
								maze.gonep(k, j, i);
							}else {
								movey = 0;
								for(int anime = 0; anime < 5; anime++) {
									pacman[anime].translateBy(0, -1);
								}
							}
						}
						if(maze.getypos(k, j, i) - pacman[0].getYCenter() >= -25 && 
						maze.getypos(k, j, i) - pacman[0].getYCenter() < 25 && 
						maze.getxpos(k, j, i) - pacman[0].getXCenter() < 0 && 
						maze.getxpos(k, j, i) - pacman[0].getXCenter() > -50) {
							if(maze.typereturn(k, j, i) == '.') {
								maze.gone(k, j, i);
							}else if(maze.typereturn(k, j, i) == '!') {
								maze.gonep(k, j, i);
							}else {
								movex = 0;
								for(int anime = 0; anime < 5; anime++) {
									pacman[anime].translateBy(1, 0);
								}
							}
						}
						if(maze.getypos(k, j, i) - pacman[0].getYCenter() >= -25 && 
						maze.getypos(k, j, i) - pacman[0].getYCenter() < 25 && 
						maze.getxpos(k, j, i) - pacman[0].getXCenter() > 0 && 
						maze.getxpos(k, j, i) - pacman[0].getXCenter() < 50) {
							if(maze.typereturn(k, j, i) == '.') {
								maze.gone(k, j, i);
							}else if(maze.typereturn(k, j, i) == '!') {
								maze.gonep(k, j, i);
							}else {
								movex = 0;
								for(int anime = 0; anime < 5; anime++) {
									pacman[anime].translateBy(-1, 0);
								}
							}
						}
						
						if(maze.counter < 500) {
							//going up
							if(maze.getyposstart(j, i) - pacman[0].getYCenter() < 0 && 
							maze.getyposstart(j, i) - pacman[0].getYCenter() > -50 && 
							maze.getxposstart(j, i) - pacman[0].getXCenter() <= 25 && 
							maze.getxposstart(j, i) - pacman[0].getXCenter() >= -25) {
								if(maze.typestart[j][i] == '.') {
									maze.gonestart(j, i);
								}else if(maze.typestart[j][i] == '!') {
									maze.gonestart(j, i);
								}else {
									movey = 0;
									for(int anime = 0; anime < 5; anime++) {
										pacman[anime].translateBy(0, 1);
									}
								}
							}
							//going down
							if(maze.getyposstart(j, i) - pacman[0].getYCenter() > 0 && 
							maze.getyposstart(j, i) - pacman[0].getYCenter() < 50 && 
							maze.getxposstart(j, i) - pacman[0].getXCenter() <= 25 && 
							maze.getxposstart(j, i) - pacman[0].getXCenter() >= -25) {
								if(maze.typestart[j][i] == '.') {
									maze.gonestart(j, i);
								}else if(maze.typestart[j][i] == '!') {
									maze.gonestart(j, i);
								}else {
									movey = 0;
									for(int anime = 0; anime < 5; anime++) {
										pacman[anime].translateBy(0, -1);
									}
								}
							}
							if(maze.getyposstart(j, i) - pacman[0].getYCenter() > -25 && 
							maze.getyposstart(j, i) - pacman[0].getYCenter() <= 25 && 
							maze.getxposstart(j, i) - pacman[0].getXCenter() < 0 && 
							maze.getxposstart(j, i) - pacman[0].getXCenter() > -50) {
								if(maze.typestart[j][i] == '.') {
									maze.gonestart(j, i);
								}else if(maze.typestart[j][i] == '!') {
									maze.gonestart(j, i);
								}else {
									movex = 0;
									for(int anime = 0; anime < 5; anime++) {
										pacman[anime].translateBy(1, 0);
									}
								}
							}
							if(maze.getyposstart(j, i) - pacman[0].getYCenter() >= -25 && 
							maze.getyposstart(j, i) - pacman[0].getYCenter() < 25 && 
							maze.getxposstart(j, i) - pacman[0].getXCenter() > 0 && 
							maze.getxposstart(j, i) - pacman[0].getXCenter() < 50) {
								if(maze.typestart[j][i] == '.') {
									maze.gonestart(j, i);
								}else if(maze.typestart[j][i] == '!') {
									maze.gonestart(j, i);
								}else {
									movex = 0;
									for(int anime = 0; anime < 5; anime++) {
										pacman[anime].translateBy(-1, 0);
									}
								}
							}
						}
					}
				}
			}
		for(int anime = 0; anime < 5; anime++) {
			pacman[anime].translateBy(movex, 2*maze.speedr + movey);
		}
	}
	
	public void animatepacman() {
		if(movex < 0) {
			if(animatetimer % 2 == 0) {
				pacman[0].hide();
				pacman[1].hide();
				pacman[2].show();
				pacman[3].hide();
				pacman[4].hide();
			}else {
				pacman[0].hide();
				pacman[1].hide();
				pacman[2].hide();
				pacman[3].hide();
				pacman[4].show();
			}
		}else if(movex > 0) {
			if(animatetimer % 2 == 0) {
				pacman[0].show();
				pacman[1].hide();
				pacman[2].hide();
				pacman[3].hide();
				pacman[4].hide();
			}else {
				pacman[0].hide();
				pacman[1].hide();
				pacman[2].hide();
				pacman[3].hide();
				pacman[4].show();
			}
		}else if(movey < 0) {
			if(animatetimer % 2 == 0) {
				pacman[0].hide();
				pacman[1].hide();
				pacman[2].hide();
				pacman[3].show();
				pacman[4].hide();
			}else {
				pacman[0].hide();
				pacman[1].hide();
				pacman[2].hide();
				pacman[3].hide();
				pacman[4].show();
			}
		}else if(movey > 0) {
			if(animatetimer % 2 == 0) {
				pacman[0].hide();
				pacman[1].show();
				pacman[2].hide();
				pacman[3].hide();
				pacman[4].hide();
			}else {
				pacman[0].hide();
				pacman[1].hide();
				pacman[2].hide();
				pacman[3].hide();
				pacman[4].show();
			}
		}
		animatetimer = (int) speedcontrol;
		speedcontrol += .20;
	}
	
	public int end() {
		if(pacman[0].getYCenter() > 800) {
			return 1;
		}else {
			return 0;
		}
	}
	/*
	public void speed(Grid maze) {
		if(maze.counter % 500 == 0) {
			speedmultiplier++;
		}
	}
	*/
}
