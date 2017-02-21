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
       
        //TODO: Change placeholders from 10 to something not trash
    	addSequential(new GearCoverClose()); // make sure gear cover is down
        addSequential(new TorqueGear()); // Go into high torque but low speed gear
        addSequential(new DriveTankTimed(1, 1, 10)); // Forward
        addSequential(new DriveTankTimed(1, 0, 10)); // Left 90
        addSequential(new DriveTankTimed(1, 1, 10)); // Forward
        addSequential(new AutoShootFullPower()); //spin up flywheel
        addSequential(new SetAgitatorPower(1)); // Set Agitator to full power and FIRE AT WILL
    }
}