package org.usfirst.frc.team4561.robot.automodes;

import org.usfirst.frc.team4561.robot.Robot;
import org.usfirst.frc.team4561.robot.commands.DriveTankTimed;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class AutoTryAgainLeftFirst extends CommandGroup {

	@Override
	protected void initialize() {
		System.out.println("starting auto try again left first");
	}
	
    public AutoTryAgainLeftFirst() {
    	addSequential(new DriveTankTimed(-0.8, -0.8, 0.1));
    	addSequential(new DriveTankTimed(-0.6, 0.6, 0.1));
		addSequential(new DriveTankTimed(0.8, 0.8, 0.2));
		addSequential(new WaitCommand(0.1));
		addSequential(new AutoCheckPeg(new AutoEndCenterDetectPeg(), new AutoTryAgainLeft()));
    }
}
