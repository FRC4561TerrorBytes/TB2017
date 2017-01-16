package org.usfirst.frc.team4561.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;											//imports libraries
import org.usfirst.frc.team4561.robot.RobotMap;
import org.usfirst.frc.team4561.robot.commands.ArcadeDrive;
import org.usfirst.frc.team4561.robot.commands.TankDrive;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive; 

public class DriveTrain extends Subsystem 
{
	CANTalon FrontRight = new CANTalon(RobotMap.FRONT_RIGHT_MOTOR_PORT);				//sets front motor ports
	CANTalon FrontLeft = new CANTalon(RobotMap.FRONT_LEFT_MOTOR_PORT);
	CANTalon MidRight = new CANTalon(RobotMap.MID_RIGHT_MOTOR_PORT);
	CANTalon MidLeft = new CANTalon(RobotMap.MID_LEFT_MOTOR_PORT);
	CANTalon RearRight = new CANTalon(RobotMap.REAR_RIGHT_MOTOR_PORT);					//sets rear motor ports
	CANTalon RearLeft = new CANTalon(RobotMap.REAR_LEFT_MOTOR_PORT);
	
	RobotDrive robotDrive = new RobotDrive(FrontLeft, FrontRight);	//puts motors into robot drive class
	public DriveTrain(){
		MidRight.changeControlMode(CANTalon.TalonControlMode.Follower);
		MidRight.set(RobotMap.FRONT_RIGHT_MOTOR_PORT);
		RearRight.changeControlMode(CANTalon.TalonControlMode.Follower);
		RearRight.set(RobotMap.FRONT_RIGHT_MOTOR_PORT);
		MidLeft.changeControlMode(CANTalon.TalonControlMode.Follower);
		MidLeft.set(RobotMap.FRONT_LEFT_MOTOR_PORT);
		RearLeft.changeControlMode(CANTalon.TalonControlMode.Follower);
		RearLeft.set(RobotMap.FRONT_LEFT_MOTOR_PORT);
	}
    public void initDefaultCommand() 
    {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
	setDefaultCommand(new TankDrive());
    }
public void arcadeDrive(double drive, double rot ) {
	robotDrive.arcadeDrive(drive, rot);
}
public void tankDrive(double x, double y){
	robotDrive.tankDrive(x, y);
}
}
//TODO find stuff out         