package org.usfirst.frc.team4561.robot.commands;


import org.usfirst.frc.team4561.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
/**
 * 
 * @author alekj
 *
 */
public class Shoot extends Command 
{
	private final double speed = 1; //The speed the shooter will run at when the button is pressed
	public Shoot()
	{
		requires(Robot.shooter);
	}
	
	protected void execute()
	{
		Robot.shooter.shootAtSpeed(speed); //Run the shooter motor at the given speed
	}
	
	protected void stop()
	{
		Robot.shooter.shootAtSpeed(0); //Stop the shooter motor
	}
	
	protected boolean isFinished()
	{
		return false;
	}

}
