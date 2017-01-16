package org.usfirst.frc.team4561.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;											//imports libraries
import org.usfirst.frc.team4561.robot.RobotMap;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive; 
import org.usfirst.team4561.robot.commands.ArcadeDrive;

public class DriveTrain extends Subsystem 
{
	CANTalon FrontRight = new CANTalon(RobotMap.FRONT_RIGHT_MOTOR_PORT);				//sets front motor ports
	CANTalon FrontLeft = new CANTalon(RobotMap.FRONT_LEFT_MOTOR_PORT);			
	CANTalon RearRight = new CANTalon(RobotMap.REAR_RIGHT_MOTOR_PORT);					//sets rear motor ports
	CANTalon RearLeft = new CANTalon(RobotMap.REAR_LEFT_MOTOR_PORT);
	
	RobotDrive robotDrive = new RobotDrive(FrontLeft, RearLeft, FrontRight, RearRight);	//puts motors into robot drive class
	
;    public void initDefaultCommand() 
    {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
	setDefaultCommand(new ArcadeDrive());
    }
public void arcadeDrive(double drive, double rot ) {
	robotDrive.arcadeDrive(drive, rot);
}
}
//TODO find stuff out         