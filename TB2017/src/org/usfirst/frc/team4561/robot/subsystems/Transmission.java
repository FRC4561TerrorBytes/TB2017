package org.usfirst.frc.team4561.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * TODO: Document
 * @author Zane T, Ben G
 */
public class Transmission extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private Solenoid solenoidTrans = new Solenoid(0, 2);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    //TODO: These two are temporary and can be switched around.
  	public void torqueGear() {
  		System.out.println("Transmission: Switching to high torque gear...");
      	solenoidTrans.set(true);
    }
    
  	public void speedGear() {
  		System.out.println("Transmission: Switching to high speed gear...");
      	solenoidTrans.set(false);
    }
}