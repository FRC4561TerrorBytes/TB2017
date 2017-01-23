package org.usfirst.frc.team4561.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4561.robot.commands.ManipulatorIn;
import edu.wpi.first.wpilibj.Solenoid;

/**
 * TODO: Document
 * @author Lucas T
 */
public class GearManipulator extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	//Solenoid declarations
	private Solenoid solenoidMain = new Solenoid(1, 0);
	private Solenoid solenoidTop = new Solenoid(2, 0);
    
	public void initDefaultCommand() {
    	setDefaultCommand(new ManipulatorIn());
    }
    
	//For when gear is captured
	public void manipulatorIn() {
    	solenoidMain.set(true);
    }
    
	//when you want to intake/release gear
	public void manipulatorOut() {
    	solenoidMain.set(false);
    }
	
	//The following 2 methods control the gear cover, so there is no...
	//FUEL IN THE MANIPULATOR
	public void gearCoverClose() {
    	solenoidTop.set(true);
    }
	
	public void gearCoverOpen() {
    	solenoidTop.set(false);
    }
}

