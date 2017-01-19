package org.usfirst.frc.team4561.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4561.robot.RobotMap;
import org.usfirst.frc.team4561.robot.commands.ArcadeDrive;
import org.usfirst.frc.team4561.robot.commands.TankDrive;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive; 

/**
 * TODO: Document
 * @author Jonah W
 */
public class DriveTrain extends Subsystem {
	
	private CANTalon frontRight = new CANTalon(RobotMap.FRONT_RIGHT_MOTOR_PORT);		// Sets front motor ports
	private CANTalon frontLeft = new CANTalon(RobotMap.FRONT_LEFT_MOTOR_PORT);
	
	private CANTalon midRight = new CANTalon(RobotMap.MID_RIGHT_MOTOR_PORT);
	private CANTalon midLeft = new CANTalon(RobotMap.MID_LEFT_MOTOR_PORT);
	
	private CANTalon rearRight = new CANTalon(RobotMap.REAR_RIGHT_MOTOR_PORT);			// Sets rear motor ports
	private CANTalon rearLeft = new CANTalon(RobotMap.REAR_LEFT_MOTOR_PORT);
	
	private RobotDrive robotDrive = new RobotDrive(frontLeft, frontRight);				// Puts motors into RobotDrive class
	
	public DriveTrain() {
		midRight.changeControlMode(CANTalon.TalonControlMode.Follower);					// Sets other motors as slaves to masters FrontLeft/Right
		midRight.set(RobotMap.FRONT_RIGHT_MOTOR_PORT);
		
		rearRight.changeControlMode(CANTalon.TalonControlMode.Follower);
		rearRight.set(RobotMap.FRONT_RIGHT_MOTOR_PORT);
		
		midLeft.changeControlMode(CANTalon.TalonControlMode.Follower);
		midLeft.set(RobotMap.FRONT_LEFT_MOTOR_PORT);
		
		rearLeft.changeControlMode(CANTalon.TalonControlMode.Follower);
		rearLeft.set(RobotMap.FRONT_LEFT_MOTOR_PORT);
	}
    
	public void initDefaultCommand() {
		setDefaultCommand(new TankDrive());
    }
	
	public void arcadeDrive(double drive, double rot) {
		robotDrive.arcadeDrive(drive, rot);
	}
	
	public void tankDrive(double x, double y) { // TODO: These parameter names are inaccurate
		robotDrive.tankDrive(x, y);
	}
	
	// TODO: Create setter methods for motor power
}         