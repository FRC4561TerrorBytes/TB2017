package org.usfirst.frc.team4561.robot.subsystems;

import org.usfirst.frc.team4561.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *@author alekj
 */
public class Shooter extends Subsystem {
	
	//Shooter Motors
	public CANTalon shootMotorLeft = new CANTalon(RobotMap.SHOOTER_LEFT_MOTOR_PORT);
	public CANTalon shootMotorRight = new CANTalon(RobotMap.SHOOTER_RIGHT_MOTOR_PORT);
	
	//verbose flag
	private boolean verbose = RobotMap.SHOOTER_VERBOSE;
	
	public Shooter(){
		shootMotorRight.changeControlMode(CANTalon.TalonControlMode.Follower);
		shootMotorRight.set(RobotMap.SHOOTER_LEFT_MOTOR_PORT);
	}
	
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