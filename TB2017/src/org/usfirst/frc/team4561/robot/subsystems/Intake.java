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
    
    public void intakeBall(double power) {
    	System.out.println("Intake: function intakeBall called with speed " + power);
    	if (power > 1) {
    		System.out.println("Intake: Oops!  Speed was too high, changing to an acceptable value.");
    		power = 1;
    	}
    	if (power < -1) {
    		System.out.println("Intake: Oops!  Speed was too low, changing to an acceptable value.");
    		power = -1;
    	}
		leftIntakeMotor.set(power);
		rightIntakeMotor.set(power);
	}
    
    public void stop() {
    	System.out.println("Intake: Stopping intake motors...");
    	leftIntakeMotor.set(0);
		rightIntakeMotor.set(0);
    }
}