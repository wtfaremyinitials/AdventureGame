package xyz.will.textcraft.entity;

import xyz.will.textcraft.Direction;
import xyz.will.textcraft.Location;
import xyz.will.textcraft.World;

/**
 * Class Entity
 * 
 * author: Will Franzen
 * version: 1.0
 * date: Dec 2014
 * 
 * The class represents a generic non-block entity that can exist in a world.
 * I meant to add more entities than just the player, such as animals and monsters,
 * but I did not have enough time.
 */
public abstract class Entity {

	// The world the entity is in, the location of the entity in thw world, and the direction the entity is facing
	private World world;
	private Location location;
	private Direction facing;
	
	public Entity(World world, Location location, Direction facing) {
		this.world    = world;
		this.location = location;
		this.facing   = facing;
	}
	
	// Get the location of the entity
	public Location getLocation() {
		return location;
	}
	
	// Get the direction the entity is facing
	public Direction getFacing() {
		return facing;
	}
	
	// Set the location of the entity
	public void setLocation(Location location) {
		this.location = location;
	}
	
	// Set the direction the entity is facing
	public void setFacing(Direction facing) {
		this.facing   = facing;
	}
	
	// Checks if the block below the entity is not air
	public boolean isOnGround() {
		Location under = getLocation().add(Direction.DOWN, 1);
		return !world.isClear(under);
	}
	
}
