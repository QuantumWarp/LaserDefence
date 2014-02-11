package john_lowther.personal.laserdefence.utilities;

import java.util.ArrayList;
import java.util.List;

import john_lowther.personal.laserdefence.commands.Command;

/**
 * Timer. Ticks at a steady rate. Commands can be registered with this and they
 * will be executed every tick.
 * @author John Lowther
 */
public class Timer implements Runnable {
	private List<Command> commandList = new ArrayList<Command>();
	private Thread timerThread = new Thread(this);
	private boolean running; 
	private int tickInterval;
	private double ticksPerSecond;
	private long ticksPerformed;
	private long startTime;
	
	/**
	 * If no parameter is given will default to tick intervals of 1 second.
	 */
	public Timer() {
		setTickInterval(1000);
	}
	
	public Timer(int tickInterval) {
		setTickInterval(tickInterval);
	}
	
//================== Commands attached ==================//
	/**
	 * Adds the specified command.
	 * @param command
	 */
	public void addCommand(Command command) {
		commandList.add(command);
	}
	
	/**
	 * Removes the specified command.
	 * @param command
	 */
	public void removeCommand(Command command) {
		commandList.remove(command);
	}
	
	/**
	 * Calls the execute method for all commands registered.
	 */
	public void executeCommands() {
		for (Command command : commandList)
			command.execute();
		
		ticksPerformed++;
	}
	
//================== State methods ==================//
	
	/**
	 * Starts the timer. Stops the old thread if there is one. Creates a new thread.
	 */
	public void start() {
		if (timerThread.isAlive())
			stop();
		
		timerThread = new Thread(this);
		
		ticksPerformed = 0;
		startTime = System.currentTimeMillis();
		running = true;
		
		timerThread.start();
	}
	
	/** 
	 * Stops the timer. Can be used as a pause functionality.
	 */
	public void stop() {
		timerThread.interrupt();
		running = false;
		
		//TODO add efficient stopping method
	}
	
	@Override
	public void run() {
		while(running) {
			try {
				synchronized(timerThread) {
					timerThread.wait(tickInterval);
				}
			} catch (InterruptedException e) {
				return;
			}
			
			executeCommands();
		}
	}

//================== Getters and Setters ==================//
	
	/**
	 * @return Tick interval
	 */
	public int getTickInterval() {
		return tickInterval;
	}

	/**
	 * Sets the tick interval.
	 * @param tickInterval
	 */
	public void setTickInterval(int tickInterval) {
		this.tickInterval = tickInterval;
		ticksPerSecond = (double) (1000 / tickInterval);
	}

	/**
	 * @return Ticks per second.
	 */
	public double getTicksPerSecond() {
		return ticksPerSecond;
	}
	
	/**
	 * Note, the value set may not be the value truly set, as the tickInterval must be a whole number.
	 */
	public void setTicksPerSecond(double ticksPerSecond) {
		tickInterval = (int) (1000 / ticksPerSecond);
		setTickInterval(tickInterval);
	}

	/**
	 * @return If the timer is currently running.
	 */
	public boolean isRunning() {
		return running;
	}

	/**
	 * Note, restarts every time start is called.
	 * @return Time the timer has been running in milliseconds.
	 */
	public long getTimeRunning() {
		return System.currentTimeMillis() - startTime;
	}

	/**
	 * Note, restarts every time start is called.
	 * @return Number of ticks performed.
	 */
	public long getTicksPerformed() {
		return ticksPerformed;
	}
}
