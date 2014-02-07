package john_lowther.personal.laserdefence.commands;

import john_lowther.personal.laserdefence.utilities.Tickable;

/**
 * A command that knows of a single tickable object.
 * @author John Lowther
 */
public class CommandTick implements Command {
	Tickable tickable;
	
	public CommandTick(Tickable tickable) {
		this.tickable = tickable;
	}
	
	@Override
	public void execute() {
		tickable.tick();
	}

}
