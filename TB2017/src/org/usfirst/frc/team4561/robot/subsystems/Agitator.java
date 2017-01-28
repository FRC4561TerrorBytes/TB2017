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
	
	//verbose flag
	private boolean verbose = RobotMap.AGITATOR_VERBOSE;
	
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
    	if (power > 1) {
    		if (verbose) {
    			System.out.println("[SUBSYSTEM] SPEED TOO POSITIVE: " + power + "... CHANGING TO ACCEPTABLE VALUE.");
    		}
    		power = 1;
    	}
    	if (power < -1) {
    		if (verbose) {
    			System.out.println("[SUBSYSTEM] SPEED TOO NEGATIVE" + power + "... CHANGING TO ACCEPTABLE VALUE.");
    		}
    		power = -1;
    	}
		agitatorMotor.set(power);
	}
    /**
     * Function to stop agitator motor
     */
    public void stop() {
    	agitatorMotor.set(0);
    }
}