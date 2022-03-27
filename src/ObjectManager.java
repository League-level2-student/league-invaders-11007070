import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Rocketship rocket;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	Random random = new Random();
	Graphics g;
	
	ObjectManager (Rocketship r) {
		rocket = r;
	}
	
	void addProjectile(Projectile p) {
		projectiles.add(p);
	}
	
	void addAlien() {
		aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH),0,50,50));
	}
	
	void purgeObjects() {
		
	}
	
	void update() {
		
	}
		
	void draw(Graphics g) {
		
	}{
		
	for (int i = 0; i < aliens.size(); i++) {
		aliens.get(i).update();
		aliens.get(i).draw(g);
		if (aliens.get(i).y > LeagueInvaders.HEIGHT || aliens.get(i).y < LeagueInvaders.HEIGHT) {
			aliens.get(i).isActive = false;
		}
	}
	
	for (int i = 0; i < projectiles.size(); i++) {
		projectiles.get(i).update();
		projectiles.get(i).draw(g);
		if (projectiles.get(i).y > LeagueInvaders.HEIGHT || projectiles.get(i).y < LeagueInvaders.HEIGHT) {
			projectiles.get(i).isActive = false;
		}
	}
	
}}