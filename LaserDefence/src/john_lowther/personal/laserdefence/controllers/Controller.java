package john_lowther.personal.laserdefence.controllers;

import java.util.LinkedList;

import john_lowther.personal.laserdefence.controllers.enums.ControllerEnums;

/* TODO should make sure the list is empty before waiting. There is a miniscule possibility for error.
   Also speed has not been tested. This class must be extremly fast at processing a method.
   Also maybe add functionality to allow async methods to be called immediately even if a
   concurrent method is already being evaluated. */
/**
 * This class provides the methods so that it can pass on jobs that it has been told
 * to perform via the use of enums. A class extending this should contain a switch
 * statement in the run method that switches over the method enums.
 * @author John Lowther
 */
public abstract class Controller implements Runnable {
	private Thread controllerThread;
	private boolean running;
	private LinkedList<ControllerEnums> methodQueue = new LinkedList<ControllerEnums>();
	private LinkedList<Object[]> parametersQueue = new LinkedList<Object[]>();
	private LinkedList<Boolean> asyncQueue = new LinkedList<Boolean>();
	
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
		
	@Override
	public void run() {
		while (running) {
			try {
				controllerThread.wait();
			} catch (InterruptedException e) {
				return;
			}
			
			runList();
		}
	}
	
	/**
	 * Emptys the queue of methods by running them.
	 * If this method is already running this method is instantly returned.
	 */
	private void runList() {
		while (!methodQueue.isEmpty()) {
			runNextMethod();
		}
	}
	
	/**
	 * Runs the next method either asyncronously or concurrently based on the asyncQueue.
	 */
	private void runNextMethod() {
		if (asyncQueue.removeLast())
			new Thread(new Runnable() {
				public void run() {
					switchMethod(methodQueue.removeFirst(), parametersQueue.removeFirst());
				}
			});
		else
			switchMethod(methodQueue.removeFirst(), parametersQueue.removeFirst());
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
		addMethod(method, false, new Object[]{ null });
	}
	
	/**
	 * Adds a method to the queue. Can also set parameters.
	 * @param method
	 * @param parameters
	 */
	public void addMethod(ControllerEnums method, Object... parameters) {
		addMethod(method, false, parameters);
	}

	/**
	 * Adds a method to the queue. Can set if method will run asynchronously.
	 * @param method
	 * @param async
	 */
	public void addMethod(ControllerEnums method, boolean async) {
		addMethod(method, async, new Object[]{ null });
	}
	
	/**
	 * Adds a method to the queue. Can set if method will run asynchronously.
	 * Can also set parameters.
	 * @param method
	 * @param async
	 * @param parameters
	 */
	public void addMethod(ControllerEnums method, boolean async, Object... parameters) {
		parametersQueue.addLast(parameters);
		asyncQueue.addLast(async);
		methodQueue.addLast(method);
		controllerThread.notify();
	}
}
