package org.usfirst.frc.team4561.robot.subsystems;

import org.usfirst.frc.team4561.robot.Robot;
import org.usfirst.frc.team4561.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
	
	public String currentState = "Unknown";
	public String lastChange = "None";
	
	private DoubleSolenoid doubleSolenoidTrans;
	
	public Transmission() {
		Robot.profilerTest("Transmission Start");
			doubleSolenoidTrans = new DoubleSolenoid(RobotMap.PCM, RobotMap.TRANSMISSION_SOLENOID_PORT, RobotMap.TRANSMISSION_SOLENOID_TWO_PORT);
		Robot.profilerTest("Transmission End");
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    //TODO: These two methods are temporary and can be switched around.
  	public void torqueGear() {
		Robot.profilerTest("TorqueGearPower Start");
  		if (RobotMap.TRANSMISSION_VERBOSE) {
  			System.out.println("[Transmission] Switching to high torque gear...");
  		}
		doubleSolenoidTrans.set(DoubleSolenoid.Value.kForward);
		lastChange = currentState = "Torque";
		Robot.profilerTest("TorqueGearPower End");
    }
    
  	public void speedGear() {
		Robot.profilerTest("SpeedGearPower Start");
  		if (RobotMap.TRANSMISSION_VERBOSE) {
  			System.out.println("[Transmission] Switching to high speed gear...");
  		}
		doubleSolenoidTrans.set(DoubleSolenoid.Value.kReverse);
		lastChange = currentState = "Speed";		
		Robot.profilerTest("SpeedGearPower End");
    }
  	
  	public void stop() {
  		doubleSolenoidTrans.set(DoubleSolenoid.Value.kOff);
  		currentState = "Off";
  	}
  	
}