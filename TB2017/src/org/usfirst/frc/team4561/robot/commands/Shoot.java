package org.usfirst.frc.team4561.robot.commands;


import org.usfirst.frc.team4561.robot.Robot;
import org.usfirst.frc.team4561.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class Shoot extends Command {
	
	//Speed variable
	private double power = 0.15;
	
	public Shoot() {
		requires(Robot.shooter);
		setInterruptible(false);
	}
	
	// Called just before this Command runs the first time
    protected void initialize() {
		if (RobotMap.SHOOTER_VERBOSE) {
			System.out.println("[Command] Initialized Shoot for power " + Double.toString(power));
		}
    }
	protected void execute() {
		Robot.shooter.shootAtPercent(0.71); // Run the shooter at the default speed
	}
	
	protected boolean isFinished() {
		return false; // Only stop this command when interrupted, which happens when the shooter off button is pressed
	}
	
	protected void end() {
		Robot.shooter.stop();
		if (RobotMap.SHOOTER_VERBOSE) {
			System.out.println("[Command] Ending Shoot");
		}
	}
	
    protected void interrupted() {
    	end();
    }

}
