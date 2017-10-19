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
public class AutoStopCenterDetect extends CommandGroup {

	@Override
	protected void initialize() {
		System.out.println("starting auto stop center detect");
	}
	
    public AutoStopCenterDetect() {
    	System.out.println("constructing stop cente3r peg");
    	addSequential(new WaitCommand(0.5));
    	addSequential(new DriveTankTimed(-0.65, -0.65, 1));
        addSequential(new ToggleDriveTrainPIDOff());
    }
}
