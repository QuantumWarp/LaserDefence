package john_lowther.personal.laserdefence.commands;

import john_lowther.personal.laserdefence.utilities.Expirable;

public class CommandExpire implements Command {
	Expirable expirable;
	
	public CommandExpire(Expirable expirable) {
		this.expirable = expirable;
	}
	
	@Override
	public void execute() {
		expirable.expire();
	}

}
