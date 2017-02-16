package org.usfirst.frc.team4561.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	// Motor ports
	public static final int FRONT_RIGHT_MOTOR_PORT = 2;
	public static final int FRONT_LEFT_MOTOR_PORT = 3;
	
	public static final int MID_RIGHT_MOTOR_PORT = 5;
	public static final int MID_LEFT_MOTOR_PORT = 1;
	
	public static final int REAR_RIGHT_MOTOR_PORT = 6;
	public static final int REAR_LEFT_MOTOR_PORT = 4;
	
	public static final int CLIMBER_MOTOR = 7;
	
	public static final int SHOOTER_LEFT_MOTOR_PORT = 8;
	public static final int SHOOTER_RIGHT_MOTOR_PORT = 9;
	
	public static final int AGITATOR_MOTOR_PORT = 10;
	
	//Solenoids and PCM
	public static final int PCM = 12;
	public static final int HOLDER_SOLENOID_PORT = 3;
	public static final int COVER_SOLENOID_PORT = 4;
	public static final int TRANSMISSION_SOLENOID_PORT = 0;
	public static final int TRANSMISSION_SOLENOID_TWO_PORT = 1;
	public static final String TRANSMISSION_SOLENOID_TYPE = "double"; // If this is "single", then transmission will use single solenoid.
	// Else, the transmission will use a double solenoid.
	
	// Joystick configuration
	public static final double RIGHT_JOYSTICK_DEAD_ZONE = 0.25;
	public static final double LEFT_JOYSTICK_DEAD_ZONE = 0.25;
	public static final double RIGHT_JOYSTICK_REDUCTION = 0.25;
	public static final double LEFT_JOYSTICK_REDUCTION = 0.25;

	// MAIN DRIVER BUTTONS
	
	// Joystick ports
	public static final int RIGHT_JOYSTICK_PORT = 1;
	public static final int LEFT_JOYSTICK_PORT = 0;
	
	// Transmission buttons (left stick)
	public static final int TRANSMISSION_TORQUE_BUTTON = 4;
	public static final int TRANSMISSION_SPEED_BUTTON = 6;
	
	// Drivetrain buttons (left stick)
	public static final int FRONT_HEADING_BUTTON = 5;
	public static final int BACKWARD_HEADING_BUTTON = 3;
	
	// Gear manipulator buttons (both sticks)
	public static final int MAIN_GEAR_RELEASE_BUTTON_ONE = 1; // Left stick
	public static final int MAIN_GEAR_RELEASE_BUTTON_TWO = 1; // Right stick
	
	// Camera buttons (right stick)
	public static final int TOGGLE_CAMERA_BUTTON = 2;
	
	// SECONDARY OPERATOR BUTTONS
	
	// Controller port
	public static final int CONTROLLER_PORT = 2;
	
	// Gear Manipulator Infrared Sensor
	public static final int GEAR_DETECTOR_DIO = 0;
	
	// Gear manipulator buttons
	public static final int GEAR_COVER_OPEN_BUTTON = 1; //TODO: Button number
	public static final int GEAR_COVER_CLOSE_BUTTON = 2;//TODO: Button number
	public static final int GEAR_HOLDER_OPEN_BUTTON = 3; //TODO: Button number
	public static final int GEAR_HOLDER_CLOSE_BUTTON = 4; //TODO: Button number
	public static final int SERVO_OPEN_BUTTON = 5; // TODO: Button number
	public static final int SERVO_CLOSE_BUTTON = 6; // TODO: Button number
	
	// Shooter buttons
	public static final int SHOOTER_ON_BUTTON = 7;
	public static final int SHOOTER_OFF_BUTTON = 8;
	
	// Agitator buttons
	public static final int AGITATOR_FORWARD_BUTTON = 9;
	public static final int AGITATOR_OFF_BUTTON = 10;
	public static final int AGITATOR_BACKWARD_BUTTON = 11;
	
	// Climber buttons
	public static final int CLIMBER_ON_BUTTON = 12;
	
	// Test mode button (left stick)
	public static final int TEST_MODE_BUTTON = 1;
	
	//Debug mode button (right stick)
	public static final int DEBUG_MODE_BUTTON = 12;
	
	// Verbose Flags
	public static final boolean MASTER_VERBOSE = false;
	public static final boolean AGITATOR_VERBOSE = false || MASTER_VERBOSE;
	public static final boolean DRIVETRAIN_VERBOSE = false || MASTER_VERBOSE;
	public static final boolean GEAR_MANIPULATOR_VERBOSE = false || MASTER_VERBOSE;	//TODO: should there be a verbose for this?
	public static final boolean INTAKE_VERBOSE = false || MASTER_VERBOSE;
	public static final boolean ROPE_CLIMBER_VERBOSE = false || MASTER_VERBOSE;
	public static final boolean SHOOTER_VERBOSE = false || MASTER_VERBOSE;
	public static final boolean TRANSMISSION_VERBOSE = false || MASTER_VERBOSE;		//TODO: should there be a verbose for this?
	
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;	

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}