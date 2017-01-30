package org.usfirst.frc.team4561.robot.subsystems;

import org.usfirst.frc.team4561.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * TODO: Document
 * @author Ben G
 */
public class Agitator extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private CANTalon agitatorMotor = new CANTalon(RobotMap.AGITATOR_MOTOR_PORT);
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    /**
     * Function to run agitator at a certain power
     * @param power
     */
    public void setPower(double power) {
    	if (power > 1) {
    		if (RobotMap.AGITATOR_VERBOSE) {
    			System.out.println("[Subsystem] Power set too high: " + power + ", changed to full forward");
    		}
    		power = 1;
    	} else if (power < -1) {
    		if (RobotMap.AGITATOR_VERBOSE) {
    			System.out.println("[Subsystem] Power set too low: " + power + ", changed to full reverse");
    		}
    		power = -1;
    	}
		agitatorMotor.set(power);
	}
    
    /**
     * Function to stop agitator motor
     */
    public void stop() {
    	agitatorMotor.set(0);
    }
}