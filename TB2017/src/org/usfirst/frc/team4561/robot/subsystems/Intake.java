package org.usfirst.frc.team4561.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team4561.robot.RobotMap;

import com.ctre.CANTalon;

/**
 * TODO: Document
 * @author Ben G
 */
public class Intake extends Subsystem {
	
	// Declaring two objects of type CANTalon called leftIntakeMotor and rightIntakeMotor
	private CANTalon leftIntakeMotor = new CANTalon(RobotMap.LEFT_INTAKE_MOTOR_PORT);
	private CANTalon rightIntakeMotor = new CANTalon(RobotMap.RIGHT_INTAKE_MOTOR_PORT);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    /**
     * TODO: Document
     * @param power
     */
    public void intakeBall(double power) {
    	if (power > 1) {
    		if (RobotMap.INTAKE_VERBOSE) {
    			System.out.println("[Subsystem] Intake set too high: " + power + ", changing to full forward.");
    		}
    		power = 1;
    	} else if (power < -1) {
    		if (RobotMap.INTAKE_VERBOSE) {
    			System.out.println("[Subsystem] Intake set too low: " + power + ", changing to full reverse.");
    		}
    		power = -1;
    	}
		leftIntakeMotor.set(power);
		rightIntakeMotor.set(power);
	}
    
    /**
     * TODO: Document
     */
    public void stop() {
    	leftIntakeMotor.set(0);
		rightIntakeMotor.set(0);
    }
}