package org.usfirst.frc.team4561.robot.commands;

import org.usfirst.frc.team4561.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class RopeClimbUp extends Command 
    {


      public RopeClimbUp() {
          requires(Robot.ropeclimber);

      }
      
  	protected void execute() {
  		Robot.ropeclimber.setClimber(.5); //CHANGE IT FROM HALF POWER YOU FOOLS @Joseph
  		
  	}
  	
  	
    protected boolean isFinished() {
        // TODO Auto-generated method stub
        return false;
        
    }

    protected void end() {
        Robot.ropeclimber.stop();
        System.out.println("Stopping RopeClimbUp");
    }
    protected void interrupted() {
        end();
    }
 
    }
    
