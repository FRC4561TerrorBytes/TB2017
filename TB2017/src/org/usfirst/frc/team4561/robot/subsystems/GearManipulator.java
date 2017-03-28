package org.usfirst.frc.team4561.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team4561.robot.RobotMap;
import org.usfirst.frc.team4561.robot.commands.GearDefaultCommand;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

/**
 * This is the core subsystem file for the gear manipulator
 * @author Lucas T
 */
public class GearManipulator extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	//Solenoid declarations
	private DoubleSolenoid holderSolenoid = new DoubleSolenoid(RobotMap.PCM, RobotMap.HOLDER_SOLENOID_PORT, RobotMap.HOLDER_SOLENOID_PORT_TWO);
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
    	holderSolenoid.set(DoubleSolenoid.Value.kReverse);
    }
    
	/**
	 * Method to open gear manipulator
	 */
	public void openHolder() {
		holderSolenoid.set(DoubleSolenoid.Value.kForward);
    }
	
	public void holderOff(){
		holderSolenoid.set(DoubleSolenoid.Value.kOff);
	}
	
	/**
	 * Method to close anti-fuel gear manipulator cover
	 */
	public void closeCover() {
    	coverSolenoid.set(true);
    }
	
	/**
	 * Method to open anti-fuel gear manipulator cover
	 */
	public void openCover() {
    	coverSolenoid.set(false);
    }
	
	/**
	 * sends holder's states to the core robot file for debug mode
	 */
	public Value holderState() {
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