package org.usfirst.frc.team4561.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4561.robot.Robot;
import org.usfirst.frc.team4561.robot.RobotMap;

/**
 * Closes main mechanism for gear manipulator.
 * @author: Lucas T
 */
public class GearHolderClose extends Command {

    public GearHolderClose() {
    	requires(Robot.gearManipulator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if (RobotMap.GEAR_MANIPULATOR_VERBOSE) {
    		System.out.println("[Command] Intializing GearHolderClose");
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.gearManipulator.closeHolder();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	if (RobotMap.GEAR_MANIPULATOR_VERBOSE) {
    		System.out.println("[Command] Ending GearHolderClose");
    	}
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
