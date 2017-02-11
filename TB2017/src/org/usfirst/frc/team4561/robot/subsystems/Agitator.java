package org.usfirst.frc.team4561.robot.subsystems;
// import RobotMap.java
import org.usfirst.frc.team4561.robot.RobotMap;
// import motor controller library
import com.ctre.CANTalon;
// And import the class Subsystem
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * This is the subsystem file for the agitator.
 * @author Ben G
 */
public class Agitator extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	// makes a motor variable for the agitator
	private CANTalon agitatorMotor = new CANTalon(RobotMap.AGITATOR_MOTOR_PORT);
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    /**
     * Function to run agitator at a certain power
     * @param power
     */
    public void setPower(double power) {
    	// if value is too high
    	if (power > 1) {
    		if (RobotMap.AGITATOR_VERBOSE) {
    			// And if we are supposed to print debug information,
    			System.out.println("[Subsystem] Power set too high: " + power + ", changed to full forward"); // then we do.
    		}
    		// set power to acceptable value
    		power = 1;
    	}
    	// if the value is set too low, 
    	else if (power < -1) {
    		if (RobotMap.AGITATOR_VERBOSE) {
    			// And if we are supposed to print debug information,
    			System.out.println("[Subsystem] Power set too low: " + power + ", changed to full reverse");
    		}
    		// set power to acceptable value
    		power = -1;
    	}
    	// Run agitator motor at set power
		agitatorMotor.set(power);
	}
    
    //sends agitator velocity to robot.java for debug
    public double agitatorState() {
		return agitatorMotor.getEncVelocity();
    }
    
    /**
     * Function to stop agitator motor
     */
    public void stop() {
    	// Stop the agitator motor
    	agitatorMotor.set(0);
    }
}