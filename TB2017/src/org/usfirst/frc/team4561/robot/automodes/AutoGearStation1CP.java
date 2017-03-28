package org.usfirst.frc.team4561.robot.automodes;
 
import org.usfirst.frc.team4561.robot.commands.GearOverride;
import org.usfirst.frc.team4561.robot.commands.ToggleDriveTrainPIDOff;
import org.usfirst.frc.team4561.robot.commands.ToggleDriveTrainPIDOn;
import org.usfirst.frc.team4561.robot.commands.GearOverride;
import org.usfirst.frc.team4561.robot.commands.TorqueGear;
import org.usfirst.frc.team4561.robot.Robot;
import org.usfirst.frc.team4561.robot.commands.DriveTankTimed;
import org.usfirst.frc.team4561.robot.commands.GearCoverClose;
import org.usfirst.frc.team4561.robot.commands.GearCoverOpen;
import org.usfirst.frc.team4561.robot.commands.GearDefaultCommand;
import org.usfirst.frc.team4561.robot.commands.GearHolderClose;
import org.usfirst.frc.team4561.robot.commands.GearHolderOpen;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
 
/**
 *
 */
public class AutoGearStation1CP extends CommandGroup {
 
    public AutoGearStation1CP() {
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
//    	addSequential(new GearCoverClose()); // make sure gear cover is down
//        addSequential(new TorqueGear()); // Go into high torque but low speed gear
//        addSequential(new DriveTankTimed(1, 1, 5)); // Move forward
//        addSequential(new DriveTankTimed(1, 0, .25)); //Turn Right
////      addSequential(new DriveTankTimed(1, 1, 5)); // Move forward
//        addSequential(new DriveTankTimed(0, 1, .25)); //Turn Left
//        addSequential(new DriveTankTimed(1, 1, 1)); // Move close to peg (TODO: change number of seconds)
//        addSequential(new GearHolderOpen()); // Open the gear holder
//        addSequential(new WaitCommand(2));
//        addSequential(new DriveTankTimed(-0.3, -0.3, 3)); // Move back to leave gear on peg
//        addSequential(new GearHolderClose()); // raise trapdoors for another attempt at the peg or for another gear in teleop
        /*SECOND ATTEMPT, IF NECESSARY*/
//        if(Robot.gearManipulator.detectorState() == true) {
//        	addSequential(new DriveTankTimed(1, 1, 3)); // Move back to peg (TODO: change number of seconds)
//        	addSequential(new GearHolderOpen()); // Open the gear holder
//        }
    	addSequential(new GearHolderClose());
    	addSequential(new GearCoverClose());
    	addSequential(new WaitCommand(0.5));
    	addSequential(new DriveTankTimed(1, 1, 0.8));
    	addSequential(new DriveTankTimed(0.5, 0.5, 1.75));
    	addSequential(new WaitCommand(1));
    	addSequential(new GearHolderOpen());
    	addSequential(new WaitCommand(1));
    	addSequential(new GearCoverOpen());
    	addSequential(new DriveTankTimed(-0.5, -0.5, 5));
    }
}
