package org.usfirst.frc.team4561.robot.commands;

import org.usfirst.frc.team4561.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ToggleDriveTrainPIDOff extends Command {

	protected void execute(){
		Robot.driveTrain.switchToManual();
		}
	
	@Override
	protected boolean isFinished() {
		return true;
	}

}
