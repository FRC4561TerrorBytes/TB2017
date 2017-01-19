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
      
  	protected void execute() {
  		Robot.ropeClimber.setClimber(.5); //TODO: Change this from half power @Joseph
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
    
