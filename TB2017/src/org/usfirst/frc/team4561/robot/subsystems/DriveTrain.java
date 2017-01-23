package org.usfirst.frc.team4561.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4561.robot.RobotMap;
import org.usfirst.frc.team4561.robot.commands.TankDrive;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive; 

/**
 * TODO: Document
 * @author Jonah W
 */
public class DriveTrain extends Subsystem {
	
	private CANTalon frontRight = new CANTalon(RobotMap.FRONT_RIGHT_MOTOR_PORT);		// Sets front motor ports
	private CANTalon frontLeft = new CANTalon(RobotMap.FRONT_LEFT_MOTOR_PORT);			//front motors are masters
	
	private CANTalon midRight = new CANTalon(RobotMap.MID_RIGHT_MOTOR_PORT);
	private CANTalon midLeft = new CANTalon(RobotMap.MID_LEFT_MOTOR_PORT);
	
	private CANTalon rearRight = new CANTalon(RobotMap.REAR_RIGHT_MOTOR_PORT);			// Sets rear motor ports
	private CANTalon rearLeft = new CANTalon(RobotMap.REAR_LEFT_MOTOR_PORT);
	
	private RobotDrive robotDrive = new RobotDrive(frontLeft, frontRight);				// Puts motors into RobotDrive class
	
	public DriveTrain() {
		midRight.changeControlMode(CANTalon.TalonControlMode.Follower);					// Sets other motors as slaves to masters FrontLeft/Right
		midRight.set(RobotMap.FRONT_RIGHT_MOTOR_PORT);									//set doesn't set power, it sets a slave
		
		rearRight.changeControlMode(CANTalon.TalonControlMode.Follower);				//TODO: move all of the followers to robot init in robot
		rearRight.set(RobotMap.FRONT_RIGHT_MOTOR_PORT);
		
		midLeft.changeControlMode(CANTalon.TalonControlMode.Follower);
		midLeft.set(RobotMap.FRONT_LEFT_MOTOR_PORT);
		
		rearLeft.changeControlMode(CANTalon.TalonControlMode.Follower);
		rearLeft.set(RobotMap.FRONT_LEFT_MOTOR_PORT);
	}
    
	public void setMotorPower(double powerLeft, double powerRight) {			//debug to make sure power isn't too high or low
		if (powerLeft <= 1 && powerLeft >= -1) {
			frontLeft.set(powerLeft);
		}
		else {
			System.out.println("WARNING: Power to left side of drivetrain was set to: " + powerLeft);	//gives a warning and changes power to safe level
		}
		
		if (powerRight <= 1 && powerRight >= -1) {
			frontRight.set(powerRight);
		}
		else {
			System.out.println("WARNING: Power to right side of drivetrain was set to: " + powerLeft);
		}
	}
	
	//TODO: JONAH W - method for debug, meant to compliment setter method 
	/*public void getMotorPower(boolean motorLeft){
		
		double powerLeft, powerRight;
		if (motorLeft){
			frontLeft.get(powerLeft);
			return(powerLeft);
		}
		else	{
			frontRight.get(powerRight);
			return(powerRight);
		}
	}*/
	
	public void initDefaultCommand() {
		setDefaultCommand(new TankDrive());
    }
	
	public void arcadeDrive(double drive, double rot) {
		robotDrive.arcadeDrive(drive, rot);
	}
	
	public void tankDrive(double leftpower, double rightpower) {
		robotDrive.tankDrive(leftpower, rightpower);
	}
}