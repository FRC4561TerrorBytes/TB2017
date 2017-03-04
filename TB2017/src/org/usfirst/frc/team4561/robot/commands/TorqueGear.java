package org.usfirst.frc.team4561.robot.commands;

import org.usfirst.frc.team4561.robot.Robot;
import org.usfirst.frc.team4561.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Changes the gear to the torque gear.
 * Requires the Transmission solenoid.
 * TODO: Change names
 * @author Zane T, Ben G
 */
public class TorqueGear extends Command {

    public TorqueGear() {
        requires(Robot.transmission);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(1);
    	if (RobotMap.TRANSMISSION_VERBOSE) {
    		System.out.println("[C:TorqueGear] Intializing...");
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		Robot.profilerTest("TorqueGear Start");
    	//Actually change the gear
    	Robot.transmission.torqueGear();
		Robot.profilerTest("TorqueGear End");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.transmission.stop();
    	if (RobotMap.TRANSMISSION_VERBOSE) {
    		System.out.println("[C:TorqueGear] Command finished.");
    	}
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
