import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener{
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
		for (int i = 0; i < aliens.size(); i++) {
			if (aliens.get(i).isActive == false) {
				aliens.remove(i);
			}
		}
		
		for (int i = 0; i < projectiles.size(); i++) {
			if (projectiles.get(i).isActive == false) {
				projectiles.remove(i);
			}
		}
	}
	
	void update() {
		
	}
		
	void draw(Graphics g) {
		rocket.draw(g);
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
	
	addAlien();
}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}}
