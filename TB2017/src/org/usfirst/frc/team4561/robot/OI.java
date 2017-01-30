package org.usfirst.frc.team4561.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team4561.robot.commands.GearCoverClose;
import org.usfirst.frc.team4561.robot.commands.GearCoverOpen;
import org.usfirst.frc.team4561.robot.commands.IntakeBall;
import org.usfirst.frc.team4561.robot.commands.GearHolderClose;
import org.usfirst.frc.team4561.robot.commands.GearHolderOpen;
import org.usfirst.frc.team4561.robot.commands.Climb;
import org.usfirst.frc.team4561.robot.commands.SetAgitatorPower;
import org.usfirst.frc.team4561.robot.commands.Shoot;
import org.usfirst.frc.team4561.robot.commands.SpeedGear;
import org.usfirst.frc.team4561.robot.commands.TorqueGear;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	// Joystick declaration
	private static Joystick rightStick = new Joystick(RobotMap.RIGHT_JOYSTICK_PORT);
	private static Joystick leftStick = new Joystick(RobotMap.LEFT_JOYSTICK_PORT);
	
	// Button declaration
	private JoystickButton shootButton = new JoystickButton(rightStick, RobotMap.SHOOT_BUTTON);
	
	private JoystickButton climbButton = new JoystickButton(rightStick, RobotMap.CLIMB_BUTTON);
	
	private JoystickButton gearInButton = new JoystickButton(rightStick, RobotMap.GEAR_IN_BUTTON);
	private JoystickButton gearOutButton = new JoystickButton(rightStick, RobotMap.GEAR_OUT_BUTTON);
	private JoystickButton gearCoverCloseButton = new JoystickButton(rightStick, RobotMap.GEAR_COVER_CLOSE_BUTTON);
	private JoystickButton gearCoverOpenButton = new JoystickButton(rightStick, RobotMap.GEAR_COVER_OPEN_BUTTON);
	
	private JoystickButton intakeButton = new JoystickButton(rightStick, RobotMap.INTAKE_BUTTON);
	
	private JoystickButton agitatorForwardButton = new JoystickButton(rightStick, RobotMap.AGITATOR_FWD_BUTTON);
	private JoystickButton agitatorReverseButton = new JoystickButton(rightStick, RobotMap.AGITATOR_REV_BUTTON);
	
	private JoystickButton transmissionTorqueButton = new JoystickButton(rightStick, RobotMap.TRANSMISSION_TORQUE_BUTTON);
	private JoystickButton transmissionSpeedButton = new JoystickButton(rightStick, RobotMap.TRANSMISSION_SPEED_BUTTON);
	
	public OI() {
		
		//Initializing buttons
		shootButton.whileHeld(new Shoot());
		
		climbButton.whileHeld(new Climb());
		
		gearInButton.whenPressed(new GearHolderClose());
		gearOutButton.whenPressed(new GearHolderOpen());
		gearCoverCloseButton.whenPressed(new GearCoverClose());
		gearCoverOpenButton.whenPressed(new GearCoverOpen());
		
		intakeButton.whileHeld(new IntakeBall());
		
		agitatorForwardButton.whileHeld(new SetAgitatorPower(1)); // TODO Add variable speed
		agitatorReverseButton.whileHeld(new SetAgitatorPower(-1)); // TODO Add variable speed
		
		transmissionTorqueButton.whenPressed(new TorqueGear());
		transmissionSpeedButton.whenPressed(new SpeedGear());
	}
	
	// Joystick inputs
	/**
	 * Get the value given by the right stick's Y-axis. Applies dead zone and reduction.
     * @return double Right joystick's Y-axis, -1...1
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
