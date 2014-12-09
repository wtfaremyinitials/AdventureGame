package xyz.will.textcraft;

import xyz.will.textcraft.entity.Entity;

public class GravityThread extends Thread {

	private World world;
	
	public GravityThread(World world) {
		this.world = world;
		this.start();
	}
	
	public void run() {
		while(true) {
			for(Entity e : world.getEntities())
				if(!e.isOnGround())
					e.setLocation(e.getLocation().add(0, -1, 0));
			try { Thread.sleep(1000); } catch (InterruptedException e) {}
		}
	}	
	
}
