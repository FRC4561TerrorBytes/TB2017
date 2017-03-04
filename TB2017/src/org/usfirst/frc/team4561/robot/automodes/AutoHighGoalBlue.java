package org.usfirst.frc.team4561.robot.automodes;
 
import org.usfirst.frc.team4561.robot.commands.AutoShootFullPower;
import org.usfirst.frc.team4561.robot.commands.DriveTankTimed;
import org.usfirst.frc.team4561.robot.commands.GearCoverClose;
import org.usfirst.frc.team4561.robot.commands.SetAgitatorPower;
import org.usfirst.frc.team4561.robot.commands.SpeedGear;
//import org.usfirst.frc.team4561.robot.commands.AutoTankDriveForward;
//import org.usfirst.frc.team4561.robot.commands.AutoTankDriveLeft;
import org.usfirst.frc.team4561.robot.commands.TorqueGear;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
 
/**
 *
 */
public class AutoHighGoalBlue extends CommandGroup {
 
    public AutoHighGoalBlue() {
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
       
        //TODO: Change placeholders from 10 to something not trash
//    	addSequential(new GearCoverClose()); // make sure gear cover is down
//        addSequential(new TorqueGear()); // Go into high torque but low speed gear
//        addSequential(new DriveTankTimed(1, 1, 3)); // Forward
//        addSequential(new DriveTankTimed(1, 0, 3)); // Left 90
//        addSequential(new DriveTankTimed(1, 1, 3)); // Forward
//        addParallel(new AutoShootFullPower()); //spin up flywheel
//        addSequential(new WaitCommand(2));
//        addSequential(new SetAgitatorPower(1)); // Set Agitator to full power and FIRE AT WILL
    	
    	addSequential(new TorqueGear());
    	addSequential(new DriveTankTimed(1, 1, 0.65));
    	addSequential(new DriveTankTimed(-0.7, 0.7, 1.3));
    	addSequential(new DriveTankTimed(1, 1, 0.7));
//    	addSequential(new DriveTankTimed(-1, 1, 0.2));
//    	addSequential(new DriveTankTimed(1, 1, 0.68));
//    	addSequential(new DriveTankTimed(-1, -1, 0.16));
    	//addSequential(new DriveTankTimed(-1, -1, 0.5));
    	addParallel(new AutoShootFullPower()); //spin up flywheel
        addSequential(new WaitCommand(2));
        addSequential(new SetAgitatorPower(1));
    }
}