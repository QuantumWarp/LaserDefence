package john_lowther.personal.laserdefence.gamemodel.missiles.modules;

import john_lowther.personal.laserdefence.utilities.Variable2D;

public abstract class MovementModule implements Module {
	protected Variable2D origin;
	protected Variable2D position;
	protected Variable2D velocity;
	protected Variable2D acceleration;
	
	public void move() {
		position.add(velocity);
		velocity.add(acceleration);
	}
	
//================== Getters and Setters ==================//
	
	public Variable2D getOrigin() {
		return origin;
	}
	
	public void setOrigin(Variable2D origin) {
		this.origin = origin;
	}
	
	public Variable2D getPosition() {
		return position;
	}
	
	public void setPosition(Variable2D position) {
		this.position = position;
	}
	
	public Variable2D getAcceleration() {
		return acceleration;
	}
	
	public void setAcceleration(Variable2D acceleration) {
		this.acceleration = acceleration;
	}

	public Variable2D getVelocity() {
		return velocity;
	}

	public void setVelocity(Variable2D velocity) {
		this.velocity = velocity;
	}
}
