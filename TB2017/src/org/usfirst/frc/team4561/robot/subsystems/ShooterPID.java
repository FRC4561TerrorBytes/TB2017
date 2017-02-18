package org.usfirst.frc.team4561.robot.subsystems;

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

	public ShooterPID(){
		super();
		shootMotorRight.changeControlMode(CANTalon.TalonControlMode.Follower);
		shootMotorRight.set(RobotMap.SHOOTER_LEFT_MOTOR_PORT);
		shootMotorLeft.changeControlMode(TalonControlMode.Speed);
		shootMotorLeft.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		shootMotorLeft.reverseSensor(false);
		shootMotorLeft.setProfile(0);
		shootMotorLeft.setF(0);
		shootMotorLeft.setP(0);
		shootMotorLeft.setI(0);
		shootMotorLeft.setD(0);
		shootMotorLeft.configNominalOutputVoltage(+0.0f, -0.0f);
		shootMotorLeft.configPeakOutputVoltage(+12.0f, +0.0f); //The shooter will always either be stopped or going forwards
	}
	
	//sends motor velocity to robot.java for debug
	public double rightEncoderVel() {
		return shootMotorRight.getEncVelocity();
	}
	
	//verbose flag
	private boolean verbose = RobotMap.SHOOTER_VERBOSE;
	
    public void initDefaultCommand() {
    }
    
    public void shootAtSpeed(double speed){
    	
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
    }
    
    public void stop() {
    	shootMotorLeft.set(0);
    }	
}