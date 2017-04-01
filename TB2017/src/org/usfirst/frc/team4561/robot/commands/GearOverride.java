package org.usfirst.frc.team4561.robot.commands;

import org.usfirst.frc.team4561.robot.Robot;
import org.usfirst.frc.team4561.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Overrides the gear manipulator default command to give the main driver release control.
 * @author Kaiz
 */
public class GearOverride extends Command {

    public GearOverride() {
    	requires(Robot.gearManipulator);
    	setInterruptible(false);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if (RobotMap.GEAR_MANIPULATOR_VERBOSE) {
    		System.out.println("[Command] Intializing GearHolderOpen");
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.gearManipulator.openHolder();
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
    		System.out.println("[Command] Ending GearHolderOpen");
    	}
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
