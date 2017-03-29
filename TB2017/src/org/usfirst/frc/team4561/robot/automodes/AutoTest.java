package org.usfirst.frc.team4561.robot.automodes;

import org.usfirst.frc.team4561.robot.commands.DriveTankTimed;
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
        addSequential(new TorqueGear());
        addSequential(new DriveTankTimed(-0.4, 0.4, 1.18));
        int i = 0;				//create counter
        while(i <= 5)
        {
        	addSequential(new DriveTankTimed(.1 , 0, .2));	//move left side
        	addSequential(new WaitCommand(.3));
        	addSequential(new DriveTankTimed(0, .1 , .2));	//move right side
        	i++;				//increment counter
        }
        addSequential(new ToggleDriveTrainPIDOff());
    }
}
