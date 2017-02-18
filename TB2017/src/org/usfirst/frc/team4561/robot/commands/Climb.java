package org.usfirst.frc.team4561.robot.commands;

import org.usfirst.frc.team4561.robot.Robot;
import org.usfirst.frc.team4561.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 * This command initiates, sets power to 1, and stops the rope climber.
 * @author Ose, Morgan, Joseph
 */
public class Climb extends Command {

    public Climb() {
    	requires(Robot.ropeClimber);
    	setInterruptible(false);
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
    	if (RobotMap.ROPE_CLIMBER_VERBOSE) {
    		System.out.println("[Command] Intializing Climb");
    	}
    }
    
    // Called repeatedly when this Command is scheduled to run
  	protected void execute() {
  		Robot.ropeClimber.setClimber(1.0);
  	}
  	
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;  
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.ropeClimber.stop();
        if (RobotMap.ROPE_CLIMBER_VERBOSE) {
    		System.out.println("[Command] Ending Climb");
    	}
    }
    
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
 }
    
