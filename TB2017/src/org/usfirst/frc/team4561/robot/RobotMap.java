package org.usfirst.frc.team4561.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	// Motor ports (CAN)
	public static final int FRONT_RIGHT_MOTOR_PORT = 0;		//TODO: Port number
	public static final int FRONT_LEFT_MOTOR_PORT = 1;		//TODO: Port number
	public static final int REAR_RIGHT_MOTOR_PORT = 2;		//TODO: Port number
	public static final int REAR_LEFT_MOTOR_PORT = 3;		//TODO: Port number
	public static final int CLIMBER_MOTOR = 4;				//TODO: Port number
	public static final int LEFT_INTAKE_MOTOR_PORT = 5;		//TODO: Port number
	public static final int RIGHT_INTAKE_MOTOR_PORT = 6;	//TODO: Port number
	public static final int SHOOTER_LEFT_MOTOR_PORT = 7;	//TODO: Port number
	public static final int SHOOTER_RIGHT_MOTOR_PORT = 8;	//TODO: Port number
	public static final int MID_RIGHT_MOTOR_PORT = 0;		//TODO: Port number
	public static final int MID_LEFT_MOTOR_PORT = 0;		//TODO: Port number
	
	
	// Joystick ports (USB)
	public static final int RIGHT_JOYSTICK = 0;
	public static final int LEFT_JOYSTICK = 1;
	
	// Joystick config
	public static final double RIGHT_JOYSTICK_DEAD_ZONE = 0.25;	//TODO: Test
	public static final double LEFT_JOYSTICK_DEAD_ZONE = 0.25;	//TODO: Test
	public static final double RIGHT_JOYSTICK_REDUCTION = 0.25;	//TODO: Test
	public static final double LEFT_JOYSTICK_REDUCTION = 0.25;	//TODO: Test
	
	// Rope buttons
	public static final int ROPE_UP_BUTTON = 0;			//TODO: Port number
	public static final int ROPE_DOWN_BUTTON = 0;		//TODO: Port number
	public static final int CLIMBER_LIMIT_SWITCH = 0;	//TODO: Port number
	public static final int SHOOT_BUTTON = 9;			//TODO: Port number
	
	// Gear buttons
	public static final int GEAR_IN_BUTTON = 0;			//TODO: Port number
	public static final int GEAR_OUT_BUTTON = 0;		//TODO: Port number
	
	// Intake button
	public static final int INTAKE_BUTTON_PORT = 0;		//TODO: Port number
	
	
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;	

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
