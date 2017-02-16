package org.usfirst.frc.team4561.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4561.robot.RobotMap;
import org.usfirst.frc.team4561.robot.commands.DriveArcade;
import org.usfirst.frc.team4561.robot.commands.DriveArcadeTwoStick;
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
		setDefaultCommand(new DriveArcadeTwoStick());
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
		
		frontRight.setInverted(true);
		midRight.setInverted(true);
		rearRight.setInverted(true);
		
		// Puts motors into RobotDrive class
		robotDrive = new RobotDrive(frontLeft, frontRight);
	}
    
	/**
	 * TODO: Document
	 * @param powerLeft
	 * @param powerRight
	 * @see {@link #setLeftMotorPower(double) setLeftMotorPower}, {@link #setRightMotorPower(double) setRightMotorPower}
	 */
	public void setMotorPower(double powerLeft, double powerRight) {
		setLeftMotorPower(powerLeft);
		setRightMotorPower(powerRight);
	}
	
	/**
	 * Sets power to the left side of the Drive Train.
	 * @param power to set the motors to.
	 * @see {@link #setRightMotorPower(double) setRightMotorPower}, {@link #setMotorPower(double, double) setMotorPower}
	 */
	public void setLeftMotorPower(double power) {
		if (power > 1) {
			if (RobotMap.DRIVETRAIN_VERBOSE) {
				System.out.println("[Subsystem] Power to left side of drivetrain was set too high: " + power + ", changing to full forward.");
			}
			power = 1;
		} else if (power < -1) {
			if (RobotMap.DRIVETRAIN_VERBOSE) {
				System.out.println("[Subsystem] Power to left side of drivetrain was set too low: " + power + ", changing to full reverse.");
			}
			power = -1;
		}
		frontLeft.set(power);
	}
	
	/**
	 * Sets power to the right side of the Drive Train.
	 * @param power to set the motors to.
	 * @see {@link #setLeftMotorPower(double) setLeftMotorPower}, {@link #setMotorPower(double, double) setMotorPower}
	 */
	public void setRightMotorPower(double power) {
		if (power > 1) {
			if (RobotMap.DRIVETRAIN_VERBOSE) {
				System.out.println("[Subsystem] Power to right side of drivetrain was set too high: " + power + ", changing to full forward.");
			}
			power = 1;
		} else if (power < -1) {
			if (RobotMap.DRIVETRAIN_VERBOSE) {
				System.out.println("[Subsystem] Power to right side of drivetrain was set too low: " + power + ", changing to full reverse.");
			}
			power = -1;
		}
		frontRight.set(power);
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
	
	/**
	 * Stops the drivetrain.
	 * @see {@link #stopLeft() stopLeft}, {@link #stopRight() stopRight}
	 * @author Kaiz
	 */
	public void stop() {
		stopLeft();
		stopRight();
	}
	
	/**
	 * Stops the left side of the drivetrain.
	 * @see {@link #stop() stop}, {@link #stopRight() stopRight}
	 * @author Kaiz
	 */
	public void stopLeft() {
		frontLeft.set(0);
	}
	
	/**
	 * Stops the right side of the drivetrain.
	 * @see {@link #stop() stop}, {@link #stopLeft() stopLeft}
	 * @author Kaiz
	 */
	public void stopRight() {
		frontRight.set(0);
	}
}