package org.usfirst.frc.team4561.robot;

import edu.wpi.first.wpilibj.Joystick;													//imports libraries
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team4561.robot.commands.ManipulatorIn;
import org.usfirst.frc.team4561.robot.commands.ManipulatorOut;
import org.usfirst.frc.team4561.robot.commands.RopeClimbDown;
import org.usfirst.frc.team4561.robot.commands.RopeClimbUp;
import org.usfirst.frc.team4561.robot.commands.Shoot;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	//JOYSTICK DECLARATION
	private static Joystick RightStick = new Joystick(RobotMap.RIGHT_JOYSTICK);			//declares a right stick
	private static Joystick LeftStick = new Joystick(RobotMap.LEFT_JOYSTICK);			//declares a left stick
	
	//Button Declaration
	private JoystickButton shootButton = new JoystickButton(RightStick, RobotMap.SHOOT_BUTTON);
	
	private JoystickButton ropeupbutton = new JoystickButton(RightStick, RobotMap.ROPE_UP_BUTTON);
	private JoystickButton ropedownbutton = new JoystickButton(RightStick, RobotMap.ROPE_DOWN_BUTTON);
	
	private JoystickButton gearinbutton = new JoystickButton(RightStick, RobotMap.GEAR_IN_BUTTON);
	private JoystickButton gearoutbutton = new JoystickButton(RightStick, RobotMap.GEAR_OUT_BUTTON);
	
	public OI() {
		//Initializing buttons
		shootButton.whileHeld(new Shoot());
		
		ropeupbutton.whileHeld(new RopeClimbUp());
		ropedownbutton.whileHeld(new RopeClimbDown());
		
		gearinbutton.whenPressed(new ManipulatorIn());
		gearoutbutton.whenPressed(new ManipulatorOut());
	}
	
	//JOYSTICK INPUTS
	public double getRightStickY() 														//gets input from right stick y axis
	{
		double RightStickY = RightStick.getY();
		// Dead zone management
		if(Math.abs(RightStick.getMagnitude()) < RobotMap.RIGHT_JOYSTICK_DEAD_ZONE)		//checks right stick y to deadzone
		{
			RightStickY = 0;															
		}
		
		// Reductions - joystick reduction reduces velocity from given joystick direction
		if(RightStickY > 0) 															
		{
			RightStickY = (RightStickY - RobotMap.RIGHT_JOYSTICK_REDUCTION) * (4.0/3.0);//slows robot down if going in positive direction
			if(RightStickY < 0) 														
			{
				RightStickY = 0;
			}
		}
		else if(RightStickY < 0) 														//slows robot down if going in negative direction										
		{
			RightStickY = (RightStickY + RobotMap.RIGHT_JOYSTICK_REDUCTION) * (4.0/3.0);
			if(RightStickY > 0) 
			{
				RightStickY = 0;
			}
		}
		return RightStickY;
	}

	/**
	 * Get the value given by the right stick's X-axis. Applies dead zone and reduction.
     * @return Right Joystick's X-axis
	 */
	public double getRightStickX() 														//SAME AS Y VALUES, EXCEPT ON X AXIS
	{
		double RightStickX = RightStick.getX();
		// Dead zone management
		if(Math.abs(RightStick.getMagnitude()) < RobotMap.RIGHT_JOYSTICK_DEAD_ZONE) 
		{
			RightStickX = 0;
		}
		// Reductions
		if(RightStickX > 0) 
		{
			RightStickX = (RightStickX - RobotMap.RIGHT_JOYSTICK_REDUCTION) * (4.0/3.0);
			if(RightStickX < 0) 
			{
				RightStickX = 0;
			}
		}
		else if(RightStickX < 0) 
		{
			RightStickX = (RightStickX + RobotMap.RIGHT_JOYSTICK_REDUCTION) * (4.0/3.0);
			if(RightStickX > 0) 
			{
				RightStickX = 0;
			}
		}
		return RightStickX;
	}
	
	/**
	 * Get the value given by the left stick's Y-axis. Applies dead zone and reduction.
     * @return Left Joystick's Y-axis
	 */
	public double getLeftStickY() 														// SAME AS RIGHT STICK Y, BUT WITH LEFT STICK
	{
		double LeftStickY = LeftStick.getY();
		// Dead zone management
		if(Math.abs(LeftStick.getMagnitude()) < RobotMap.LEFT_JOYSTICK_DEAD_ZONE) 
		{
			LeftStickY = 0;
		}
		// Reductions
		if(LeftStickY > 0) 
		{
			LeftStickY = (LeftStickY - RobotMap.LEFT_JOYSTICK_REDUCTION) * (4.0/3.0);
			if(LeftStickY < 0) 
			{
				LeftStickY = 0;
			}
		}
		else if(LeftStickY < 0) 
		{
			LeftStickY = (LeftStickY + RobotMap.LEFT_JOYSTICK_REDUCTION) * (4.0/3.0);
			if(LeftStickY > 0) 
			{
				LeftStickY = 0;
			}
		}
		return LeftStickY;
	}
	
	/**
	 * Get the value given by the left stick's X-axis. Applies dead zone and reduction.
     * @return Left Joystick's X-axis
	 */
	public double getLeftStickX() 														//SAME AS LEFT STICK Y, EXCEPT ON X AXIS
	{
		double LeftStickX = LeftStick.getX();
		// Dead zone management
		if(Math.abs(LeftStick.getMagnitude()) < RobotMap.LEFT_JOYSTICK_DEAD_ZONE) 
		{
			LeftStickX = 0;
		}
		// Reductions
		if(LeftStickX > 0) 
		{
			LeftStickX = (LeftStickX - RobotMap.LEFT_JOYSTICK_REDUCTION) * (4.0/3.0);
			if(LeftStickX < 0)
			{
				LeftStickX = 0;
			}
		}
		else if(LeftStickX < 0) 
		{
			LeftStickX = (LeftStickX + RobotMap.LEFT_JOYSTICK_REDUCTION) * (4.0/3.0);
			if(LeftStickX > 0) 
			{
				LeftStickX = 0;
			}
		}
		return LeftStickX;
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
