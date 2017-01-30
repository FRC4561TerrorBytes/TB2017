package org.usfirst.frc.team4561.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4561.robot.RobotMap;
import org.usfirst.frc.team4561.robot.commands.DriveTank;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;

/**
 * TODO: Document
 * @author Jonah W
 */
public class DriveTrain extends Subsystem {
	
	// Front motors are masters
	private CANTalon frontRight;
	private CANTalon frontLeft;
	
	private CANTalon midRight;
	private CANTalon midLeft;
	
	private CANTalon rearRight;
	private CANTalon rearLeft;
		
	private RobotDrive robotDrive;
	
	public void initDefaultCommand() {
		setDefaultCommand(new DriveTank());
    }
	
	public DriveTrain() {
		frontRight = new CANTalon(RobotMap.FRONT_RIGHT_MOTOR_PORT);
		frontLeft = new CANTalon(RobotMap.FRONT_LEFT_MOTOR_PORT);
		
		midRight = new CANTalon(RobotMap.MID_RIGHT_MOTOR_PORT);
		
		// Sets other motors as slaves to masters FrontLeft/Right, set doesn't set power, it sets a slave
		midRight.changeControlMode(CANTalon.TalonControlMode.Follower);
		midRight.set(RobotMap.FRONT_RIGHT_MOTOR_PORT);
		
		rearRight = new CANTalon(RobotMap.REAR_RIGHT_MOTOR_PORT);
		rearRight.changeControlMode(CANTalon.TalonControlMode.Follower);
		rearRight.set(RobotMap.FRONT_RIGHT_MOTOR_PORT);
		
		midLeft = new CANTalon(RobotMap.MID_LEFT_MOTOR_PORT);
		midLeft.changeControlMode(CANTalon.TalonControlMode.Follower);
		midLeft.set(RobotMap.FRONT_LEFT_MOTOR_PORT);
		
		rearLeft = new CANTalon(RobotMap.REAR_LEFT_MOTOR_PORT);
		rearLeft.changeControlMode(CANTalon.TalonControlMode.Follower);
		rearLeft.set(RobotMap.FRONT_LEFT_MOTOR_PORT);
		
		// Puts motors into RobotDrive class
		robotDrive = new RobotDrive(frontLeft, frontRight);

	}
    
	/**
	 * TODO: Document
	 * @param powerLeft
	 * @param powerRight
	 */
	public void setMotorPower(double powerLeft, double powerRight) {
		if (powerLeft > 1) {
			if (RobotMap.DRIVETRAIN_VERBOSE) {
				System.out.println("[Subsystem] Power to left side of drivetrain was set too high: " + powerLeft + ", changing to full forward.");
			}
			powerLeft = 1;
		} else if (powerLeft < -1) {
			if (RobotMap.DRIVETRAIN_VERBOSE) {
				System.out.println("[Subsystem] Power to left side of drivetrain was set too low: " + powerLeft + ", changing to full reverse.");
			}
			powerLeft = -1;
		}
		if (powerRight > 1) {
			if (RobotMap.DRIVETRAIN_VERBOSE) {
				System.out.println("[Subsystem] Power to right side of drivetrain was set too high: " + powerRight + ", changing to full forward.");
			}
			powerRight = 1;
		} else if (powerRight < -1) {
			if (RobotMap.DRIVETRAIN_VERBOSE) {
				System.out.println("[Subsystem] Power to right side of drivetrain was set too low: " + powerRight + ", changing to full reverse.");
			}
			powerLeft = -1;
		}
		frontRight.set(powerRight);
		frontLeft.set(powerLeft);
	}
	
	/**
	 * TODO: Document
	 * @param drive
	 * @param rot
	 */
	public void arcadeDrive(double drive, double rot) {
		robotDrive.arcadeDrive(drive, rot);
	}
	
	/**
	 * TODO: Document
	 * @param leftpower
	 * @param rightpower
	 */
	public void tankDrive(double leftpower, double rightpower) {
		robotDrive.tankDrive(leftpower, rightpower);
	}
}