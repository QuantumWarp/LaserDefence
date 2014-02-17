package john_lowther.personal.laserdefence.utilities;

/**
 * Class that just represents the position of an object. More game specific implementation
 * can be added as needed.
 * @author John Lowther
 */
public class Variable2D {
	private double x;
	private double y;
	
//================== Constructors ==================//
	
	public Variable2D() {
		this.x = 0;
		this.y = 0;
	}
	
	public Variable2D(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Variable2D(Variable2D variable2D) {
		this.x = variable2D.x;
		this.y = variable2D.y;
	}
	
//================== Add and Subtract ==================//
	
	public void add(double x, double y) {
		this.x += x;
		this.y += y;
	}
	
	public void add(Variable2D variable2D) {
		this.x += variable2D.x;
		this.y += variable2D.y;
	}
	
	public void add(double x, double y, double multiplier) {
		this.x += x * multiplier;
		this.y += y * multiplier;
	}
	
	public void add(Variable2D variable2D, double multiplier) {
		this.x += variable2D.x * multiplier;
		this.y += variable2D.y * multiplier;
	}
	
	public void subtract(double x, double y) {
		this.x -= x;
		this.y -= y;
	}
	
	public void subtract(Variable2D variable2D) {
		this.x -= variable2D.x;
		this.y -= variable2D.y;
	}
	
	public void subtract(double x, double y, double multiplier) {
		this.x -= x * multiplier;
		this.y -= y * multiplier;
	}
	
	public void subtract(Variable2D variable2D, double multiplier) {
		this.x -= variable2D.x * multiplier;
		this.y -= variable2D.y * multiplier;
	}
	
//================== Getters and Setters ==================//
	
	public void setX(double x) {
		this.x = x;
	}
	
	public double getX() {
		return x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public double getY() {
		return y;
	}
}
