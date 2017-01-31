package org.usfirst.frc.team4561.robot.automodes;

import org.usfirst.frc.team4561.robot.commands.GearCoverOpen;
import org.usfirst.frc.team4561.robot.commands.SpeedGear;
import org.usfirst.frc.team4561.robot.commands.TankDriveForward;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoPlaceGear extends CommandGroup {

    public AutoPlaceGear() {
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
    	addSequential(new SpeedGear()); // Go into high speed but low torque gear
    	addSequential(new TankDriveForward()); // Move close to peg
    	addSequential(new GearCoverOpen()); // open the cover on the gear manipulator
    	addSequential(new TankDriveForward()); // Say hi to the peg (a.k.a drive to the peg)
    	//addSequential(new ManipulatorOut()); // TODO: Change to GearHolderOpen / GearHolderClose
    }
}
