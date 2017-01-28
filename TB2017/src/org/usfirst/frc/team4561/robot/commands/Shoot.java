package org.usfirst.frc.team4561.robot.commands;


import org.usfirst.frc.team4561.robot.Robot;
import org.usfirst.frc.team4561.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class Shoot extends Command 
{
	//Speed variable
	private final double speed = 1;
	
	//Debug flag
	private  boolean verbose = RobotMap.SHOOTER_VERBOSE;
	
	public Shoot()
	{
		requires(Robot.shooter); //Don't run this command if the shooter doesn't exist
		if (verbose){
			System.out.println("[COMMAND] Created Shoot Command");
		}
	}
	
	// Called just before this Command runs the first time
    protected void initialize() {    
    
    }
	protected void execute()
	{
		Robot.shooter.shootAtSpeed(speed); //Run the shooter at the default speed
		if (verbose){
			System.out.print("[COMMAND] Running shooter at speed ");
			System.out.println(speed);
		}
	}
	
	protected void end()
	{
		Robot.shooter.shootAtSpeed(0); //Stop the shooter
		if (verbose){
			System.out.println("[COMMAND] Stopping Shooter");
		}
	}
	
	protected boolean isFinished()
	{
		return false; //The shooter is never finished! (Only stop this command when interrupted, which happens when the button is released)
	}
	
    protected void interrupted() {
    	end();
    }

}
