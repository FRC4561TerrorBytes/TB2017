package org.usfirst.frc.team4561.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4561.robot.commands.GearCoverClose;
import org.usfirst.frc.team4561.robot.commands.GearCoverOpen;
import org.usfirst.frc.team4561.robot.commands.IntakeBall;
import org.usfirst.frc.team4561.robot.commands.PrintInfrared;
import org.usfirst.frc.team4561.robot.commands.ServoClose;
import org.usfirst.frc.team4561.robot.commands.ServoOpen;
import org.usfirst.frc.team4561.robot.commands.GearHolderClose;
import org.usfirst.frc.team4561.robot.commands.GearHolderOpen;
import org.usfirst.frc.team4561.robot.commands.Climb;
import org.usfirst.frc.team4561.robot.commands.DebugButton;
import org.usfirst.frc.team4561.robot.commands.DoNothing;
import org.usfirst.frc.team4561.robot.commands.DriveHeadingForward;
import org.usfirst.frc.team4561.robot.commands.DriveHeadingBackward;
import org.usfirst.frc.team4561.robot.commands.TestMode;
import org.usfirst.frc.team4561.robot.commands.ToggleCamera;
import org.usfirst.frc.team4561.robot.commands.SetAgitatorPower;
import org.usfirst.frc.team4561.robot.commands.Shoot;
import org.usfirst.frc.team4561.robot.commands.SpeedGear;
import org.usfirst.frc.team4561.robot.commands.TorqueGear;
import org.usfirst.frc.team4561.robot.triggers.BothJoystickTriggers;
import org.usfirst.frc.team4561.robot.triggers.GearDetectorTrigger;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	// Joystick declaration
	private static Joystick rightStick = new Joystick(RobotMap.RIGHT_JOYSTICK_PORT);
	private static Joystick leftStick = new Joystick(RobotMap.LEFT_JOYSTICK_PORT);
	private static Joystick controller = new Joystick(RobotMap.CONTROLLER_PORT);
	
	// MAIN DRIVER BUTTONS
	private JoystickButton shiftSpeedButton = new JoystickButton(leftStick, RobotMap.TRANSMISSION_SPEED_BUTTON);
	private JoystickButton shiftTorqueButton = new JoystickButton(leftStick, RobotMap.TRANSMISSION_TORQUE_BUTTON);
	
	private JoystickButton driveHeadingForward = new JoystickButton(rightStick, RobotMap.FRONT_HEADING_BUTTON);
	private JoystickButton driveHeadingBackward = new JoystickButton(rightStick, RobotMap.BACKWARD_HEADING_BUTTON);
	
	private BothJoystickTriggers mainGearReleaseButton = new BothJoystickTriggers();
	
	private JoystickButton cameraToggleButton = new JoystickButton(rightStick, RobotMap.TOGGLE_CAMERA_BUTTON);
	
	// SECONDARY OPERATOR BUTTONS
	private JoystickButton gearCoverOpenButton = new JoystickButton(controller, RobotMap.GEAR_COVER_OPEN_BUTTON);
	private JoystickButton gearCoverCloseButton = new JoystickButton(controller, RobotMap.GEAR_COVER_CLOSE_BUTTON);
	private JoystickButton gearHolderOpenButton = new JoystickButton(controller, RobotMap.GEAR_HOLDER_CLOSE_BUTTON);
	private JoystickButton gearHolderCloseButton = new JoystickButton(controller, RobotMap.GEAR_HOLDER_OPEN_BUTTON);
	
	private JoystickButton openServoButton = new JoystickButton(controller, RobotMap.SERVO_OPEN_BUTTON);
	private JoystickButton closeServoButton = new JoystickButton(controller, RobotMap.SERVO_CLOSE_BUTTON);
	
	private JoystickButton shooterOnButton = new JoystickButton(controller, RobotMap.SHOOTER_ON_BUTTON);
	private JoystickButton shooterOffButton = new JoystickButton(controller, RobotMap.SHOOTER_OFF_BUTTON);
	
	private JoystickButton agitatorForwardButton = new JoystickButton(controller, RobotMap.AGITATOR_FORWARD_BUTTON);
	private JoystickButton agitatorOffButton = new JoystickButton(controller, RobotMap.AGITATOR_OFF_BUTTON);
	private JoystickButton agitatorBackwardButton = new JoystickButton(controller, RobotMap.AGITATOR_BACKWARD_BUTTON);
	
	// Test mode button
	private JoystickButton testModeButton = new JoystickButton(rightStick, RobotMap.TEST_MODE_BUTTON);
	
	//Debug mode button
	private JoystickButton debugModeButton = new JoystickButton(rightStick, RobotMap.DEBUG_MODE_BUTTON);
	
	private GearDetectorTrigger gearDetectorTrigger = new GearDetectorTrigger();
	
	public OI() {
		if (DriverStation.getInstance().isTest()){
			testMode();
		}
		else{
			matchMode();
		}
	}
	
	/**
	 * Assigns buttons to match configuration.
	 * @see {@link #testMode() testMode}
	 * @author Kaiz
	 */
	public void matchMode() {
		testModeButton.whenPressed(new DoNothing());
		debugModeButton.whenPressed(new DebugButton());
		
		shiftSpeedButton.whenPressed(new SpeedGear());
		shiftTorqueButton.whenPressed(new TorqueGear());
		
		driveHeadingForward.whenPressed(new DriveHeadingForward());
		driveHeadingBackward.whenPressed(new DriveHeadingBackward());
		
		mainGearReleaseButton.whenActive(new GearHolderClose());
		
		cameraToggleButton.whenPressed(new ToggleCamera());
		
		gearCoverOpenButton.whenPressed(new GearCoverOpen());
		gearCoverCloseButton.whenPressed(new GearCoverClose());
		gearHolderOpenButton.whenPressed(new GearHolderOpen());
		gearHolderCloseButton.whenPressed(new GearHolderClose());
		
		openServoButton.whenPressed(new ServoOpen());
		closeServoButton.whenPressed(new ServoClose());
		
		Shoot shootCommand = new Shoot();
		
		shooterOnButton.whenPressed(shootCommand);
		shooterOffButton.cancelWhenPressed(shootCommand);
		
		agitatorForwardButton.whenPressed(new SetAgitatorPower(1));
		agitatorOffButton.whenPressed(new SetAgitatorPower(0));
		agitatorBackwardButton.whileHeld(new SetAgitatorPower(-1));
		
		gearDetectorTrigger.whenActive(new PrintInfrared());
	}
	
	/**
	 * Assigns buttons to test configuration.
	 * @see {@link #matchMode() matchMode}
	 * @author Kaiz
	 */
	public void testMode() {
		// Reassign left trigger on left joystick to run motor while in test mode
		testModeButton.whenPressed(new TestMode());
		System.out.println("Not insane");
	}
	
	// Joystick inputs
	/**
	 * Get the value given by the right stick's Y-axis. Applies dead zone and reduction.
     * @return double Right joystick's Y-axis, -1...1
     * @see {@link #getRightStickX() getRightStickX}
     * @see {@link #getLeftStickY() getLeftStickY}
     * @see {@link #getLeftStickX() getLeftStickX}
     * @author Kaiz
	 */
	public double getRightStickY() {
		double rightStickY = rightStick.getY();
		
		// Dead zone management
		if (Math.abs(rightStick.getMagnitude()) < RobotMap.RIGHT_JOYSTICK_DEAD_ZONE) {
			rightStickY = 0;
		}
		
		// Reductions - joystick reduction reduces velocity from given joystick direction
		if (rightStickY > 0) {
			rightStickY = (rightStickY - RobotMap.RIGHT_JOYSTICK_REDUCTION) * (1/(1-RobotMap.LEFT_JOYSTICK_REDUCTION));
			if (rightStickY < 0) {
				rightStickY = 0;
			}
		} else if (rightStickY < 0) {
			rightStickY = (rightStickY + RobotMap.RIGHT_JOYSTICK_REDUCTION) * (1/(1-RobotMap.LEFT_JOYSTICK_REDUCTION));
			if (rightStickY > 0) 
			{
				rightStickY = 0;
			}
		}
		return rightStickY;
	}

	/**
	 * Get the value given by the right stick's X-axis. Applies dead zone and reduction.
     * @return double Right joystick's X-axis, -1...1
     * @see {@link #getRightStickY() getRightStickY}
     * @see {@link #getLeftStickY() getLeftStickY}
     * @see {@link #getLeftStickX() getLeftStickX}
     * @author Kaiz
	 */
	public double getRightStickX() {
		double rightStickX = rightStick.getX();
		
		// Dead zone management
		if (Math.abs(rightStick.getMagnitude()) < RobotMap.RIGHT_JOYSTICK_DEAD_ZONE) {
			rightStickX = 0;
		}
		
		// Reductions
		if (rightStickX > 0) {
			rightStickX = (rightStickX - RobotMap.RIGHT_JOYSTICK_REDUCTION) * (1/(1-RobotMap.LEFT_JOYSTICK_REDUCTION));
			if (rightStickX < 0) {
				rightStickX = 0;
			}
		} else if (rightStickX < 0) {
			rightStickX = (rightStickX + RobotMap.RIGHT_JOYSTICK_REDUCTION) * (1/(1-RobotMap.LEFT_JOYSTICK_REDUCTION));
			if (rightStickX > 0) {
				rightStickX = 0;
			}
		}
		return rightStickX;
	}
	
	/**
	 * Get the value given by the left stick's Y-axis. Applies dead zone and reduction.
     * @return double Left joystick's Y-axis , -1...1
     * @see {@link #getRightStickY() getRightStickY}
     * @see {@link #getRightStickX() getRightStickX}
     * @see {@link #getLeftStickX() getLeftStickX}
     * @author Kaiz
	 */
	public double getLeftStickY() {
		double leftStickY = leftStick.getY();
		
		// Dead zone management
		if (Math.abs(leftStick.getMagnitude()) < RobotMap.LEFT_JOYSTICK_DEAD_ZONE) {
			leftStickY = 0;
		}
		
		// Reductions
		if (leftStickY > 0) {
			leftStickY = (leftStickY - RobotMap.LEFT_JOYSTICK_REDUCTION) * (1/(1-RobotMap.LEFT_JOYSTICK_REDUCTION));
			if(leftStickY < 0) {
				leftStickY = 0;
			}
		} else if (leftStickY < 0) {
			leftStickY = (leftStickY + RobotMap.LEFT_JOYSTICK_REDUCTION) * (1/(1-RobotMap.LEFT_JOYSTICK_REDUCTION));
			if (leftStickY > 0) {
				leftStickY = 0;
			}
		}
		return leftStickY;
	}
	
	/**
	 * Get the value given by the left stick's X-axis. Applies dead zone and reduction.
     * @return double Left joystick's X-axis, -1...1
     * @see {@link #getRightStickY() getRightStickY}
     * @see {@link #getRightStickX() getRightStickX}
     * @see {@link #getLeftStickY() getLeftStickY}
     * @author Kaiz
	 */
	public double getLeftStickX() {
		double leftStickX = leftStick.getX();
		
		// Dead zone management
		if (Math.abs(leftStick.getMagnitude()) < RobotMap.LEFT_JOYSTICK_DEAD_ZONE) {
			leftStickX = 0;
		}
		
		// Reductions
		if (leftStickX > 0) {
			leftStickX = (leftStickX - RobotMap.LEFT_JOYSTICK_REDUCTION) * (1/(1-RobotMap.LEFT_JOYSTICK_REDUCTION));
			if(leftStickX < 0){
				leftStickX = 0;
			}
		} else if (leftStickX < 0) {
			leftStickX = (leftStickX + RobotMap.LEFT_JOYSTICK_REDUCTION) * (1/(1-RobotMap.LEFT_JOYSTICK_REDUCTION));
			if(leftStickX > 0) {
				leftStickX = 0;
			}
		}
		return leftStickX;
	}
	
	/**
	 * Gets the position of the throttle on the left joystick.
	 * @return Throttle on the left stick -1...1
	 * @see {@link #getRightStickThrottle() getRightStickThrottle}
	 * @author Kaiz
	 */
	public double getLeftStickThrottle() {
		return leftStick.getThrottle();
	}
	
	/**
	 * Gets the position of the throttle on the right joystick.
	 * @return Throttle on the right stick -1...1
	 * @see {@link #getLeftStickThrottle() getLeftStickThrottle}
	 * @author Kaiz
	 */
	public double getRightStickThrottle() {
		return rightStick.getThrottle();
	}
	
	/**
	 * Gets the state of the top button on the "Basic" tab of the Dashboard.
	 * @return boolean State of the button
	 * @author Kaiz
	 */
	public boolean getDashboardButton0() {
		return SmartDashboard.getBoolean("DB/Button 0", false);
	}
	
	/**
	 * Gets the state of the second button on the "Basic" tab of the Dashboard.
	 * @return boolean State of the button
	 * @author Kaiz
	 */
	public boolean getDashboardButton1() {
		return SmartDashboard.getBoolean("DB/Button 1", false);
	}
	
	/**
	 * Gets the state of the third button on the "Basic" tab of the Dashboard.
	 * @return boolean State of the button
	 * @author Kaiz
	 */
	public boolean getDashboardButton2() {
		return SmartDashboard.getBoolean("DB/Button 2", false);
	}
	
	/**
	 * Gets the state of the last button on the "Basic" tab of the Dashboard.
	 * @return boolean State of the button
	 * @author Kaiz
	 */
	public boolean getDashboardButton3() {
		return SmartDashboard.getBoolean("DB/Button 3", false);
	}
	
	/**
	 * Gets the number on the first slider on the "Basic" tab of the Dashboard.
	 * @return double Number on the slider
	 * @author Kaiz
	 */
	public double getDashboardSlider0() {
		return SmartDashboard.getNumber("DB/Slider 0", 0);
	}
	
	/**
	 * Gets the number on the second slider on the "Basic" tab of the Dashboard.
	 * @return double Number on the slider
	 * @author Kaiz
	 */
	public double getDashboardSlider1() {
		return SmartDashboard.getNumber("DB/Slider 1", 0);
	}
	
	/**
	 * Gets the number on the third slider on the "Basic" tab of the Dashboard.
	 * @return double Number on the slider
	 * @author Kaiz
	 */
	public double getDashboardSlider2() {
		return SmartDashboard.getNumber("DB/Slider 2", 0);
	}
	
	/**
	 * Gets the number on the last slider on the "Basic" tab of the Dashboard.
	 * @return double Number on the slider
	 * @author Kaiz
	 */
	public double getDashboardSlider3() {
		return SmartDashboard.getNumber("DB/Slider 3", 0);
	}
	
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
