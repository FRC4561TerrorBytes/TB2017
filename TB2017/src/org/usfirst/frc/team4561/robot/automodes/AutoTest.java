package org.usfirst.frc.team4561.robot.automodes;

import org.usfirst.frc.team4561.robot.commands.DriveTankTimed;
import org.usfirst.frc.team4561.robot.commands.ToggleDriveTrainPIDOff;
import org.usfirst.frc.team4561.robot.commands.ToggleDriveTrainPIDOn;
import org.usfirst.frc.team4561.robot.commands.TorqueGear;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoTest extends CommandGroup {

    public AutoTest() {
    	addSequential(new ToggleDriveTrainPIDOn());
        addSequential(new TorqueGear());
        addSequential(new DriveTankTimed(-0.4, 0.4, 1.18));
        addSequential(new ToggleDriveTrainPIDOff());
    }
}
