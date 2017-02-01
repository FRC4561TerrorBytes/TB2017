package org.usfirst.frc.team4561.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	// Motor ports
	public static final int FRONT_RIGHT_MOTOR_PORT = 0;//TODO: Find Port
	public static final int FRONT_LEFT_MOTOR_PORT = 9; //TODO: Find Port
	public static final int REAR_RIGHT_MOTOR_PORT = 10; //TODO: Find Port
	public static final int REAR_LEFT_MOTOR_PORT = 3; //TODO: Find Port
	public static final int MID_RIGHT_MOTOR_PORT = 4; //TODO: Find Port
	public static final int MID_LEFT_MOTOR_PORT = 5; //TODO: Find Port
	public static final int CLIMBER_MOTOR = 6; //TODO: Find Port
	public static final int LEFT_INTAKE_MOTOR_PORT = 7; //TODO: Find Port
	public static final int RIGHT_INTAKE_MOTOR_PORT = 8; //TODO: Find Port
	public static final int SHOOTER_LEFT_MOTOR_PORT = 1; //TODO: Find port
	public static final int SHOOTER_RIGHT_MOTOR_PORT = 2; //TODO: Find Port
	public static final int AGITATOR_MOTOR_PORT = 11; //TODO: Find Port
	
	//Solenoids and PCM
	public static final int PCM = 3;
	public static final int HOLDER_SOLENOID_PORT = 0;
	public static final int COVER_SOLENOID_PORT = 1;
	public static final int TRANSMISSION_SOLENOID_PORT = 2;
	
	// Joystick ports
	public static final int RIGHT_JOYSTICK_PORT = 0;
	public static final int LEFT_JOYSTICK_PORT = 1;
	
	// Joystick configuration
	public static final double RIGHT_JOYSTICK_DEAD_ZONE = 0.25;	
	public static final double LEFT_JOYSTICK_DEAD_ZONE = 0.25;
	public static final double RIGHT_JOYSTICK_REDUCTION = 0.25;
	public static final double LEFT_JOYSTICK_REDUCTION = 0.25;
	
	// Rope buttons
	public static final int CLIMB_BUTTON = 1; //TODO: Port number
	
	// Gear buttons
	public static final int GEAR_IN_BUTTON = 1; //TODO: Port number
	public static final int GEAR_OUT_BUTTON = 1; //TODO: Port number
	public static final int GEAR_COVER_CLOSE_BUTTON = 1;//TODO: Port number
	public static final int GEAR_COVER_OPEN_BUTTON = 1; //TODO: Port number

	// Intake buttons
	public static final int INTAKE_BUTTON = 1; // TODO: Find port
	
	// Shooter buttons
	public static final int SHOOT_BUTTON = 1; //TODO: Find port
	
	// Agitator buttons
	public static final int AGITATOR_FWD_BUTTON = 1; // TODO: Find port
	public static final int AGITATOR_REV_BUTTON = 1; // TODO: Find port

	// Transmission buttons
	public static final int TRANSMISSION_TORQUE_BUTTON = 1; // TODO: Find port
	public static final int TRANSMISSION_SPEED_BUTTON = 1; // TODO: Find port
	
	// Verbose Flags
	public static final boolean MASTER_VERBOSE = false;
	public static final boolean AGITATOR_VERBOSE = false || MASTER_VERBOSE;
	public static final boolean DRIVETRAIN_VERBOSE = false || MASTER_VERBOSE;
	public static final boolean GEAR_MANIPULATOR_VERBOSE = false || MASTER_VERBOSE;	//TODO: should there be a verbose for this?
	public static final boolean INTAKE_VERBOSE = false || MASTER_VERBOSE;
	public static final boolean ROPE_CLIMBER_VERBOSE = false || MASTER_VERBOSE;
	public static final boolean SHOOTER_VERBOSE = false || MASTER_VERBOSE;
	public static final boolean TRANSMISSION_VERBOSE = false || MASTER_VERBOSE;		//TODO: should there be a verbose for this?
	
	// Left stick
	public static final int DEBUG_MODE_BUTTON = 1; // This is the actual port, not a placeholder
	
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;	

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}