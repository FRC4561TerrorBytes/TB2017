package org.usfirst.frc.team4561.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team4561.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

/**
 * TODO: Document
 * @author Ben G, Zane
 */
public class Intake extends Subsystem {
	
	// Declaring two objects of type CANTalon called leftIntakeMotor and rightIntakeMotor
	private TalonSRX leftIntakeMotor = new TalonSRX(RobotMap.LEFT_INTAKE_MOTOR_PORT);
	private TalonSRX rightIntakeMotor = new TalonSRX(RobotMap.RIGHT_INTAKE_MOTOR_PORT);

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
		leftIntakeMotor.set(ControlMode.Follower, power);
		rightIntakeMotor.set(ControlMode.Follower, power);
	}
    
    /**
     * TODO: Document
     */
    public void stop() {
    	leftIntakeMotor.set(ControlMode.Follower, 0);
		rightIntakeMotor.set(ControlMode.Follower, 0);
    }
}