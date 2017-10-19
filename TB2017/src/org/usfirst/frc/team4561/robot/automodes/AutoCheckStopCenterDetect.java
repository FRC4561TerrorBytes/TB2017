package org.usfirst.frc.team4561.robot.automodes;

import org.usfirst.frc.team4561.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.ConditionalCommand;

/**
 *
 */
public class AutoCheckStopCenterDetect extends ConditionalCommand {

    public AutoCheckStopCenterDetect(Command onTrue, Command onFalse) {
		super(onTrue, onFalse);
		// TODO Auto-generated constructor stub
	}
    
	@Override
	protected boolean condition() {
		// TODO Auto-generated method stub
		System.out.println("checking if we should stop");
		return AutoIncrementDetectPeg.stopped;
	}
}
