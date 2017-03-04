package org.usfirst.frc.team4561.robot.subsystems;

import org.usfirst.frc.team4561.robot.Robot;
import org.usfirst.frc.team4561.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *@author alekj and Jonah W
 */
public class ShooterPID extends Subsystem {

	private CANTalon shootMotorLeft = new CANTalon(RobotMap.SHOOTER_LEFT_MOTOR_PORT);
	private CANTalon shootMotorRight = new CANTalon(RobotMap.SHOOTER_RIGHT_MOTOR_PORT);

	public ShooterPID() {
		Robot.profilerTest("ShooterPID Start");
		shootMotorRight.changeControlMode(CANTalon.TalonControlMode.Follower);
		shootMotorRight.set(RobotMap.SHOOTER_LEFT_MOTOR_PORT);
		shootMotorLeft.changeControlMode(TalonControlMode.Speed);
		shootMotorLeft.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		shootMotorLeft.reverseSensor(true);
		shootMotorLeft.setF(2.9);
		shootMotorLeft.setP(5);
		shootMotorLeft.setI(0);
		shootMotorLeft.setD(0);
		Robot.profilerTest("ShooterPID End");
	}
	
	public void switchToManual(){
		shootMotorLeft.changeControlMode(TalonControlMode.PercentVbus);
	}
	
	//sends motor velocity to robot.java for debug
	public double getLeftEncoderVelocity() {
		return shootMotorLeft.getEncVelocity();
	}
	
	public double getLeftMotorCurrent() {
		return shootMotorLeft.getOutputVoltage();
	}
	
	//verbose flag
	private boolean verbose = RobotMap.SHOOTER_VERBOSE;
	
    public void initDefaultCommand() {
    }
    
    public void shootAtSpeed(double speed){
		Robot.profilerTest("ShooterSetPower Start");    	
    	//If a valid value, run the shooter motor at the given speed
    	if (speed <= 1.0 && speed >= -1.0) {
    		shootMotorLeft.set(speed);
    		if (verbose) {
    			System.out.print("[Subsystem] Running Shooter Motors at speed " + speed);
    		}
    	}
    	else if (verbose) {
    		System.out.println("[Subsystem] Did not run Shooter Motors, given speed was invalid");
    	}
		Robot.profilerTest("ShooterSetPower End");
    }
    
    public void shootAtPercent(double percent) {
    	percent *= 350;
    	shootMotorLeft.setSetpoint(percent);
    }
    
    public double getSetpoint() {
    	return shootMotorLeft.getSetpoint();
    }
    
    public void stop() {
    	shootAtPercent(0);
    }

	public void switchToPID() {
		shootMotorLeft.changeControlMode(TalonControlMode.Speed);
		
	}
}