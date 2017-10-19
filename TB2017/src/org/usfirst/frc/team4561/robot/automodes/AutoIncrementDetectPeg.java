package org.usfirst.frc.team4561.robot.automodes;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoIncrementDetectPeg extends Command {

	public static boolean stopped = false;
	
    public AutoIncrementDetectPeg() {
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	stopped = true;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
