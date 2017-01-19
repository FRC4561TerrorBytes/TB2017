package org.usfirst.frc.team4561.robot.subsystems;

import org.usfirst.frc.team4561.robot.RobotMap;
import org.usfirst.frc.team4561.robot.commands.Shoot;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * TODO: Document
 * @author Alek L
 */
public class Shooter extends Subsystem {
	
	private CANTalon shootLeft = new CANTalon(RobotMap.SHOOTER_LEFT_MOTOR_PORT);
	private CANTalon shootRight = new CANTalon(RobotMap.SHOOTER_RIGHT_MOTOR_PORT);

    public void initDefaultCommand() {
        setDefaultCommand(new Shoot());
    }
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    /**
     * Sets the power going to the shooter motors.
     * @param power
     */
    public void setPower(double power) {
    	//TODO: Stub
    }
    
    /** Stops the left shooter motor. */
    public void stopLeftMotor() {
    	//TODO: Stub
    }
    
    /** Stops the right shooter motor. */
    public void stopRightMotor() {
    	//TODO: Stub
    }
}

