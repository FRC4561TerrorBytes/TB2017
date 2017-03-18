package org.usfirst.frc.team4561.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4561.robot.Robot;
import org.usfirst.frc.team4561.robot.RobotMap;

/**
 * Default command for gear manipulator, actuates both holder and cover.
 * Is interrupted by GearOverride when both triggers are pressed.
 * @author: Lucas T, Kaiz
 */
public class GearDefaultCommand extends Command {

    public GearDefaultCommand() {
    	requires(Robot.gearManipulator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if (RobotMap.GEAR_MANIPULATOR_VERBOSE) {
    		System.out.println("[Command] Intializing GearDefaultCommand");
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (Robot.oi.getGearHolderButton()) {
    		Robot.gearManipulator.closeHolder();
    	} else {
    		Robot.gearManipulator.openHolder();
    	}
    	if (Robot.oi.getGearCoverButton()) {
    		Robot.gearManipulator.openCover();
    	} else {
    		Robot.gearManipulator.closeCover();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	if (RobotMap.GEAR_MANIPULATOR_VERBOSE) {
    		System.out.println("[Command] Ending GearDefaultCommand");
    	}
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
