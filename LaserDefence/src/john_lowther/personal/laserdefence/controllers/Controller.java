package john_lowther.personal.laserdefence.controllers;

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
	private ControllerEnums method;
	protected Object[] parameters;
	
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
	 * Controller runs with the last specified method and parameters.
	 */
	public void runCurrent() {
		controllerThread.notify();
	}
	
	/**
	 * Controller runs with the last specified parameters and the input method.
	 * @param method
	 */
	public void runMethod(ControllerEnums method) {
		setMethod(method);
		runCurrent();
	}
	
	/**
	 * Controller runs with the input method and parameters.
	 * @param method
	 * @param parameters
	 */
	public void runMethod(ControllerEnums method, Object... parameters) {
		setParameters(parameters);
		setMethod(method);
		runCurrent();
	}
	
	@Override
	public void run() {
		while (running) {
			try {
				controllerThread.wait();
			} catch (InterruptedException e) {
				return;
			}
			
			switchMethod(method);
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
	protected abstract void switchMethod(ControllerEnums method);
	
//================== Getters and Setters ==================//
	

	/**
	 * @return If the controller is currently running.
	 */
	public boolean isRunning() {
		return running;
	}

	/**
	 * Set the parameters to call with the next run.
	 * @param parameters
	 */
	public void setParameters(Object... parameters) {
		this.parameters = parameters;
	}
	
	/**
	 * Set the method to call on next run.
	 * @param method
	 */
	public void setMethod(ControllerEnums method) {
		this.method = method;
	}
}
