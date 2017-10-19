package org.usfirst.frc.team4561.robot.automodes;

import org.usfirst.frc.team4561.robot.Robot;
import org.usfirst.frc.team4561.robot.commands.DriveTankTimed;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class AutoTryAgainLeft extends CommandGroup {

	@Override
	protected void initialize() {
		System.out.println("starting auto try again left");
	}
	
    public AutoTryAgainLeft() {
    	
    	addSequential(new DriveTankTimed(-0.8, -0.8, 0.1));
    	addSequential(new DriveTankTimed(-0.6, 0.6, 0.1));
		addSequential(new DriveTankTimed(0.8, 0.8, 0.2));
		addSequential(new WaitCommand(0.1));
//		System.out.println(AutoIncrementDetectPeg.i);
//		if (AutoIncrementDetectPeg.i > 100) {
//			addSequential(new AutoStopCenterDetect());
//		} else {
//			addSequential(new AutoIncrementDetectPeg());
//			addSequential(new AutoCheckPeg(new AutoEndCenterDetectPeg(), new AutoTurnLeftOrRight(new AutoTryAgainLeft(), new AutoTryAgainRight())));
//		}
    }
    
    protected void end() {
    	System.out.println("ending auto try again left");
    }
}
