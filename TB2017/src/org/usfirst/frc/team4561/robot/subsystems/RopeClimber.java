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

	//verbose flag
	private boolean verbose = RobotMap.ROPECLIMBER_VERBOSE;
	
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
			if (verbose) {
				System.out.println("ROPECLIMBER: SPEED WAS SET TOO POSITIVE... CHANGING TO AN ACCEPTABLE VALUE");
			}
			power = 1;
		} else if (power < -1) {
			if (verbose) {
				System.out.println("ROPECLIMBER: SPEED WAS SET TOO NEGATIVE... CHANGING TO AN ACCEPTABLE VALUE");
			}
			power = -1;
		}
		climberMotor.set(power);
	}
	public void stop() {
		climberMotor.set(0);
	}
}