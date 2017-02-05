package org.usfirst.frc.team4561.robot.commands;

import org.usfirst.frc.team4561.robot.Robot;
import org.usfirst.frc.team4561.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;

import edu.wpi.first.wpilibj.command.Command;

public class ShootPID extends Command {
	
	double speedGoal = 1; //TODO: Delete This

	public ShootPID(){
		super();
		requires(Robot.shooter);
		//TODO: Put below code into shooter subsystem
		//TODO: MOVING THIS CODE TO SHOOTER SUBSYSTEM WILL MAKE THE SHOOTER SUBSYSTEM CONTROLLED SOLELY BY PID
		//Set left motor to always mirror right motor
		Robot.shooter.shootMotorLeft.changeControlMode(CANTalon.TalonControlMode.Follower);
		Robot.shooter.shootMotorLeft.set(RobotMap.SHOOTER_RIGHT_MOTOR_PORT);
		Robot.shooter.shootMotorLeft.reverseOutput(true);
		//Set the sensor for the right motor
		Robot.shooter.ShootMotorRight.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		Robot.shooter.ShootMotorRight.reverseSensor(false);
		//Set PIDF values for right motor
		Robot.shooter.ShootMotorRight.setProfile(0);
		Robot.shooter.ShootMotorRight.setF(0);
		Robot.shooter.ShootMotorRight.setP(0);
		Robot.shooter.ShootMotorRight.setI(0);
		Robot.shooter.ShootMotorRight.setD(0);
		//Set throttle limits for right motor
		Robot.shooter.ShootMotorRight.configNominalOutputVoltage(+0.0f, -0.0f);
		Robot.shooter.ShootMotorRight.configPeakOutputVoltage(+12.0f, +0.0f); //The shooter will always either be stopped or going forwards
	}
	public void execute(){
		/*Robot.shooter.*/speedGoal = 1; //TODO: Delete this line when PID setup migrated to shooter subsystem
		/*Robot.shooter.*/setShooterSpeedPID(1);
	}
	public void setShooterSpeedPID(double speed){ //TODO: Put this method into shooter subsystem
		if (!((speed*speed)>speed)){ //Only set speed if speed is positive and not greater than one (speed^2 is not greater than speed)
			Robot.shooter.ShootMotorRight.set(speed);
		}
	}
	public void interrupted(){
		end();
	}
	public void end(){
		/*Robot.shooter.*/speedGoal = 0; //TODO: Delete this line when PID setup migrated to shooter subsystem
		/*Robot.shooter.*/setShooterSpeedPID(0);
	}
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}