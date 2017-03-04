package org.usfirst.frc.team4561.robot.commands;

import org.usfirst.frc.team4561.robot.Robot;
import org.usfirst.frc.team4561.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 * TODO: Document
 * @author Jonah W
 */
public class DriveTank extends Command {

    public DriveTank() {
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if (RobotMap.DRIVETRAIN_VERBOSE) {
    		System.out.println("[Command] Intializing DriveTank");
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		Robot.profilerTest("DriveTank Start");
    	Robot.driveTrain.tankDrive(Robot.oi.getLeftStickY(), Robot.oi.getRightStickY());
		Robot.profilerTest("DriveTank End");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	if (RobotMap.DRIVETRAIN_VERBOSE) {
    		System.out.println("[Command] Ending DriveTank");
    	}
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
