package org.usfirst.frc.team4561.robot.commands;

import org.usfirst.frc.team4561.robot.Robot;
import org.usfirst.frc.team4561.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 * TODO: Document
 * @author Ben G
 */
public class IntakeBall extends Command {

    public IntakeBall() {
    	requires(Robot.intake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if (RobotMap.INTAKE_VERBOSE) {
    		System.out.println("[Command] Initializing IntakeBall");
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	// Intake at full speed
    	Robot.intake.intakeBall(1.0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.intake.stop();
    	if (RobotMap.INTAKE_VERBOSE) {
    		System.out.println("[Command] Ending IntakeBall");
    	}
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
