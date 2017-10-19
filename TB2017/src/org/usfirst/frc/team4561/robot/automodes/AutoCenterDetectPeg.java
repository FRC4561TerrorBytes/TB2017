package org.usfirst.frc.team4561.robot.automodes;

import org.usfirst.frc.team4561.robot.Robot;
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
public class AutoCenterDetectPeg extends CommandGroup {

	@Override
	protected void initialize() {
		System.out.println("starting auto center detect peg");
	}
	
    public AutoCenterDetectPeg() {
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
        addSequential(new WaitCommand(0.1));
        addSequential(new AutoCheckStopCenterDetect(new AutoDoNothing(), new AutoCheckPeg(new AutoEndCenterDetectPegFirst(), new AutoTryAgainLeft())));
        addSequential(new AutoCheckStopCenterDetect(new AutoDoNothing(), new AutoCheckPeg(new AutoEndCenterDetectPeg(), new AutoTryAgainLeft())));
        addSequential(new AutoCheckStopCenterDetect(new AutoDoNothing(), new AutoCheckPeg(new AutoEndCenterDetectPeg(), new AutoTryAgainRight())));
        addSequential(new AutoCheckStopCenterDetect(new AutoDoNothing(), new AutoCheckPeg(new AutoEndCenterDetectPeg(), new AutoTryAgainRight())));
        addSequential(new AutoCheckStopCenterDetect(new AutoDoNothing(), new AutoCheckPeg(new AutoEndCenterDetectPeg(), new AutoTryAgainRight())));
        addSequential(new AutoCheckStopCenterDetect(new AutoDoNothing(), new AutoCheckPeg(new AutoEndCenterDetectPeg(), new AutoTryAgainRight())));
        addSequential(new AutoCheckStopCenterDetect(new AutoDoNothing(), new AutoCheckPeg(new AutoEndCenterDetectPeg(), new AutoTryAgainLeft())));
        addSequential(new AutoCheckStopCenterDetect(new AutoDoNothing(), new AutoCheckPeg(new AutoEndCenterDetectPeg(), new AutoTryAgainLeft())));
        addSequential(new AutoCheckStopCenterDetect(new AutoDoNothing(), new AutoCheckPeg(new AutoEndCenterDetectPeg(), new AutoTryAgainLeft())));
        addSequential(new AutoCheckStopCenterDetect(new AutoDoNothing(), new AutoCheckPeg(new AutoEndCenterDetectPeg(), new AutoTryAgainLeft())));
        addSequential(new AutoCheckStopCenterDetect(new AutoDoNothing(), new AutoCheckPeg(new AutoEndCenterDetectPeg(), new AutoTryAgainLeft())));
        addSequential(new AutoCheckStopCenterDetect(new AutoDoNothing(), new AutoCheckPeg(new AutoEndCenterDetectPeg(), new AutoTryAgainRight())));
        addSequential(new AutoCheckStopCenterDetect(new AutoDoNothing(), new AutoCheckPeg(new AutoEndCenterDetectPeg(), new AutoTryAgainRight())));
        addSequential(new AutoCheckStopCenterDetect(new AutoDoNothing(), new AutoCheckPeg(new AutoEndCenterDetectPeg(), new AutoTryAgainRight())));
        addSequential(new AutoCheckStopCenterDetect(new AutoDoNothing(), new AutoCheckPeg(new AutoEndCenterDetectPeg(), new AutoTryAgainRight())));
        addSequential(new AutoCheckStopCenterDetect(new AutoDoNothing(), new AutoCheckPeg(new AutoEndCenterDetectPeg(), new AutoTryAgainLeft())));
        addSequential(new AutoCheckStopCenterDetect(new AutoDoNothing(), new AutoCheckPeg(new AutoEndCenterDetectPeg(), new AutoTryAgainLeft())));
        addSequential(new AutoCheckStopCenterDetect(new AutoDoNothing(), new AutoCheckPeg(new AutoEndCenterDetectPeg(), new AutoTryAgainLeft())));
        addSequential(new AutoCheckStopCenterDetect(new AutoDoNothing(), new AutoCheckPeg(new AutoEndCenterDetectPeg(), new AutoTryAgainLeft())));
        addSequential(new AutoCheckStopCenterDetect(new AutoDoNothing(), new AutoCheckPeg(new AutoEndCenterDetectPeg(), new AutoTryAgainLeft())));
        addSequential(new AutoCheckStopCenterDetect(new AutoDoNothing(), new AutoCheckPeg(new AutoEndCenterDetectPeg(), new AutoTryAgainRight())));
        addSequential(new AutoCheckStopCenterDetect(new AutoDoNothing(), new AutoCheckPeg(new AutoEndCenterDetectPeg(), new AutoTryAgainRight())));
        addSequential(new AutoCheckStopCenterDetect(new AutoDoNothing(), new AutoStopCenterDetect()));
        
        
        //        if (!Robot.gearManipulator.isPegDetected()) {
//	        for (int j = 2; j < 20; j++) {
//	        	if (j % 4 > 1) {
//	        		addSequential(new DriveTankTimed(-0.6, 0.6, 0.1));
//	        		addSequential(new DriveTankTimed(0.8, 0.8, 0.2));
//	        		addSequential(new WaitCommand(0.1));
//	        		System.out.println("going to check peg detected");
//	        		if (Robot.gearManipulator.isPegDetected()) {
//	        			System.out.println("detected peg");
//	        			addSequential(new DriveTankTimed(0.8, 0.8, 0.4));
//	        			break;
//	        		} else {
//	        			System.out.println("didn't detect peg");
//	        		}
//	        	} else {
//	        		addSequential(new DriveTankTimed(0.6, -0.6, 0.1));
//	        		addSequential(new DriveTankTimed(0.8, 0.8, 0.2));
//	        		addSequential(new WaitCommand(0.1));
//	        		System.out.println("going to check peg detected");
//	        		if (Robot.gearManipulator.isPegDetected()) {
//	        			System.out.println("detected peg");
//	        			addSequential(new DriveTankTimed(0.8, 0.8, 0.4));
//	        			break;
//	        		} else {
//	        			System.out.println("didn't detect peg");
//	        		}
//	        	}
//	        	addSequential(new DriveTankTimed(-0.8, -0.8, 0.1));
//	        	System.out.println("looping again");
//	        }
//        }
        
      
    	
    	
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
