package org.usfirst.frc.team4561.robot.triggers;

import org.usfirst.frc.team4561.robot.Robot;

import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 *
 */
public class GearDetectorTrigger extends Trigger {

	public boolean get() {
		if (Robot.oi != null) {
			return Robot.gearManipulator.gearDetector.get();
		}
		return false;
    }
}
