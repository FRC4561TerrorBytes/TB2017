package org.usfirst.frc.team4561.robot.subsystems;

import org.usfirst.frc.team4561.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *@author Lucas T
 *EXPERIMENTAL:
 *This subsystem is supposed to be an example subsystem
 *for RoboRIO PID
 */
public class RioPIDShooter extends PIDSubsystem {
	
	private CANTalon leftMotor = new com.ctre.CANTalon(RobotMap.SHOOTER_LEFT_MOTOR_PORT);
	
	private CANTalon rightMotor = new CANTalon(RobotMap.SHOOTER_RIGHT_MOTOR_PORT);
	private static Encoder shooterEncoder = new Encoder(0, 1); // TODO: verify a and b sources
	private final double ENCODER_TICKS = 1024; // TODO: Verify
	private final double DISTANCE_PER_PULSE = 1.0 / ENCODER_TICKS; // Revolutions per tick
	
    // Initialize your subsystem here
    public RioPIDShooter() {
    	super("shooter", 0, 0, 0, 0);
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	return shooterEncoder.getRate();
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	leftMotor.set(output);
		rightMotor.set(-output);
    }
}