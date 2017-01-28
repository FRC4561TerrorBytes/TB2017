package org.usfirst.frc.team4561.robot.commands;

import org.usfirst.frc.team4561.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * TODO: Document
 * @author TODO
 */
public class RopeClimbUp extends Command {

    public RopeClimbUp() {
    	requires(Robot.ropeClimber);
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("ROPE CLIMBER UP COMMAND INITIALIZED");
    }
    
  	protected void execute() {
  		Robot.ropeClimber.setClimber(.5); //TODO: Change this from half power @Joseph
  		System.out.println("ROPE CLIMBER UP COMMAND INITIALIZED");
  	}
  	
    protected boolean isFinished() {
        // TODO Auto-generated method stub
        return false;  
    }

    protected void end() {
        Robot.ropeClimber.stop();
        System.out.println("Stopping RopeClimbUp");
    }
    
    protected void interrupted() {
        end();
    }
 }
    
