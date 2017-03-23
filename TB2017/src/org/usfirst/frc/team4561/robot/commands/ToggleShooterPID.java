package org.usfirst.frc.team4561.robot.commands;

import org.usfirst.frc.team4561.robot.Robot;
import org.usfirst.frc.team4561.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class ToggleShooterPID extends Command {
	
	protected void initialize(){
		if (RobotMap.SHOOTER_VERBOSE){
			System.out.println("[SHOOTER] Shooter PID off");
		}
	}

	protected void execute(){
		Robot.shooter.switchToManual();
	}
	
	protected void interrupted(){
		Robot.shooter.switchToPID();
	}
	
	@Override
	protected boolean isFinished() {
		return true;
	}

}
