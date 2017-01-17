package org.usfirst.frc.team4561.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team4561.robot.RobotMap;

import com.ctre.CANTalon;

/**
 *
 */
public class Intake extends Subsystem {

	private CANTalon leftIntakeMotor = new CANTalon(RobotMap.LEFT_INTAKE_MOTOR_PORT);
	private CANTalon rightIntakeMotor = new CANTalon(RobotMap.RIGHT_INTAKE_MOTOR_PORT);

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void intakeBall(double power) {
		leftIntakeMotor.set(power);
		rightIntakeMotor.set(power);
	}
    
    public void stop() {
    	leftIntakeMotor.set(0);
		rightIntakeMotor.set(0);
    }
}

