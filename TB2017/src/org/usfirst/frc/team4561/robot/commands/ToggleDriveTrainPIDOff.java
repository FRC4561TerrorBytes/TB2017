package org.usfirst.frc.team4561.robot.commands;

import org.usfirst.frc.team4561.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ToggleDriveTrainPIDOff extends Command {

	protected void initialize(){
		Robot.driveTrain.switchToPower();
	}
	
	@Override
	protected boolean isFinished() {
		return true;
	}

}
