package org.usfirst.frc.team4561.robot.automodes;

import org.usfirst.frc.team4561.robot.commands.SpeedGear;
import org.usfirst.frc.team4561.robot.commands.TorqueGear;
import org.usfirst.frc.team4561.robot.commands.DriveTankTimed;
import org.usfirst.frc.team4561.robot.commands.GearCoverClose;
import edu.wpi.first.wpilibj.command.CommandGroup;

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
    	System.out.println("Driving to line");
    	// bring gear cover down (starts this way because of frame perimeter)
    	addSequential(new GearCoverClose());
    	// set gear to high speed, but low torque
    	addSequential(new TorqueGear());
    	// then drive forward at full speed
    	addSequential(new DriveTankTimed(1, 1, 10)); //TODO: Find exact amount of seconds (third value)
    }
}
