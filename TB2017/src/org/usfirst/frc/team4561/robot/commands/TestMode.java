package org.usfirst.frc.team4561.robot.commands;

import org.usfirst.frc.team4561.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Sets the power to a motor (or a group of them) for testing. 
 * Throttle on the left joystick controls speed of the motor.
 * The motor driven by pressing the left joystick triggered is determined by the value on the last slider of the Dashboard.<br>
 * 0 - Drivetrain left<br>
 * 1 - Drivetrain right<br>
 * 2 - Shooter<br>
 * 3 - Agitator<br>
 * 4 - Rope climber
 * @author Kaiz
 */
public class TestMode extends Command {
	
	int motor;
	int motorOld;
	
    public TestMode() {
    	motor = (int)Robot.oi.getDashboardSlider1();
    	System.out.println("Starting Test Mode");
    	// Requires whichever subsystem the method being invoked is in
    	switch (motor) {
    		case 0:
    		case 1:
    			requires(Robot.driveTrain);
    			break;
    		case 2:
    			requires(Robot.shooter);
    			break;
    		case 3:
    			requires(Robot.agitator);
    			break;
    		case 4:
    			requires(Robot.ropeClimber);
    			break;
    	}
    	motorOld = motor;
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	motor = (int)Robot.oi.getDashboardSlider1();
    	switch (motor) {
			case 0:
				Robot.driveTrain.setLeftMotorPower(Robot.oi.getLeftStickThrottle());
			case 1:
				Robot.driveTrain.setRightMotorPower(Robot.oi.getLeftStickThrottle());
			case 2:
				Robot.shooter.switchToManual();
				Robot.shooter.shootAtSpeed(Robot.oi.getLeftStickThrottle());
			case 3:
				Robot.agitator.setPower(Robot.oi.getLeftStickThrottle());
			case 4:
				Robot.ropeClimber.setClimber(Robot.oi.getLeftStickThrottle());
    	}
    	if (motor != motorOld){
    		System.out.println(motor); 
    	}
    	motorOld = motor;

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	switch (motor) {
			case 0:
				Robot.driveTrain.stopLeft();
			case 1:
				Robot.driveTrain.stopRight();
			case 2:
				Robot.shooter.stop();
			case 3:
				Robot.agitator.stop();
			case 4:
				Robot.ropeClimber.stop();
    	}
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
