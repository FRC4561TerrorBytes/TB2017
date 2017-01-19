package org.usfirst.frc.team4561.robot.subsystems;

import org.usfirst.frc.team4561.robot.Robot;
import org.usfirst.frc.team4561.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * TODO: Document
 * @author Ose, Morgan
 */
public class RopeClimber extends Subsystem {
	
	private CANTalon climberMotor = new CANTalon(RobotMap.CLIMBER_MOTOR);
	private DigitalInput loadFinishedSwitch = new DigitalInput(RobotMap.CLIMBER_LIMIT_SWITCH);
	
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
		climberMotor.set(power);
	}
	
	public void stop() {
		climberMotor.set(0);
	}
}