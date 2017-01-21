package org.usfirst.frc.team4561.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team4561.robot.RobotMap;
import org.usfirst.frc.team4561.robot.commands.GearCoverClose;
import org.usfirst.frc.team4561.robot.commands.GearCoverOpen;
import org.usfirst.frc.team4561.robot.commands.ManipulatorIn;
import org.usfirst.frc.team4561.robot.commands.ManipulatorOut;
import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * TODO: Document
 * @author Lucas T
 */
public class GearManipulator extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	//private JoystickButton gearCoverCloseButton = new JoystickButton(RightStick, RobotMap.GEAR_COVER_CLOSE_BUTTON);
	//private JoystickButton gearCoverOpenButton = new JoystickButton(RightStick, RobotMap.GEAR_COVER_OPEN_BUTTON);
	//gearCoverCloseButton.whenPressed(new GearCoverClose());
	//gearCoverOpenButton.whenPressed(new GearCoverOpen());
	//public static final int GEAR_COVER_CLOSE_BUTTON = 0;//TODO: Port number
	//public static final int GEAR_COVER_OPEN_BUTTON = 0; //TODO: Port number
	
	//private Compressor compressor = new Compressor(0);
	private Solenoid solenoid = new Solenoid(1, 0);
	private Solenoid solenoidTop = new Solenoid(2, 0);
    
	public void initDefaultCommand() {
    	setDefaultCommand(new ManipulatorIn());
    }
    
	public void manipulatorIn() {
    	solenoid.set(true);
    }
    
	public void manipulatorOut() {
    	solenoid.set(false);
    }
	
	public void gearCoverClose() {
    	solenoidTop.set(true);
    }
	
	public void gearCoverOpen() {
    	solenoidTop.set(false);
    }
}

