package org.usfirst.frc.team4561.robot.commands;

import org.usfirst.frc.team4561.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DebugMode extends Command {

	int motor;
	
	/**
	 * @param int motor: Determines which motor(s) this Command drives
	 * 1 - Drivetrain left
	 * 2 - Drivetrain right
	 * 3 - Shooter
	 * 4 - Agitator
	 * 5 - Rope climber
	 */
    public DebugMode(int motor) {
    	
    	// Requires whichever subsystem the method being invoked is in
    	switch (motor) {
    		case 1:
    		case 2:
    			requires(Robot.driveTrain);
    			break;
    		case 3:
    			requires(Robot.shooter);
    			break;
    		case 4:
    			requires(Robot.agitator);
    			break;
    		case 5:
    			requires(Robot.ropeClimber);
    			break;
    	}
    	this.motor = motor;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	switch (motor) {
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
