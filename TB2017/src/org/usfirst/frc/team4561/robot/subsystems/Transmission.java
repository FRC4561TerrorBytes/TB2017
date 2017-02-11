package org.usfirst.frc.team4561.robot.subsystems;

import org.usfirst.frc.team4561.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * This subsystem contains the methods to switch the gear types.
 * @author Zane T, Ben G, Morgan B
 */
public class Transmission extends Subsystem {

    //Creates a new Solenoid using the info from RobotMap
	/*
	 * To go in RobotMap:
	 * public static final String TRANSMISSION_SOLENOID_TYPE = "single";
	 */
	private Solenoid solenoidTrans;
	private DoubleSolenoid doubleSolenoidTrans;
	public Transmission() {
		if (RobotMap.TRANSMISSION_SOLENOID_TYPE == "single") {
			solenoidTrans = new Solenoid(RobotMap.PCM, RobotMap.TRANSMISSION_SOLENOID_PORT);
		}
		else {
			doubleSolenoidTrans = new DoubleSolenoid(RobotMap.PCM, RobotMap.TRANSMISSION_SOLENOID_PORT, RobotMap.TRANSMISSION_SOLENOID_TWO_PORT);
		}
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    //TODO: These two methods are temporary and can be switched around.
  	public void torqueGear() {
  		if (RobotMap.TRANSMISSION_SOLENOID_TYPE == "single") {
  			System.out.println("[Transmission] Switching to high torque gear...");
  			solenoidTrans.set(true);
  		}
  		else {
  			System.out.println("[Transmission] Switching to high torque gear...");
  			doubleSolenoidTrans.set(DoubleSolenoid.Value.kForward);
  		}
    }
    
  	public void speedGear() {
      	if (RobotMap.TRANSMISSION_SOLENOID_TYPE == "single") {
  			System.out.println("[Transmission] Switching to high speed gear...");
  			solenoidTrans.set(false);
  		}
  		else {
  			System.out.println("[Transmission] Switching to high speed gear...");
  			doubleSolenoidTrans.set(DoubleSolenoid.Value.kReverse);
  		}
    }
  	
}