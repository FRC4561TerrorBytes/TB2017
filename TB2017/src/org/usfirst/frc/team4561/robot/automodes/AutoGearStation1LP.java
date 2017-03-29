package org.usfirst.frc.team4561.robot.automodes;

import org.usfirst.frc.team4561.robot.Robot;
import org.usfirst.frc.team4561.robot.commands.DriveTankTimed;
import org.usfirst.frc.team4561.robot.commands.GearDefaultCommand;
import org.usfirst.frc.team4561.robot.commands.GearHolderOpen;
import org.usfirst.frc.team4561.robot.commands.GearHolderClose;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class AutoGearStation1LP extends CommandGroup {

    public AutoGearStation1LP() {
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
    	addSequential(new GearHolderOpen());
    	addSequential(new WaitCommand(1));
    	addSequential(new DriveTankTimed(1, 1, 1.22));
    	addSequential(new DriveTankTimed(0.7, -0.7, .125)); //Turn Right ~45 degrees
    	addSequential(new DriveTankTimed(0.5, 0.5, 5)); // Move forward
    	addSequential(new WaitCommand(2));
    	addSequential(new GearHolderClose());
    	addSequential(new WaitCommand(2));
    	addSequential(new DriveTankTimed(-0.5, -0.5, 5));
//    	addSequential(new GearHolderOpen()); // Open the gear holder
//    	addSequential(new DriveTankTimed(-1, -1, 3)); // Move back to leave gear on peg
//        addSequential(new GearHolderClose()); // raise trapdoors for another attempt at the peg or for another gear in teleop
        
        /*SECOND ATTEMPT, IF NECESSARY*/
//        if(Robot.gearManipulator.detectorState() == true){
//        	addSequential(new DriveTankTimed(1, 1, 3)); // Move back to peg (TODO: change number of seconds)
//        	addSequential(new GearHolderOpen()); // Open the gear holder
//        }
    }
}
