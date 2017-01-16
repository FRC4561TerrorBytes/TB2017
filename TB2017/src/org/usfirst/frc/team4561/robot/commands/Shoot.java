package org.usfirst.frc.team4561.robot.commands;


import org.usfirst.frc.team4561.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Shoot extends Command {
	
	public Shoot(){
		requires(Robot.shooter);
	}
	
	protected void execute(){
		Robot.shooter.ShootLeft.set(255);
		Robot.shooter.ShootRight.set(255);
	}
	protected void stop(){
		Robot.shooter.ShootLeft.set(0);
		Robot.shooter.ShootRight.set(0);
	}
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
