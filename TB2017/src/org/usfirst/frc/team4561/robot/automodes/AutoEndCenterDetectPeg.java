package org.usfirst.frc.team4561.robot.automodes;

import org.usfirst.frc.team4561.robot.commands.DriveTankTimed;
import org.usfirst.frc.team4561.robot.commands.GearCoverOpen;
import org.usfirst.frc.team4561.robot.commands.GearHolderOpen;
import org.usfirst.frc.team4561.robot.commands.ToggleDriveTrainPIDOff;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class AutoEndCenterDetectPeg extends CommandGroup {

	@Override
	protected void initialize() {
		System.out.println("starting auto end center detect peg");
	}
	
    public AutoEndCenterDetectPeg() {
    	addSequential(new DriveTankTimed(0.8, 0.8, 0.4));
    	addSequential(new DriveTankTimed(-0.5, -0.5, 0.1));
        addSequential(new GearHolderOpen());
    	addSequential(new WaitCommand(0.5));
    	addSequential(new GearCoverOpen());
    	addSequential(new DriveTankTimed(-0.65, -0.65, 1));
        addSequential(new ToggleDriveTrainPIDOff());
        addSequential(new AutoIncrementDetectPeg());
    }
}
