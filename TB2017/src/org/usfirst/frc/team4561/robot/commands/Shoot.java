package org.usfirst.frc.team4561.robot.commands;


import org.usfirst.frc.team4561.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Shoot extends Command 
{
	//Speed variable
	private final double speed = 1;
	
	//Debug flag
	private  boolean debug = false/*RobotMap.isDebug*/; //TODO: Centralize debug flag
	
	public Shoot()
	{
		requires(Robot.shooter); //Don't run this command if the shooter doesn't exist
	}
	
	protected void execute()
	{
		Robot.shooter.shootAtSpeed(speed); //Run the shooter at the default speed
		if (debug){
			System.out.print("[COMMAND] Running shooter at speed ");
			System.out.println(speed);
		}
	}
	
	protected void stop()
	{
		Robot.shooter.shootAtSpeed(0); //Stop the shooter
		if (debug){
			System.out.println("[COMMAND] Stopping Shooter");
		}
	}
	
	protected boolean isFinished()
	{
		return false; //The shooter is never finished! (Only stop this command when interrupted, which happens when the button is released)
	}

}
