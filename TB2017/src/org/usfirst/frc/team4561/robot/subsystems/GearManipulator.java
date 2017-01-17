package org.usfirst.frc.team4561.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team4561.robot.RobotMap;
import org.usfirst.frc.team4561.robot.commands.ManipulatorIn;
import org.usfirst.frc.team4561.robot.commands.ManipulatorOut;
import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
/** 
 * 
 */
public class GearManipulator extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Compressor c = new Compressor(0);
	Solenoid solenoid = new Solenoid(1, 0);
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new ManipulatorIn());
    }
    public void manipulatorIn() {
    	solenoid.set(true);
    }
    public void manipulatorOut() {
    	solenoid.set(false);
    }
}

