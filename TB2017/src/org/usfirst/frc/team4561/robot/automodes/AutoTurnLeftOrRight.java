package org.usfirst.frc.team4561.robot.automodes;

import org.usfirst.frc.team4561.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.ConditionalCommand;

/**
 *
 */
public class AutoTurnLeftOrRight extends ConditionalCommand {

    public AutoTurnLeftOrRight(Command onTrue, Command onFalse) {
		super(onTrue, onFalse);
		// TODO Auto-generated constructor stub
	}
    
	@Override
	protected boolean condition() {
		// TODO Auto-generated method stub
//		System.out.println("Turn left if true: " + (AutoIncrementDetectPeg.i % 8 > 3));
		return false;//AutoIncrementDetectPeg.i % 8 > 3;
	}
}
