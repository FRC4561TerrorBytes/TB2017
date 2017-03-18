package org.usfirst.frc.team4561.robot.subsystems;

import org.usfirst.frc.team4561.robot.RobotMap;
import org.usfirst.frc.team4561.robot.commands.Climb;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * This is the core subsystem file for the RopeClimber.
 * @author Ose, Morgan, Joseph
 */
public class RopeClimber extends Subsystem {
	
	private CANTalon climberMotor = new CANTalon(RobotMap.CLIMBER_MOTOR);
	
	public RopeClimber() {
		climberMotor.enableBrakeMode(true);
		climberMotor.setCurrentLimit(40);
		climberMotor.reverseOutput(true);
	}
	
	public void initDefaultCommand() {
		setDefaultCommand(new Climb());
	}
	//sets power to 1 when power is not 1, same with -1
	public void setClimber(double power) {
		if (power > 1.0) {
			if (RobotMap.ROPE_CLIMBER_VERBOSE) {
				System.out.println("[Subsystem] Rope climber power set too high: " + power + ", changing to full forward.");
			}
			power = 1;
		} else if (power < 0) {
			if (RobotMap.ROPE_CLIMBER_VERBOSE) {
				System.out.println("[Subsystem] Rope climber power set too high: " + power + ", changing to full reverse.");
			}
			power = 0;
		}
		climberMotor.set(power);
	}
	
	//send climber motor velocity to robot.java for debug
	public double climbEncoderVel() {
		return climberMotor.getEncVelocity();
	}
	
	public double getCurrent() {
		return climberMotor.getOutputCurrent();
	}
	
	public double getVoltage() {
		return climberMotor.getOutputVoltage();
	}
	
	public void enableCurrentLimiting(boolean enable)  {
		climberMotor.EnableCurrentLimit(enable);
	}
	
	//stops climber motor
	public void stop() {
		climberMotor.set(0);
	}
}