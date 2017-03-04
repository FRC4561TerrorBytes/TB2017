package org.usfirst.frc.team4561.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4561.robot.Robot;
import org.usfirst.frc.team4561.robot.RobotMap;

/**
 * TODO: Document
 * @author TODO
 */
public class DriveArcade extends Command {

    public DriveArcade() {
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if (RobotMap.DRIVETRAIN_VERBOSE) {
    		System.out.println("[Command] Intializing DriveArcade");
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		Robot.profilerTest("DriveArcade Start");
    	Robot.driveTrain.arcadeDrive(Robot.oi.getLeftStickY(), Robot.oi.getLeftStickX());
		Robot.profilerTest("DriveArcade End");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	if (RobotMap.DRIVETRAIN_VERBOSE) {
    		System.out.println("[Command] Ending DriveArcade");
    	}
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
