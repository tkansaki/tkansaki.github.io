import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Grid {
	EZImage[][] startgrid = new EZImage[15][25];
	EZImage[][][] grid = new EZImage[3][15][25];//cases
	char[][][] type = new char[3][15][25];
	char[][] typestart = new char[15][25];
	String[] instructfiles = new String[] {"case1.txt", "case2.txt", "case3.txt"};
	int grid1;
	int grid2;
	int counter = 0;
	int secondarycounter = 0;
	score scoreboard;
	pacman hero;
	int speedr = 1;
	int time = 250;
	
	
	public void initialize(score temp, pacman temp2) throws FileNotFoundException{
		FileReader initial = new FileReader("initial.txt"); 	
		Scanner fileScanner = new Scanner(initial);
		String inputText;
		for(int i = 0; i < 20; i++) {
			inputText = fileScanner.nextLine();
			
			for(int j = 0; j < 15; j++) {
				char ch = inputText.charAt(j);
				typestart[j][i] = ch;
				if(ch == '0') {
					startgrid[j][i] = EZ.addImage("strait.png",j*50 + 25,i*50 - 175);
				}else if(ch == '1') {
					startgrid[j][i] = EZ.addImage("strait.png",j*50 + 25,i*50 - 175);
					startgrid[j][i].rotateBy(90);
				}else if(ch == '2') {
					startgrid[j][i] = EZ.addImage("bend.png",j*50 + 25,i*50 - 175);
				}else if(ch == '3') {
					startgrid[j][i] = EZ.addImage("bend.png",j*50 + 25,i*50 - 175);
					startgrid[j][i].rotateBy(270);
				}else if(ch == '4') {
					startgrid[j][i] = EZ.addImage("bend.png",j*50 + 25,i*50 - 175);
					startgrid[j][i].rotateBy(90);
				}else if(ch == '5') {
					startgrid[j][i] = EZ.addImage("bend.png",j*50 + 25,i*50 - 175);
					startgrid[j][i].rotateBy(180);
				}else if(ch == '6') {
					startgrid[j][i] = EZ.addImage("triple.png",j*50 + 25,i*50 - 175);
				}else if(ch == '7') {
					startgrid[j][i] = EZ.addImage("triple.png",j*50 + 25,i*50 - 175);
					startgrid[j][i].rotateBy(90);
				}else if(ch == '8') {
					startgrid[j][i] = EZ.addImage("triple.png",j*50 + 25,i*50 - 175);
					startgrid[j][i].rotateBy(180);
				}else if(ch == '9') {
					startgrid[j][i] = EZ.addImage("triple.png",j*50 + 25,i*50 - 175);
					startgrid[j][i].rotateBy(270);
				}else if(ch == 'a') {
					startgrid[j][i] = EZ.addImage("cap.png",j*50 + 25,i*50 - 175);
				}else if(ch == 'b') {
					startgrid[j][i] = EZ.addImage("cap.png",j*50 + 25,i*50 - 175);
					startgrid[j][i].rotateBy(90);
				}else if(ch == 'c') {
					startgrid[j][i] = EZ.addImage("cap.png",j*50 + 25,i*50 - 175);
					startgrid[j][i].rotateBy(180);
				}else if(ch == 'd') {
					startgrid[j][i] = EZ.addImage("cap.png",j*50 + 25,i*50 - 175);
					startgrid[j][i].rotateBy(270);
				}else if(ch == '.') {
					startgrid[j][i] = EZ.addImage("pellet.png",j*50 + 25,i*50 - 175);
				}else if(ch == '!') {
					startgrid[j][i] = EZ.addImage("ppellet.png",j*50 + 25,i*50 - 175);
				}
			}
		}
		fileScanner.close();
		scoreboard = temp;
		hero = temp2;
	}
	
	public void loadall() throws FileNotFoundException {
		for(int k = 0; k < 3; k++) {//cases
			FileReader initial = new FileReader(instructfiles[k]);
			Scanner fileScanner = new Scanner(initial);
			String inputText;
			for(int i = 0; i < 20; i++) {
				inputText = fileScanner.nextLine();
				for(int j = 0; j < 15; j++) {
					char ch = inputText.charAt(j);
					type[k][j][i] = ch;
					if(ch == '0') {
						grid[k][j][i] = EZ.addImage("strait.png",j*50 + 25,i*50 + 825);
					}else if(ch == '1') {
						grid[k][j][i] = EZ.addImage("strait.png",j*50 + 25,i*50 + 825);
						grid[k][j][i].rotateBy(90);
					}else if(ch == '2') {
						grid[k][j][i] = EZ.addImage("bend.png",j*50 + 25,i*50 + 825);
					}else if(ch == '3') {
						grid[k][j][i] = EZ.addImage("bend.png",j*50 + 25,i*50 + 825);
						grid[k][j][i].rotateBy(270);
					}else if(ch == '4') {
						grid[k][j][i] = EZ.addImage("bend.png",j*50 + 25,i*50 + 825);
						grid[k][j][i].rotateBy(90);
					}else if(ch == '5') {
						grid[k][j][i] = EZ.addImage("bend.png",j*50 + 25,i*50 + 825);
						grid[k][j][i].rotateBy(180);
					}else if(ch == '6') {
						grid[k][j][i] = EZ.addImage("triple.png",j*50 + 25,i*50 + 825);
					}else if(ch == '7') {
						grid[k][j][i] = EZ.addImage("triple.png",j*50 + 25,i*50 + 825);
						grid[k][j][i].rotateBy(90);
					}else if(ch == '8') {
						grid[k][j][i] = EZ.addImage("triple.png",j*50 + 25,i*50 + 825);
						grid[k][j][i].rotateBy(180);
					}else if(ch == '9') {
						grid[k][j][i] = EZ.addImage("triple.png",j*50 + 25,i*50 + 825);
						grid[k][j][i].rotateBy(270);
					}else if(ch == 'a') {
						grid[k][j][i] = EZ.addImage("cap.png",j*50 + 25,i*50 + 825);
					}else if(ch == 'b') {
						grid[k][j][i] = EZ.addImage("cap.png",j*50 + 25,i*50 + 825);
						grid[k][j][i].rotateBy(90);
					}else if(ch == 'c') {
						grid[k][j][i] = EZ.addImage("cap.png",j*50 + 25,i*50 + 825);
						grid[k][j][i].rotateBy(180);
					}else if(ch == 'd') {
						grid[k][j][i] = EZ.addImage("cap.png",j*50 + 25,i*50 + 825);
						grid[k][j][i].rotateBy(270);
					}else if(ch == '.') {
						grid[k][j][i] = EZ.addImage("pellet.png",j*50 + 25,i*50 + 825);
					}else if(ch == '!') {
						grid[k][j][i] = EZ.addImage("ppellet.png",j*50 + 25,i*50 + 825);
					}
				}
			}
			fileScanner.close();
		}
	}
	
	public void randommaze() {
		boolean breaker = true;
		if(counter % 500 == 0) {
			if(secondarycounter % 2 == 0) {
				while(breaker) {
					grid1 = (int) Math.floor(Math.random() * 3);//cases
					if(grid1 != grid2) {
						breaker = false;
					}
				}
			}else {
				while(breaker) {
					grid2 = (int) Math.floor(Math.random() * 3);//cases
					if(grid1 != grid2) {
						breaker = false;
					}
					
				}
			}
		}
	}
	
	public void resetmaze() {
		if(counter % 500 == 0) {
			if(secondarycounter % 2 == 0) {				
				for(int i = 0; i < 20; i++) {
					for(int j = 0; j < 15; j++) {
						if(grid[grid1][j][i] != null) {
							int x = grid[grid1][j][i].getXCenter();
							int y = grid[grid1][j][i].getYCenter();
							grid[grid1][j][i].translateTo(x, y - 2000);
							if(grid[grid1][j][i].isShowing() == false) {
								grid[grid1][j][i].show();
							}
						}
					}
				}	
			}else {
				for(int i = 0; i < 20; i++) {
					for(int j = 0; j < 15; j++) {
						if(grid[grid2][j][i] != null) {
							int x = grid[grid2][j][i].getXCenter();
							int y = grid[grid2][j][i].getYCenter();
							grid[grid2][j][i].translateTo(x, y - 2000);
							if(grid[grid2][j][i].isShowing() == false) {
								grid[grid2][j][i].show();
							}
						}
					}
				}
			}
			secondarycounter++;
		}
	}
	
	public void movemaze() {
		for(int i = 0; i < 20; i++) {
			for(int j = 0; j < 15; j++) {
				if(grid[grid1][j][i] != null) {
					grid[grid1][j][i].translateBy(0, 2*speedr);
				}
				if(grid[grid2][j][i] != null && counter >= 500) {
					grid[grid2][j][i].translateBy(0, 2*speedr);
				}
				if(counter <= 1000 && startgrid[j][i] != null) {
					startgrid[j][i].translateBy(0, 2*speedr);
				}else if(counter > 1000 && counter < 1001 && startgrid[j][i] != null) {
					startgrid[j][i].hide();
				}
			}
		}
		counter += speedr;
	}
	
	public int getxpos(int a, int b, int c) {
		int x;
		if(a == 0) {
			x = grid1;
		}else{
			x = grid2;
		}
		
		if(grid[x][b][c] != null) {
			return grid[x][b][c].getXCenter();
		}else {
			return 0;
		}
	}
	
	public int getypos(int a, int b, int c) {
		int x;
		if(a == 0) {
			x = grid1;
		}else{
			x = grid2;
		}
		
		if(grid[x][b][c] != null) {
			return grid[x][b][c].getYCenter();
		}else {
			return 0;
		}
	}
	
	public int getxposstart(int a, int b) {
		if(startgrid[a][b] != null) {
			return startgrid[a][b].getXCenter();
		}else {
			return 0;
		}
	}

	public int getyposstart(int a, int b) {
		if(startgrid[a][b] != null) {
			return startgrid[a][b].getYCenter();
		}else {
			return 0;
		}
	}
	
	public void gone(int a, int b, int c) {
		int x;
		if(a == 0) {
			x = grid1;
		}else{
			x = grid2;
		}
		
		if(grid[x][b][c] != null) {
			if(grid[x][b][c].isShowing()) {
				grid[x][b][c].hide();
				scoreboard.add1();
			}
		}
	}
	
	public void gonestart(int a, int b) {
		if(startgrid[a][b] != null) {
			if(startgrid[a][b].isShowing()) {
				startgrid[a][b].hide();
				scoreboard.add1();
			}
		}
	}
	
	
	 	public void gonep(int a, int b, int c) {
		int x;
		if(a == 0) {
			x = grid1;
		}else{
			x = grid2;
		}
		
		if(grid[x][b][c] != null) {
			if(grid[x][b][c].isShowing()) {
				grid[x][b][c].hide();
				scoreboard.add1();
				time = 0;
			}
		}
	}
	
	public void stop(EZText freeze){
		if(time < 250) {
			int x = (int) 5 - (time/50);
			freeze.show();
			freeze.setMsg(x+"");
			time++;
			speedr = 0;
			if(time == 250) {
				freeze.hide();
			}
			System.out.println(time);
		}else {
			speedr = 1;
		}
	}
	
	
	public char typereturn(int a, int b, int c) {
		int x;
		if(a == 0) {
			x = grid1;
		}else{
			x = grid2;
		}
		
		return type[x][b][c];
	}
}