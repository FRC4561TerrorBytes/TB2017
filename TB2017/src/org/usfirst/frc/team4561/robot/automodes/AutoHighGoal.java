package org.usfirst.frc.team4561.robot.automodes;

import org.usfirst.frc.team4561.robot.commands.AutoShootFullPower;
import org.usfirst.frc.team4561.robot.commands.SpeedGear;
import org.usfirst.frc.team4561.robot.commands.TankDriveForward;
import org.usfirst.frc.team4561.robot.commands.TankDriveLeft;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoHighGoal extends CommandGroup {

    public AutoHighGoal() {
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
    	
    	addSequential(new SpeedGear()); //Nobody is defending us, switch to the speed gear
    	addSequential(new TankDriveForward()); //Move forward to align with the boiler
    	addSequential(new TankDriveLeft()); //Shoot at the boiler, not the airship! Ugh, let's try something else.
    	addSequential(new TankDriveForward()); //Move closer to the boiler
    	addSequential(new AutoShootFullPower()); //FIRE AT WILL
    }
}
