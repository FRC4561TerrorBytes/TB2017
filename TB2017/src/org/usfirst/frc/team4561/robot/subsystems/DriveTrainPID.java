package org.usfirst.frc.team4561.robot.subsystems;

import org.usfirst.frc.team4561.robot.RobotMap;
import org.usfirst.frc.team4561.robot.commands.DriveArcadeTwoStick;
import org.usfirst.frc.team4561.robot.commands.DriveTank;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * This is a drivetrain variant with both positional pid, for automode,
 * and velocity pid, for tele-op.
 * @author Jonah W and Alek L
 */

public class DriveTrainPID extends Subsystem {

	//Front motors are masters
	private CANTalon frontRight;
	private CANTalon frontLeft;
	
	private CANTalon midRight;
	private CANTalon midLeft;
	
	private CANTalon rearRight;
	private CANTalon rearLeft;
		
	public RobotDrive robotDrive;
	
	//TODO: Get max wanted RPM
	int ticksPer100MS = 95000; //RPM at full speed
	
	public void initDefaultCommand() {
		setDefaultCommand(new DriveArcadeTwoStick());
    }
	
	public DriveTrainPID() {
		
		frontRight = new CANTalon(RobotMap.FRONT_RIGHT_MOTOR_PORT);		//new right cantalon
		
		frontRight.setFeedbackDevice(FeedbackDevice.QuadEncoder);		//right cantalon uses a quadencoder
		frontRight.reverseSensor(false);
		frontRight.setProfile(0);
		

		frontRight.configNominalOutputVoltage(+0.0f, -0.0f);			//sets min and max voltages
		frontRight.configPeakOutputVoltage(+12.0f, -12.0f);
	
		
		frontLeft = new CANTalon(RobotMap.FRONT_LEFT_MOTOR_PORT);		//new left cantalon
		frontLeft.setCurrentLimit(10);
		frontLeft.EnableCurrentLimit(true);
		frontLeft.setFeedbackDevice(FeedbackDevice.QuadEncoder);		//left cantalon uses a quadencoder
		frontLeft.reverseSensor(false);
		frontLeft.setProfile(0);
		
		frontLeft.configNominalOutputVoltage(+0.0f, -0.0f);				//sets min and max voltages
		frontLeft.configPeakOutputVoltage(+12.0f, -12.0f);
		
		frontRight.changeControlMode(TalonControlMode.Position);	//changes talons to positional pid mode
		frontLeft.changeControlMode(TalonControlMode.Position);
		
		midRight = new CANTalon(RobotMap.MID_RIGHT_MOTOR_PORT);			//new right cantalon
		
		// Sets other motors as slaves to masters FrontLeft/Right, set doesn't set power, it sets a slave
		midRight.changeControlMode(CANTalon.TalonControlMode.Follower);
		midRight.set(RobotMap.FRONT_RIGHT_MOTOR_PORT);
		
		rearRight = new CANTalon(RobotMap.REAR_RIGHT_MOTOR_PORT);		//new right cantalon
		rearRight.changeControlMode(CANTalon.TalonControlMode.Follower);
		rearRight.set(RobotMap.FRONT_RIGHT_MOTOR_PORT);
		
		midLeft = new CANTalon(RobotMap.MID_LEFT_MOTOR_PORT);			//new left cantalon
		midLeft.changeControlMode(CANTalon.TalonControlMode.Follower);
		midLeft.set(RobotMap.FRONT_LEFT_MOTOR_PORT);
		
		rearLeft = new CANTalon(RobotMap.REAR_LEFT_MOTOR_PORT);			//new left cantalon
		rearLeft.changeControlMode(CANTalon.TalonControlMode.Follower);
		rearLeft.set(RobotMap.FRONT_LEFT_MOTOR_PORT);
		
		
		// Puts motors into RobotDrive class
		robotDrive = new RobotDrive(frontLeft, frontRight);	
		
		SwitchToVelocity();
	}
	
	public void SwitchToVelocity(){
		frontRight.changeControlMode(TalonControlMode.Speed);	//changes talons to velocity pid mode
		frontLeft.changeControlMode(TalonControlMode.Speed);
		frontRight.setF(1023/ticksPer100MS);
		frontRight.setP(.25);
		frontRight.setI(0);
		frontRight.setD(0);
	
		frontLeft.setF(1023/ticksPer100MS);
		frontLeft.setP(0.25);
		frontLeft.setI(0);
		frontLeft.setD(0);
	}

	public void SwitchToPositional(){
		frontRight.changeControlMode(TalonControlMode.Position);	//changes talons to positional pid mode
		frontLeft.changeControlMode(TalonControlMode.Position);
		frontRight.set(1000);				//set to pos pid testing target position
		frontLeft.set(1000);
	
		frontRight.setF(0);
		frontRight.setP(.25);
		frontRight.setI(0);
		frontRight.setD(0);
	
		frontLeft.setF(0);
		frontLeft.setP(0);
		frontLeft.setI(0);
		frontLeft.setD(0);
	}
/**
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
		} 
	else if (power < -1) {
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
 * @param drive
 * @param rot
 */
	
	public void arcadeDrive(double drive, double rot) {
		double leftMotorSpeed = 0.0;
		double rightMotorSpeed = 0.0;
		if (drive > 0.0) {
		      if (rot > 0.0) {
		        leftMotorSpeed = drive - rot;
		        rightMotorSpeed = Math.max(drive, rot);
		      } else {
		        leftMotorSpeed = Math.max(drive, -rot);
		        rightMotorSpeed = drive + rot;
		      }
		    } else {
		      if (rot > 0.0) {
		        leftMotorSpeed = -Math.max(-drive, rot);
		        rightMotorSpeed = drive + rot;
		      } else {
		        leftMotorSpeed = drive - rot;
		        rightMotorSpeed = -Math.max(-drive, -rot);
		      }
		    }
		frontRight.set((int)ticksPer100MS*rightMotorSpeed);
		frontLeft.set((int)ticksPer100MS*leftMotorSpeed);
	}

/**
 * @param leftpower
 * @param rightpower
 */
	
	public void tankDrive(double leftpower, double rightpower) {
		robotDrive.tankDrive(leftpower, rightpower);
	}

	//The Following methods send values to Robot.java for Debug Mode
	public double leftMotorVel() {
		return frontLeft.getEncVelocity();
	}
	
	public double leftMotorPos() {
		return frontLeft.getEncPosition();
	}
	
	public double rightMotorVel() {
		return frontRight.getEncVelocity();
	}
	
	public double rightMotorPos() {
		return frontRight.getEncPosition();
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

public void switchToManual() {
	stopLeft();
	stopRight();
	frontLeft.changeControlMode(TalonControlMode.PercentVbus);
	frontRight.changeControlMode(TalonControlMode.PercentVbus);
	
}
}