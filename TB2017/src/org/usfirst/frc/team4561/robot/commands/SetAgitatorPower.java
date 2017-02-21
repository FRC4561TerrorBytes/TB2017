package org.usfirst.frc.team4561.robot.commands;

// importing file Robot.java
import org.usfirst.frc.team4561.robot.Robot;
// importing file RobotMap.java
import org.usfirst.frc.team4561.robot.RobotMap;
// importing the class Command
import edu.wpi.first.wpilibj.command.Command;

/**
 * This command sets the power of the agitator motor.
 * @author Ben G
 */
public class SetAgitatorPower extends Command {
	/* 
	 * setting initial power to 0 to avoid causing havoc
	 * because if I didn't do this, then we don't know what speed the motor goes at
	*/
	double power = 0;
	/** 
	 * This function is the initializer for this command (SetAgitatorPower.java)
	 * It takes a double called power as a parameter
	 * @param power
	 */
    public SetAgitatorPower(double power) {
    	// makes sure Robot.agitator actually exists
    	requires(Robot.agitator);
    	// sets the global variable power to the argument to this function
    	this.power = power;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	// if the agitator should print debug statements, then it says that this command has been initialized
    	if (RobotMap.AGITATOR_VERBOSE) {
    		System.out.println("[Command] Intializing SetAgitatorPower for power " + Double.toString(power));
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	// Run agitator at variable speed
    	if (power != 0) {
    		Robot.agitator.setPower(Robot.oi.getRightStickThrottle());
    	} else {
    		Robot.agitator.stop();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	// stop agitator
    	//TODO: ADD BACK
    	// if we should print debug statements, then we do
    	if (RobotMap.AGITATOR_VERBOSE) {
    		System.out.println("[Command] Ending SetAgitatorPower");
    	}
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    // Or when in OI.java if you are using the method whileHeld,
    // it calls the method interrupted
    protected void interrupted() {
    	// run aforementioned function end
    	end();
    }
}
