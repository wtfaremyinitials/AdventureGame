package xyz.will.textcraft.entity;

import xyz.will.textcraft.Direction;
import xyz.will.textcraft.Location;
import xyz.will.textcraft.World;

public abstract class Entity {

	private World world;
	private Location location;
	private Direction facing;
	
	public Entity(World world, Location location, Direction facing) {
		this.world    = world;
		this.location = location;
		this.facing   = facing;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public Direction getFacing() {
		return facing;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public void setFacing(Direction facing) {
		this.facing   = facing;
	}
	
	public boolean isOnGround() {
		Location under = getLocation().add(0, -1, 0);
		return !world.isClear(under);
	}
	
}
