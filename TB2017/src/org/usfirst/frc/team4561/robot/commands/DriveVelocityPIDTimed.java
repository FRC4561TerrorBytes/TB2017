package org.usfirst.frc.team4561.robot.commands;

import org.usfirst.frc.team4561.robot.Robot;
import org.usfirst.frc.team4561.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveVelocityPIDTimed extends Command {

	double leftVel;
	double rightVel;
	double seconds;
	
    public DriveVelocityPIDTimed(double leftVel, double rightVel, double seconds) {
        requires(Robot.driveTrain);
        this.leftVel = leftVel;
        this.rightVel = rightVel;
        this.seconds = seconds;
        setTimeout(seconds);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if (RobotMap.DRIVETRAIN_VERBOSE) {
    		System.out.println("[Command] Intializing DriveVelocityPIDTimed for " + seconds + " seconds");
    	}
    	Robot.driveTrain.tankDrive(leftVel, rightVel);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
