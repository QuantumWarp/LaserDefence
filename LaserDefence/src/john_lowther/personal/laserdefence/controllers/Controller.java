package john_lowther.personal.laserdefence.controllers;

import java.util.LinkedList;

import john_lowther.personal.laserdefence.controllers.enums.ControllerEnums;

//TODO should eventually not allow the method and parameters to change when the
//controller is in a run cycle so that a method is called with the wrong parameters.
/**
 * This class provides the methods so that it can pass on jobs that it has been told
 * to perform via the use of enums. A class extending this should contain a switch
 * statement in the run method that switches over the method enums.
 * @author John Lowther
 */
public abstract class Controller implements Runnable {
	private Thread controllerThread;
	private boolean running;
	private boolean methodsRunning = false;
	private LinkedList<ControllerEnums> methodQueue = new LinkedList<ControllerEnums>();
	protected LinkedList<Object[]> parametersQueue = new LinkedList<Object[]>();
	
	/**
	 * Starts the controller. Stops the old controller if there is one. Creates a new thread.
	 * Note, there is very little reason to stop a controller unless it has completed its lifecycle.
	 * Therefore using this method to restart a controller has little use.
	 */
	public void start() {
		if (controllerThread.isAlive())
			stop();
		
		controllerThread = new Thread(this);
		running = true;
		controllerThread.start();
	}
	
	/** 
	 * Stops the controller.
	 */
	public void stop() {
		controllerThread.interrupt();
		running = false;
		
		try {
			controllerThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

//================== Running Methods ==================//
	
	/**
	 * Emptys the queue of methods by running them.
	 * If this method is already running this method is instantly returned.
	 */
	public void runList() {
		if (methodsRunning)
			return;
		
		methodsRunning = true;
		
		while (!methodQueue.isEmpty()) {
			controllerThread.notify();
		}
		
		methodsRunning = false;
	}
	
	@Override
	public void run() {
		while (running) {
			try {
				controllerThread.wait();
			} catch (InterruptedException e) {
				return;
			}
			
			switchMethod(methodQueue.removeFirst(), parametersQueue.removeFirst());
		}
	}
	
	/**
	 * This method is where all the possible cases are held based on which enums
	 * the variable 'method' is cast to. Example below:
	 *<pre>
	 *	protected void switchMethod(ControllerEnums method) {
	 *		switch ((ExampleGameEnums) method) {
	 *		case EXAMPLE:
	 *			//do stuff
	 *			break;
	 *		}
	 *	}
	 * </pre>
	 * @param method
	 */
	protected abstract void switchMethod(ControllerEnums method, Object[] parameters);
	
//================== Getters and Setters ==================//
	

	/**
	 * @return If the controller is currently running.
	 */
	public boolean isRunning() {
		return running;
	}
	
	/**
	 * Adds a method to the queue.
	 * @param method
	 */
	public void addMethod(ControllerEnums method) {
		parametersQueue.addLast(null);
		methodQueue.add(method);
		runList();
	}
	
	/**
	 * Adds a method to the queue.
	 * @param method
	 */
	public void addMethod(ControllerEnums method, Object... parameters) {
		parametersQueue.addLast(parameters);
		methodQueue.addLast(method);
		runList();
	}
}
