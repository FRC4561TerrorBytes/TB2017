package org.usfirst.frc.team4561.robot.commands;

import org.usfirst.frc.team4561.robot.Robot;
import org.usfirst.frc.team4561.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveTankTimed extends Command {

	double leftpower;
	double rightpower;
	double seconds;
	
    public DriveTankTimed(double left, double right, double seconds) {
        requires(Robot.driveTrain);
        setTimeout(seconds);
    }
    

    // Called just before this Command runs the first time
    protected void initialize() {
    	if (RobotMap.DRIVETRAIN_VERBOSE) {
    		System.out.println("[Command] Intializing DriveTankTimed for " + seconds + " seconds");
    	}
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		Robot.driveTrain.tankDrive(leftpower, rightpower);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	if(RobotMap.DRIVETRAIN_VERBOSE) {
    		System.out.println("Stopping DriveTankTimed");
    	}
    	Robot.driveTrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
