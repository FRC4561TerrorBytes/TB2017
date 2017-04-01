package org.usfirst.frc.team4561.robot.automodes;

import org.usfirst.frc.team4561.robot.commands.SpeedGear;
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
public class AutoDriveToLine extends CommandGroup {

    public AutoDriveToLine() {
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
    	
    	addSequential(new GearHolderClose());
    	addSequential(new GearCoverClose());
    	addSequential(new TorqueGear());
    	// Drive forward at full speed
    	addSequential(new DriveTankTimed(1, 1, 2));
    	addSequential(new WaitCommand(5));
    }
}
