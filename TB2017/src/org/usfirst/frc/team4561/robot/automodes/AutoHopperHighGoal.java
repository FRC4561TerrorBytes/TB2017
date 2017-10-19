package org.usfirst.frc.team4561.robot.automodes;

import org.usfirst.frc.team4561.robot.commands.AutoShootFullPower;
import org.usfirst.frc.team4561.robot.commands.DriveTankTimed;
import org.usfirst.frc.team4561.robot.commands.GearCoverClose;
import org.usfirst.frc.team4561.robot.commands.SetAgitatorPower;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *@author Ben, Shrivikas
 */
public class AutoHopperHighGoal extends CommandGroup {
	
	public AutoHopperHighGoal() {
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

    //TODO: Must Tune all values and add any necessary steps
    addSequential(new GearCoverClose());
    addSequential(new DriveTankTimed(1, 1, 5)); // drive backwards for 10 seconds
    addSequential(new DriveTankTimed(0, 1, 1)); // turn right for 1 second
    addSequential(new DriveTankTimed(1, 1, 2)); // go forward
    addSequential(new DriveTankTimed(0, 0, 2));//waiting for balls to fill hopper 
    addSequential(new DriveTankTimed(-1, -1, 0.25)); // go forward for 0.25 seconds
    addSequential(new DriveTankTimed(0, 1, 1)); // turn right for 1 second
    addSequential(new DriveTankTimed(1, 1, 3)); // go forward for 10 seconds
    addSequential(new DriveTankTimed(1, 0, 1)); // turn right at half power for 1 second
    addSequential(new AutoShootFullPower()); //Spin up FlyWheel
    addSequential(new SetAgitatorPower(1)); // Set Agitator to full power and FIRE AT WILL
	}
}
