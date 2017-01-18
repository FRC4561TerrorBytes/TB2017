package org.usfirst.frc.team4561.robot.commands;

import org.usfirst.frc.team4561.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class RopeClimbDown extends Command 
{

    public RopeClimbDown() {
        requires(Robot.ropeclimber);

    }
	protected void execute() {
		Robot.ropeclimber.setClimber(-.5); //CHANGE IT FROM HALF POWER YOU FOOLS @Joseph	
	}

	
	@Override
	protected boolean isFinished() 
	{
		return false;					// TODO Auto-generated method stub
	}

	   // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    
}
