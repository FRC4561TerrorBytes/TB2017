package org.usfirst.frc.team4561.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team4561.robot.RobotMap;
import org.usfirst.frc.team4561.robot.commands.ManipulatorIn;
import org.usfirst.frc.team4561.robot.commands.ManipulatorOut;
import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;

/**
 * TODO: Document
 * @author Lucas T
 */
public class GearManipulator extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private Compressor compressor = new Compressor(0);
	private Solenoid solenoid = new Solenoid(1, 0);
    
	public void initDefaultCommand() {
    	setDefaultCommand(new ManipulatorIn());
    }
    
	public void manipulatorIn() {
    	solenoid.set(true);
    }
    
	public void manipulatorOut() {
    	solenoid.set(false);
    }
}

