package org.usfirst.frc.team4561.robot.commands;

import org.usfirst.frc.team4561.robot.Robot;
import org.usfirst.frc.team4561.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 * TODO: Document
 * @author Ben G
 */
public class SetAgitatorPower extends Command {
	
	double power = 0;
	
    public SetAgitatorPower(double power) {
    	requires(Robot.agitator);
    	this.power = power;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if (RobotMap.GEAR_MANIPULATOR_VERBOSE) {
    		System.out.println("[Command] Intializing SetAgitatorPower for power " + Double.toString(power));
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	// Intake at variable speed
    	Robot.agitator.setPower(power);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.agitator.stop();
    	if (RobotMap.GEAR_MANIPULATOR_VERBOSE) {
    		System.out.println("[Command] Ending SetAgitatorPower");
    	}
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
