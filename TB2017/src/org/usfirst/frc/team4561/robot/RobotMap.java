package org.usfirst.frc.team4561.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap 
{
	//MOTOR CONFIGURATION
	public static final int FRONT_RIGHT_MOTOR_PORT = 0;							//sets motor ports
	public static final int FRONT_LEFT_MOTOR_PORT = 1;
	public static final int REAR_RIGHT_MOTOR_PORT = 2;
	public static final int REAR_LEFT_MOTOR_PORT = 3;
	
	//JOYSTICK CONFIGURATION
	public static final int RIGHT_JOYSTICK = 0;									//sets joystick ports
	public static final int LEFT_JOYSTICK = 1;
	
	public static final double RIGHT_JOYSTICK_DEAD_ZONE = 0.25;					//sets joystick deadzone values
	public static final double LEFT_JOYSTICK_DEAD_ZONE = 0.25;
	public static final double RIGHT_JOYSTICK_REDUCTION = 0.25;					//sets joystick reduction values
	public static final double LEFT_JOYSTICK_REDUCTION = 0.25;
	
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;	

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
