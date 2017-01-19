package org.usfirst.frc.team4561.robot.commands;

import org.usfirst.frc.team4561.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * TODO: Document
 * @author TODO
 */
public class Shoot extends Command {
	
	public Shoot() {
		requires(Robot.shooter);
	}
	
	protected void execute() {
		Robot.shooter.setPower(255);
	}
	
	protected void stop() {
		Robot.shooter.stopLeftMotor();
		Robot.shooter.stopRightMotor();
	}
	
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
