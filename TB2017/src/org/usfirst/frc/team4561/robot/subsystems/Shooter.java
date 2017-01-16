package org.usfirst.frc.team4561.robot.subsystems;

import org.usfirst.frc.team4561.robot.commands.Shoot;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
	
	public CANTalon ShootLeft = new CANTalon(/*RobotMap.SHOOTER_LEFT_MOTOR_PORT*/0); //TODO: Put value into RobotMap
	public CANTalon ShootRight = new CANTalon(/*RobotMap.SHOOTER_RIGHT_MOTOR_PORT*/1); //TODO: Put value in RobotMap
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        setDefaultCommand(new Shoot());
    }
    
}

