package org.usfirst.frc.team4561.robot.automodes;

import org.usfirst.frc.team4561.robot.commands.SpeedGear;
import org.usfirst.frc.team4561.robot.commands.ToggleDriveTrainPIDOff;
import org.usfirst.frc.team4561.robot.commands.ToggleDriveTrainPIDOn;
import org.usfirst.frc.team4561.robot.commands.TorqueGear;
import org.usfirst.frc.team4561.robot.commands.DriveTankTimed;
import org.usfirst.frc.team4561.robot.commands.GearCoverClose;
import org.usfirst.frc.team4561.robot.commands.GearHolderClose;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 * TODO: Document
 * @author Ben G
 */
public class AutoPIDDriveToLine extends CommandGroup {

    public AutoPIDDriveToLine() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	
    	addSequential(new ToggleDriveTrainPIDOn());
    	addSequential(new GearHolderClose());
    	addSequential(new GearCoverClose());
    	addSequential(new TorqueGear());
    	addSequential(new WaitCommand(0.5));
    	// Drive forward at full speed
    	addSequential(new DriveTankTimed(0.8, 0.8, 2));
    	addSequential(new ToggleDriveTrainPIDOff());
    	addSequential(new WaitCommand(5));
    }
}
