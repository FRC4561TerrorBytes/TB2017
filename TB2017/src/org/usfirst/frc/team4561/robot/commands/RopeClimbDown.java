package org.usfirst.frc.team4561.robot.commands;

import org.usfirst.frc.team4561.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * TODO: Document
 * @author TODO
 */
public class RopeClimbDown extends Command {

    public RopeClimbDown() {
        requires(Robot.ropeClimber);
    }
    
	protected void execute() {
		Robot.ropeClimber.setClimber(-.5); //TODO: Change this from half power @Joseph	
	}
	
	@Override
	protected boolean isFinished() {
		//TODO: Auto-generated method stub
		return false;
	}

	// Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
