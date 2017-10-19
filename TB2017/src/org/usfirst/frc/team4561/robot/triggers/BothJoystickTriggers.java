package org.usfirst.frc.team4561.robot.triggers;

import org.usfirst.frc.team4561.robot.Robot;

import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 *
 */
public class BothJoystickTriggers extends Trigger {

	private boolean initialPress = false;
	
    public boolean get() {
    	boolean fire = false;
    	if (Robot.oi != null) {
    		if (Robot.oi.getLeftTrigger() && Robot.oi.getRightTrigger()) {
    			initialPress = true;
    		}
    		if (!Robot.oi.getLeftTrigger() && !Robot.oi.getRightTrigger()) {
    			initialPress = false;
    		}
    		if (initialPress && (Robot.oi.getLeftTrigger() || Robot.oi.getRightTrigger())) {
    			fire = true;
    		}
    	}
        return fire;
    }
}
