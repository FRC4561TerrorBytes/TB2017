package org.usfirst.frc.team4561.robot.subsystems;

import org.usfirst.frc.team4561.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *@author alekj and Jonah W
 */
public class ShooterPID extends Subsystem {

	public CANTalon shootMotorLeft = new CANTalon(RobotMap.SHOOTER_LEFT_MOTOR_PORT);
	public CANTalon ShootMotorRight = new CANTalon(RobotMap.SHOOTER_RIGHT_MOTOR_PORT);
		
	public ShooterPID(){
		super();
		shootMotorLeft.changeControlMode(CANTalon.TalonControlMode.Follower);
		shootMotorLeft.set(RobotMap.SHOOTER_RIGHT_MOTOR_PORT);
		shootMotorLeft.reverseOutput(true);
		ShootMotorRight.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		ShootMotorRight.reverseSensor(false);
		ShootMotorRight.setProfile(0);
		ShootMotorRight.setF(0);
		ShootMotorRight.setP(0);
		ShootMotorRight.setI(0);
		ShootMotorRight.setD(0);
		ShootMotorRight.configNominalOutputVoltage(+0.0f, -0.0f);
		ShootMotorRight.configPeakOutputVoltage(+12.0f, +0.0f); //The shooter will always either be stopped or going forwards
	}
	

	//verbose flag
	private boolean verbose = RobotMap.SHOOTER_VERBOSE;
	
    public void initDefaultCommand() {
    }
    
    public void shootAtSpeed(double speed){
    	
    	//If a valid value, run the shooter motor at the given speed
    	if (speed <= 1.0 && speed >= -1.0) {
    		ShootMotorRight.set(-speed);
    		if (verbose) {
    			System.out.print("[Subsystem] Running Shooter Motors at speed " + speed);
    		}
    	}
    	else if (verbose) {
    		System.out.println("[Subsystem] Did not run Shooter Motors, given speed was invalid");
    	}
    }
    
    public void stop() {
    	ShootMotorRight.set(0);
    }	
}