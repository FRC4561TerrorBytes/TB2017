package org.usfirst.frc.team4561.robot.subsystems;

import org.usfirst.frc.team4561.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * TODO: Document
 * @author Ben G & Joseph A
 */
public class Agitator extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	/*
	 * To be put in RobotMap.java:
	 * public static final int AGITATOR_MOTOR_PORT = 0;
	 */
	private CANTalon agitatorMotor = new CANTalon(RobotMap.AGITATOR_MOTOR_PORT);
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public void startAgitator(double power) {
		agitatorMotor.set(power);
	}
    
    public void stop() {
    	agitatorMotor.set(0);
    }
}