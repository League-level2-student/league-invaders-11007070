import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	@Override
	public void paintComponent(Graphics g){
		if(currentState == MENU){
		    drawMenuState(g);
		}
		else if(currentState == GAME){
		    drawGameState(g);
		}
		else if(currentState == END){
		    drawEndState(g);
		}
	}
	
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	Font titleFont = new Font("Arial", Font.PLAIN, 48);
	Font startFont = new Font("Arial", Font.PLAIN, 25);
	Font instructFont = new Font("Arial", Font.PLAIN, 25);
	Font gameOverFont = new Font("Arial", Font.PLAIN, 48);
	Font enemyFont = new Font("Arial", Font.PLAIN, 25);
	Font restartFont = new Font("Arial", Font.PLAIN, 25);
	Timer frameDraw;
	Rocketship rocketship = new Rocketship (250,700,50,50);
	ObjectManager objectManager = new ObjectManager(rocketship);
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	Timer alienSpawn;
	
	GamePanel() {
	    frameDraw = new Timer(1000/60,this);
	    frameDraw.start();
	    loadImage("space.png");
	}
	void updateMenuState() {  
		
	}
	void updateGameState() {  
		//objectManager.update();
		if (rocketship.isActive == false) {
			currentState = END;
		}
	}
	void updateEndState()  {  
		
	}
	void drawMenuState(Graphics g) {  
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("LEAGUE INVADERS", 20, 90);
		
		g.setFont(startFont);
		g.setColor(Color.YELLOW);
		g.drawString("Press ENTER to start", 120, 280);
		
		g.setFont(instructFont);
		g.setColor(Color.YELLOW);
		g.drawString("Press SPACE for instructions", 70, 420);
	}
	void drawGameState(Graphics g) {  
		if (gotImage) {
			g.drawImage(image, 0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);
		} else {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		}
		objectManager.draw(g);
	}
	void drawEndState(Graphics g)  {  
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		
		g.setFont(gameOverFont);
		g.setColor(Color.BLACK);
		g.drawString("GAME OVER", 100, 90);
		
		g.setFont(enemyFont);
		g.setColor(Color.BLACK);
		g.drawString("You killed enemies", 130, 280);
		
		g.setFont(restartFont);
		g.setColor(Color.BLACK);
		g.drawString("Press ENTER to restart", 100, 420);
	}
	
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}
	
	void startGame() {
		alienSpawn = new Timer(1000 , objectManager);
	    alienSpawn.start();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		    alienSpawn.stop();
		}
		System.out.println("action");
		repaint();
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
			if (currentState == END) {
				currentState = MENU;
			}
			else if (currentState == MENU) {
				currentState = GAME;
				startGame();
			}
			else {
				currentState++;
			}
		}
		if (e.getKeyCode()==KeyEvent.VK_SPACE) {
			if (currentState == GAME) {
				objectManager.addProjectile(rocketship.getProjectile());
			}
		}
		if (e.getKeyCode()==KeyEvent.VK_UP) {
		    System.out.println("UP");
		    if (rocketship.y > 10) {
		    	rocketship.up();
		    }
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN) {
		    System.out.println("DOWN");
		    if (rocketship.y < 710) {
		    	rocketship.down();
		    }
		}
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
		    System.out.println("LEFT");
		    if (rocketship.x > 10) {
		    	rocketship.left();
		    }
		}
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
		    System.out.println("RIGHT");
		    if (rocketship.x < 430) {
		    	rocketship.right();
		    }
		}
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
