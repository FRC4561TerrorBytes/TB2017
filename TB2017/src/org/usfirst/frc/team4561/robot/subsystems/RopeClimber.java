package org.usfirst.frc.team4561.robot.subsystems;

import org.usfirst.frc.team4561.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * TODO: Document
 * @author Ose, Morgan
 */
public class RopeClimber extends Subsystem {
	
	private CANTalon climberMotor = new CANTalon(RobotMap.CLIMBER_MOTOR);
	
/**	public Rollers() {
*		if(Robot.isVerbose()) {
*			System.out.println("Initializing Rollers Subsystem");
*		}
*		rollerMotor.enableBrakeMode(true);
*		rollerMotor.setInverted(true);
*	}
*/
	public void initDefaultCommand() {
		//TODO: Create command commandsetDefaultCommand(new );
	}
	

	public void setClimber(double power) {
		if (power > 1) {
			if (RobotMap.ROPE_CLIMBER_VERBOSE) {
				System.out.println("[Subsystem] Rope climber power set too high: " + power + ", changing to full forward.");
			}
			power = 1;
		} else if (power < -1) {
			if (RobotMap.ROPE_CLIMBER_VERBOSE) {
				System.out.println("[Subsystem] Rope climber power set too high: " + power + ", changing to full reverse.");
			}
			power = -1;
		}
		climberMotor.set(power);
	}
	public void stop() {
		climberMotor.set(0);
	}
}