package org.usfirst.frc.team4561.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team4561.robot.Robot;
import org.usfirst.frc.team4561.robot.RobotMap;
import org.usfirst.frc.team4561.robot.commands.GearDefaultCommand;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DigitalInput;

/**
 * This is the core subsystem file for the gear manipulator
 * @author Lucas T
 */
public class GearManipulator extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	//Solenoid declarations
	private Solenoid holderSolenoid = new Solenoid(RobotMap.PCM, RobotMap.HOLDER_SOLENOID_PORT);
	private Solenoid coverSolenoid = new Solenoid(RobotMap.PCM, RobotMap.COVER_SOLENOID_PORT);
	
	//Infrared Sensor Declaration
	public DigitalInput gearDetector = new DigitalInput(0);
    
	public void initDefaultCommand() {
		setDefaultCommand(new GearDefaultCommand());
    }
    
	/**
	 * Method to close gear manipulator
	 */
	public void closeHolder() {
		Robot.profilerTest("CloseHolder Start");
    	holderSolenoid.set(true);
		Robot.profilerTest("CloseHolder End");
    }
    
	/**
	 * Method to open gear manipulator
	 */
	public void openHolder() {
		Robot.profilerTest("OpenHolder Start");
    	holderSolenoid.set(false);
		Robot.profilerTest("OpenHolder End");
    }
	
	/**
	 * Method to close anti-fuel gear manipulator cover
	 */
	public void closeCover() {
		Robot.profilerTest("CloseCover Start");
    	coverSolenoid.set(true);
		Robot.profilerTest("CloseCover End");
    }
	
	/**
	 * Method to open anti-fuel gear manipulator cover
	 */
	public void openCover() {
		Robot.profilerTest("OpenCover Start");
    	coverSolenoid.set(false);
		Robot.profilerTest("OpenCover End");
    }
	
	/**
	 * sends holder's states to the core robot file for debug mode
	 */
	public boolean holderState() {
		return holderSolenoid.get();
	}
	
	public boolean detectorState() {
		return gearDetector.get();
	}
	
	/**
	 * sends cover's states to the core robot file for debug mode
	 */
	public boolean coverState() {
		return coverSolenoid.get();
	}
}