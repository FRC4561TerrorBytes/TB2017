package org.usfirst.frc.team4561.robot.automodes;

import org.usfirst.frc.team4561.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.ConditionalCommand;

/**
 *
 */
public class AutoCheckPeg extends ConditionalCommand {

    public AutoCheckPeg(Command onTrue, Command onFalse) {
		super(onTrue, onFalse);
		System.out.println("constructing checkpeg");
		// TODO Auto-generated constructor stub
	}
    
	@Override
	protected boolean condition() {
		// TODO Auto-generated method stub
		System.out.println("Checking peg: " + Robot.gearManipulator.isPegDetected());
		return Robot.gearManipulator.isPegDetected();
	}
}
