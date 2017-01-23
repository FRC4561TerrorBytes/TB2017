package org.usfirst.frc.team4561.robot.subsystems;

import org.usfirst.frc.team4561.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * TODO: Document
 * @author Ben G
 */
public class Agitator extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	// Declaring a new object of type CANTalon called agitatorMotor
	private CANTalon agitatorMotor = new CANTalon(RobotMap.AGITATOR_MOTOR_PORT);
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    // function to run agitator at speed power
    /**
     * Function to run agitator at a certain power
     * @param power
     */
    public void startAgitator(double power) {
    	System.out.println("Agitator: function startAgitator called with speed " + power);
    	if (power > 1) {
    		System.out.println("Agitator: Oops!  Speed was too high, changing to an acceptable value.");
    		power = 1;
    	}
    	if (power < -1) {
    		System.out.println("Agitator: Oops!  Speed was too low, changing to an acceptable value.");
    		power = -1;
    	}
		agitatorMotor.set(power);
	}
    /**
     * Function to stop agitator motor
     */
    public void stop() {
    	System.out.println("Agitator: Stopping motor...");
    	agitatorMotor.set(0);
    }
}