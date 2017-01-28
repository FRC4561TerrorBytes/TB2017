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
	
	//verbose flag
	private boolean verbose = RobotMap.INTAKE_VERBOSE;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void intakeBall(double power) {
    	if (power > 1) {
    		if (verbose) {
    			System.out.println("[SUBSYSTEM] SPEED WAS TOO POSITIVE..." + power + " CHANGING TO AN ACCEPTABLE VALUE.");
    		}
    		power = 1;
    	}
    	if (power < -1) {
    		if (verbose) {
    			System.out.println("[SUBSYSTEM] SPEED WAS TOO NEGATIVE... CHANGING TO AN ACCEPTABLE VALUE");
    		}
    		power = -1;
    	}
		leftIntakeMotor.set(power);
		rightIntakeMotor.set(power);
	}
    
    public void stop() {
    	leftIntakeMotor.set(0);
		rightIntakeMotor.set(0);
    }
}