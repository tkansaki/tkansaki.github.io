import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;

public class ghost {
	
		int direction = 2; 
		EZImage[] ghost = new EZImage[4]; 
		int[] movex = new int[4];
		int[] movey = new int[4];
		 
		public void gsetup() {
			ghost[0] = EZ.addImage("ghost.png",225,725);
			ghost[1] = EZ.addImage("ghost.png",325,725);
			ghost[2] = EZ.addImage("ghost.png",425,725);
			ghost[3] = EZ.addImage("ghost.png",525,725);
			for(int i = 0; i < 4; i++) {
				movex[i] = 0;
				movey[i] = 0;
			}
		}
		
		public void randommove() {
			for(int i = 0; i < 4; i++) {
				//if(movey[i] == 0 && movex[i] == 0) {
					int random = (int) Math.random() * 4;
					if (random == 0) {
						movey[i] = -3;
						movex[i] = 0;
					}else if (random == 1) {
						movey[i] = 3;
						movex[i] = 0;
					}else if (random == 2) {
						movex[i] = -3;
						movey[i] = 0;
					} else if (random == 3) {
						movex[i] = 3;
						movey[i] = 0;
					}
				//}
			}
		}
		
		/*public void randomreset1(int i) {
			int random = (int) Math.floor(Math.random() * 3);
			if (random == 0) {
				movey[i] = 3;
				movex[i] = 0;
			}else if (random == 1) {
				movey[i] = 0;
				movex[i] = -3;
			}else if (random == 2) {
				movey[i] = 0;
				movex[i] = 3;
			}
		}
		
		public void randomreset2(int i) {
			int random = (int) Math.floor(Math.random() * 3);
			if (random == 0) {
				movey[i] = -3;
				movex[i] = 0;
			}else if (random == 1) {
				movey[i] = 0;
				movex[i] = -3;
			}else if (random == 2) {
				movey[i] = 0;
				movex[i] = 3;
			}
		}
		
		public void randomreset3(int i) {
			int random = (int) Math.floor(Math.random() * 3);
			if (random == 0) {
				movey[i] = 0;
				movex[i] = 3;
			}else if (random == 1) {
				movey[i] = 3;
				movex[i] = 0;
			}else if (random == 2) {
				movey[i] = -3;
				movex[i] = 0;
			}
		}
		
		public void randomreset4(int i) {
			int random = (int) Math.floor(Math.random() * 3);
			if (random == 0) {
				movey[i] = 0;
				movex[i] = -3;
			}else if (random == 1) {
				movey[i] = 3;
				movex[i] = 0;
			}else if (random == 2) {
				movex[i] = -3;
				movey[i] = 0;
			}
		}
		
		public void moveGhost(Grid maze) { 
			for(int h = 0; h < 4; h++) {
				for(int k = 0; k < 2; k++) {//cases
					for(int i = 0; i < 20; i++) {
						for(int j = 0; j < 15; j++) {
							//going up
							if(//maze.getypos(k, j, i) - ghost[h].getYCenter() < 0 && 
							maze.getypos(k, j, i) - ghost[h].getYCenter() > -50 && 
							maze.getxpos(k, j, i) - ghost[h].getXCenter() <= 25 && 
							maze.getxpos(k, j, i) - ghost[h].getXCenter() >= -25 &&
							movey[h] < 0) {
									movey[h] = 0;
									randomreset1(h);
									ghost[h].translateBy(0, 1);
							}
							if(//maze.getypos(k, j, i) - ghost[h].getYCenter() > 0 && 
							maze.getypos(k, j, i) - ghost[h].getYCenter() < 50 && 
							maze.getxpos(k, j, i) - ghost[h].getXCenter() <= 25 && 
							maze.getxpos(k, j, i) - ghost[h].getXCenter() >= -25 &&
							movey[h] > 0) {
									movey[h] = 0;
									randomreset2(h);
									ghost[h].translateBy(0, -1);
							}
							if(maze.getypos(k, j, i) - ghost[h].getYCenter() >= -25 && 
							maze.getypos(k, j, i) - ghost[h].getYCenter() < 25 && 
					//		maze.getxpos(k, j, i) - ghost[h].getXCenter() < 0 && 
							maze.getxpos(k, j, i) - ghost[h].getXCenter() > -50 &&
							movex[h] < 0) {
									movex[h] = 0;
									randomreset3(h);
									ghost[h].translateBy(1, 0);
							}
							if(maze.getypos(k, j, i) - ghost[h].getYCenter() >= -25 && 
							maze.getypos(k, j, i) - ghost[h].getYCenter() < 25 && 
						//	maze.getxpos(k, j, i) - ghost[h].getXCenter() > 0 && 
							maze.getxpos(k, j, i) - ghost[h].getXCenter() < 50 &&
							movex[h] > 0) {
									movex[h] = 0;
									randomreset4(h);
									ghost[h].translateBy(-1, 0);
							}
							
							if(maze.counter < 500) {
								//going up
								if(//maze.getyposstart(j, i) - ghost[h].getYCenter() < 0 && 
								maze.getyposstart(j, i) - ghost[h].getYCenter() > -50 && 
								maze.getxposstart(j, i) - ghost[h].getXCenter() <= 25 && 
								maze.getxposstart(j, i) - ghost[h].getXCenter() >= -25 &&
								movey[h] < 0) {
										movey[h] = 0;
										randomreset1(h);
										ghost[h].translateBy(0, 1);
								}
								//going down
								if(//maze.getyposstart(j, i) - ghost[h].getYCenter() > 0 && 
								maze.getyposstart(j, i) - ghost[h].getYCenter() < 50 && 
								maze.getxposstart(j, i) - ghost[h].getXCenter() <= 25 && 
								maze.getxposstart(j, i) - ghost[h].getXCenter() >= -25 &&
								movey[h] > 0) { 
										movey[h] = 0;
										randomreset2(h);
										ghost[h].translateBy(0, -1);
									
								}
								//going left
								if(maze.getyposstart(j, i) - ghost[h].getYCenter() >= -25 && 
								maze.getyposstart(j, i) - ghost[h].getYCenter() < 25 && 
								//maze.getxposstart(j, i) - ghost[h].getXCenter() < 0 && 
								maze.getxposstart(j, i) - ghost[h].getXCenter() > -50 &&
								movex[h] < 0) {
										movex[h] = 0;
										randomreset3(h);
										ghost[h].translateBy(1, 0);
								}
								//going right
								if(maze.getyposstart(j, i) - ghost[h].getYCenter() >= -25 && 
								maze.getyposstart(j, i) - ghost[h].getYCenter() < 25 && 
								//maze.getxposstart(j, i) - ghost[h].getXCenter() > 0 && 
								maze.getxposstart(j, i) - ghost[h].getXCenter() < 50 &&
								movey[h] > 0) {
										movex[h] = 0;
										randomreset4(h);
										ghost[h].translateBy(-1, 0);
								}
							}
						}
					}
				}
			
				ghost[h].translateBy(movex[h], movey[h]);
				//System.out.println(movex[h]+", "+ movey[h]);
			}
		}		*/		 
}