package org.usfirst.frc.team4561.robot.commands;

import org.usfirst.frc.team4561.robot.Robot;
import org.usfirst.frc.team4561.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 * TODO: Document and change names
 * @author Zane T, Ben G
 */
public class TorqueGear extends Command {

    public TorqueGear() {
        requires(Robot.transmission);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if (RobotMap.TRANSMISSION_VERBOSE) {
    		System.out.println("[Command] Intializing TorqueGear");
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.transmission.torqueGear();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	if (RobotMap.TRANSMISSION_VERBOSE) {
    		System.out.println("[Command] Ending TorqueGear");
    	}
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
