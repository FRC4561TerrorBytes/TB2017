package org.usfirst.frc.team4561.robot.subsystems;

import org.usfirst.frc.team4561.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * This subsystem contains the methods to switch the gear types.
 * @author Zane T, Ben G
 */
public class Transmission extends Subsystem {

    //Creates a new Solenoid using the info from RobotMap
	private Solenoid solenoidTrans = new Solenoid(RobotMap.PCM, RobotMap.TRANSMISSION_SOLENOID_PORT);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    //TODO: These two methods are temporary and can be switched around.
  	public void torqueGear() {
  		System.out.println("[Transmission] Switching to high torque gear...");
      	solenoidTrans.set(true);
    }
    
  	public void speedGear() {
  		System.out.println("[Transmission] Switching to high speed gear...");
      	solenoidTrans.set(false);
    }
}