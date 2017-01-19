package org.usfirst.frc.team4561.robot.subsystems;

import org.usfirst.frc.team4561.robot.RobotMap;
import org.usfirst.frc.team4561.robot.commands.Shoot;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *@author alekj
 */
public class Shooter extends Subsystem {
	
	public CANTalon ShootMotor = new CANTalon(RobotMap.SHOOTER_MOTOR_PORT); //The Shooter's sole motor
    

    public void initDefaultCommand() {
        setDefaultCommand(new Shoot());
    }
    
    public void shootAtSpeed(double speed){
    	//If a valid value, run the shooter motor at the given speed
    	if (speed < 1.0 && speed > -1.0)    	ShootMotor.set(speed);
    }
    
}

