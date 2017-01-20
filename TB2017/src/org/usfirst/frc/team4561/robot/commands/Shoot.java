package org.usfirst.frc.team4561.robot.commands;


import org.usfirst.frc.team4561.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Shoot extends Command 
{
	private final double speed = 1;
	public Shoot()
	{
		requires(Robot.shooter);
	}
	
	protected void execute()
	{
		Robot.shooter.shootAtSpeed(speed);
	}
	
	protected void stop()
	{
		Robot.shooter.shootAtSpeed(0);
	}
	
	protected boolean isFinished()
	{
		return false;
	}

}
