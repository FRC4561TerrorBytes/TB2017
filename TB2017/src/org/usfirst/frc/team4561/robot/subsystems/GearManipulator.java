package org.usfirst.frc.team4561.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.Solenoid;

/**
 * TODO: Document
 * @author Lucas T
 */
public class GearManipulator extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	//Solenoid declarations
	private Solenoid holderSolenoid = new Solenoid(0, 0);
	private Solenoid coverSolenoid = new Solenoid(0, 1);
    
	public void initDefaultCommand() {
    }
    
	/**
	 * TODO: Document
	 */
	public void closeHolder() {
    	holderSolenoid.set(true);
    }
    
	/**
	 * TODO: Document
	 */
	public void openHolder() {
    	holderSolenoid.set(false);
    }
	
	/**
	 * TODO: Document
	 */
	public void closeCover() {
    	coverSolenoid.set(true);
    }
	
	/**
	 * TODO: Document
	 */
	public void openCover() {
    	coverSolenoid.set(false);
    }
}