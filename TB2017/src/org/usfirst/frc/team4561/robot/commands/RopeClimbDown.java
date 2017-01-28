package org.usfirst.frc.team4561.robot.commands;

import org.usfirst.frc.team4561.robot.Robot;
import org.usfirst.frc.team4561.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 * TODO: Document
 * @author TODO
 */
public class RopeClimbDown extends Command {

    public RopeClimbDown() {
        requires(Robot.ropeClimber);
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("ROPE CLIMBER DOWN COMMAND INITIALIZED");
    }
    
	protected void execute() {
		if (RobotMap.ROPE_CLIMB_DOWN_ENABLED) {
			Robot.ropeClimber.setClimber(-.5); //TODO: Change this from half power @Joseph
			System.out.println("ROPE CLIMBER DOWN COMMAND INITIALIZED");
		}
		else {
			System.out.println("ROPE CLIMB DOWN IS DISABLED");
		}
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
