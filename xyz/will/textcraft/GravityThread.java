package xyz.will.textcraft;

import xyz.will.textcraft.entity.Entity;

/**
 * Thread GravityThread
 * 
 * author: Will Franzen
 * version: 1.0
 * date: Dec 2014
 * 
 * This thread will move all entities not on solid ground down 1 block every second.
 */
public class GravityThread extends Thread {

	// Gravity update interval
	private final int UPDATE_INTERVAL = 1000;
	
	// Reference to the world associated with this gravity
	private World world;
	
	// Save a reference to the world, start itself
	public GravityThread(World world) {
		this.world = world;
		this.start();
	}
	
	public void run() {
		while(true) {
			// Loop through all entities, and move the ones that aren't on solid ground down
			for(Entity e : world.getEntities())
				if(!e.isOnGround())
					e.setLocation(e.getLocation().add(0, -1, 0));
			// Wait 1000ms and ignore InterrupedException's
			try { Thread.sleep(UPDATE_INTERVAL); } catch (InterruptedException e) {}
		}
	}	
	
}
