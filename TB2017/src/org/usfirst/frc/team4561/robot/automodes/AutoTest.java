package org.usfirst.frc.team4561.robot.automodes;

import org.usfirst.frc.team4561.robot.commands.DriveTankTimed;
import org.usfirst.frc.team4561.robot.commands.GearCoverClose;
import org.usfirst.frc.team4561.robot.commands.GearCoverOpen;
import org.usfirst.frc.team4561.robot.commands.GearHolderClose;
import org.usfirst.frc.team4561.robot.commands.GearHolderOpen;
import org.usfirst.frc.team4561.robot.commands.ToggleDriveTrainPIDOff;
import org.usfirst.frc.team4561.robot.commands.ToggleDriveTrainPIDOn;
import org.usfirst.frc.team4561.robot.commands.TorqueGear;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class AutoTest extends CommandGroup {

    public AutoTest() {
    	addSequential(new ToggleDriveTrainPIDOn());
    	addSequential(new GearHolderClose());
    	addSequential(new GearCoverClose());
    	addSequential(new TorqueGear());
    	//addSequential(new WaitCommand(0.5)); relying on TorqueGear delay
    	//addSequential(new DriveTankTimed(0.8, 0.8, 1.5));
    	addSequential(new DriveTankTimed(0.65, 0.65, 1.2));
    	//addSequential(new WaitCommand(1));
    	addSequential(new DriveTankTimed(0, .25 , .2));
    	int i = 0;				//create counter
        while(i <= 5)
        {
        	addSequential(new DriveTankTimed(.5, 0, .2));	//move left side
        	addSequential(new DriveTankTimed(0, .5 , .2));	//m	ove right side
        	i++;				//increment counter
        }
    	addSequential(new GearHolderOpen());
    	addSequential(new WaitCommand(0.5));
    	addSequential(new GearCoverOpen());
    	addSequential(new DriveTankTimed(-0.65, -0.65, 1));
    	addSequential(new ToggleDriveTrainPIDOff());
    	
    	
//        addSequential(new DriveTankTimed(-0.4, 0.4, 1.18)); // 90 DEGREES
//        int i = 0;				//create counter
//        while(i <= 5)
//        {
//        	addSequential(new DriveTankTimed(.1 , 0, .2));	//move left side
//        	addSequential(new WaitCommand(.3));
//        	addSequential(new DriveTankTimed(0, .1 , .2));	//m	ove right side
//        	i++;				//increment counter
//        }
//        addSequential(new ToggleDriveTrainPIDOff());
    }
}
