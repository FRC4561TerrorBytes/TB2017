package org.usfirst.frc.team4561.robot.commands;

import org.usfirst.frc.team4561.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ToggleDriveTrainPIDOn extends Command {

	protected void initialize(){
		Robot.driveTrain.switchToVelocity();
	}
	
	@Override
	protected boolean isFinished() {
		return true;
	}

}
