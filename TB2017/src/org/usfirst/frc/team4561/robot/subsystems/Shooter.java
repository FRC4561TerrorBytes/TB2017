package org.usfirst.frc.team4561.robot.subsystems;

import org.usfirst.frc.team4561.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *@author alekj, Zane
 */
public class Shooter extends Subsystem {
	
	//Shooter Motors
	public TalonSRX shootMotorLeft = new TalonSRX(RobotMap.SHOOTER_LEFT_MOTOR_PORT);
	public TalonSRX ShootMotorRight = new TalonSRX(RobotMap.SHOOTER_RIGHT_MOTOR_PORT);
	
	//verbose flag
	private boolean verbose = RobotMap.SHOOTER_VERBOSE;
	
    public void initDefaultCommand() {
    }
    
    public void shootAtSpeed(double speed){
    	
    	//If a valid value, run the shooter motor at the given speed
    	if (speed <= 1.0 && speed >= -1.0) {
    		shootMotorLeft.set(ControlMode.Follower, speed);
    		ShootMotorRight.set(ControlMode.Follower, -speed);
    		if (verbose) {
    			System.out.print("[Subsystem] Running Shooter Motors at speed " + speed);
    		}
    	}
    	else if (verbose) {
    		System.out.println("[Subsystem] Did not run Shooter Motors, given speed was invalid");
    	}
    }
    
    public void stop() {
    	shootMotorLeft.set(ControlMode.Follower, 0);
    	ShootMotorRight.set(ControlMode.Follower, 0);
    }	
}