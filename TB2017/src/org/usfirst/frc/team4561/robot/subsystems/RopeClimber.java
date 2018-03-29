package org.usfirst.frc.team4561.robot.subsystems;

import org.usfirst.frc.team4561.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * This is the core subsystem file for the RopeClimber.
 * @author Ose, Morgan, Joseph, Zane
 */
public class RopeClimber extends Subsystem {
	
	private TalonSRX climberMotor = new TalonSRX(RobotMap.CLIMBER_MOTOR);
	
	public void initDefaultCommand() {
		//TODO: Create command commandsetDefaultCommand(new );
	}
	//sets power to 1 when power is not 1, same with -1
	public void setClimber(double power) {
		if (power > 1) {
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
		climberMotor.set(ControlMode.Follower, power);
	}
	//stops climber motor
	public void stop() {
		climberMotor.set(ControlMode.Follower, 0);
	}
}