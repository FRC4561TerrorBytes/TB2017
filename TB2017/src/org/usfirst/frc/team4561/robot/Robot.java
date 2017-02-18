package org.usfirst.frc.team4561.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
//import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

import org.usfirst.frc.team4561.robot.subsystems.Agitator;
import org.usfirst.frc.team4561.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4561.robot.subsystems.DriveTrainPID;
import org.usfirst.frc.team4561.robot.subsystems.GearManipulator;
import org.usfirst.frc.team4561.robot.subsystems.Intake;
import org.usfirst.frc.team4561.robot.subsystems.RopeClimber;
import org.usfirst.frc.team4561.robot.subsystems.Shooter;
import org.usfirst.frc.team4561.robot.subsystems.ShooterPID;
import org.usfirst.frc.team4561.robot.subsystems.Transmission;

import com.ctre.CANTalon.TalonControlMode;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static DriveTrain driveTrain;
	public static Shooter shooter;
	//public static Intake intake;
	public static RopeClimber ropeClimber;
	public static GearManipulator gearManipulator;
	public static Agitator agitator;
    public static Transmission transmission;
    public static NetworkTable debugTable;
    public static OI oi;
	
	Command autonomousCommand;
	
	public static boolean debug = false;
	public static Object camera;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		shooter = new Shooter();
		driveTrain = new DriveTrain();
		gearManipulator = new GearManipulator();	
		//intake = new Intake();
		agitator = new Agitator();
		ropeClimber = new RopeClimber();
        transmission = new Transmission();
		oi = new OI();
		
		if(RobotMap.MASTER_VERBOSE) {
			System.out.println("[Robot] Subsystems constructed");
		}
		
		if(isInDebugMode()) { 
			debugTable = NetworkTable.getTable("Debugging");
		}
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
		if (RobotMap.MASTER_VERBOSE) {
			System.out.println("[Robot] Disabled");
		}
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		if(Robot.isInDebugMode()) {
			//getDebugTable().putNumber("Shooter Velocity", Robot.shooter.rightEncoderVel());
			getDebugTable().putNumber("Rope Climber Velocity", Robot.ropeClimber.climbEncoderVel());
			getDebugTable().putBoolean("Gear Manipulator Cover", Robot.gearManipulator.coverState());
			getDebugTable().putBoolean("Gear Manipulator Holder", Robot.gearManipulator.holderState());
			getDebugTable().putBoolean("Gear Manipulator Infrared", Robot.gearManipulator.detectorState());
			/*getDebugTable().putNumber("Drive Train Front Left Pos", Robot.driveTrain.leftMotorPos());
			getDebugTable().putNumber("Drive Train Front Right Pos", Robot.driveTrain.rightMotorPos());
			getDebugTable().putNumber("Drive Train Front Left Vel", Robot.driveTrain.leftMotorVel());
			getDebugTable().putNumber("Drive Train Front Right Vel", Robot.driveTrain.rightMotorVel());*/
			getDebugTable().putNumber("Agitator", Robot.agitator.agitatorState());
			getDebugTable().putString("Transmission State", Robot.transmission.currentState);		
		}
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {

		// Schedule the autonomous command (example)
		if (autonomousCommand != null) {
			autonomousCommand.start();
		}
		if (RobotMap.MASTER_VERBOSE) {
			System.out.println("[Robot] Started autonomous");
		}
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        if(Robot.isInDebugMode()) {
			//getDebugTable().putNumber("Shooter Velocity", Robot.shooter.rightEncoderVel());
			getDebugTable().putNumber("Rope Climber Velocity", Robot.ropeClimber.climbEncoderVel());
			getDebugTable().putBoolean("Gear Manipulator Cover", Robot.gearManipulator.coverState());
			getDebugTable().putBoolean("Gear Manipulator Holder", Robot.gearManipulator.holderState());
			getDebugTable().putBoolean("Gear Manipulator Infrared", Robot.gearManipulator.detectorState());
			/*getDebugTable().putNumber("Drive Train Front Left Pos", Robot.driveTrain.leftMotorPos());
			getDebugTable().putNumber("Drive Train Front Right Pos", Robot.driveTrain.rightMotorPos());
			getDebugTable().putNumber("Drive Train Front Left Vel", Robot.driveTrain.leftMotorVel());
			getDebugTable().putNumber("Drive Train Front Right Vel", Robot.driveTrain.rightMotorVel());
			getDebugTable().putNumber("Agitator", Robot.agitator.agitatorState());*/
			getDebugTable().putString("Transmission State", Robot.transmission.currentState);	   
		}
	}

	@Override
	public void teleopInit() {

		//Robot.driveTrain.SwitchToVelocity();
		
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		if (this.isTest()) {
			oi.testMode();
		} else {
			oi.matchMode();
		}
		if (RobotMap.MASTER_VERBOSE) {
			System.out.println("[Robot] Started teleop");
		}
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
        Scheduler.getInstance().run();
        if(Robot.isInDebugMode()) {
			//getDebugTable().putNumber("Shooter Velocity", Robot.shooter.rightEncoderVel());
			getDebugTable().putNumber("Rope Climber Velocity", Robot.ropeClimber.climbEncoderVel());
			getDebugTable().putBoolean("Gear Manipulator Cover", Robot.gearManipulator.coverState());
			getDebugTable().putBoolean("Gear Manipulator Holder", Robot.gearManipulator.holderState());
			getDebugTable().putBoolean("Gear Manipulator Infrared", Robot.gearManipulator.detectorState());
			/*getDebugTable().putNumber("Drive Train Front Left Pos", Robot.driveTrain.leftMotorPos());
			getDebugTable().putNumber("Drive Train Front Right Pos", Robot.driveTrain.rightMotorPos());
			getDebugTable().putNumber("Drive Train Front Left Vel", Robot.driveTrain.leftMotorVel());
			getDebugTable().putNumber("Drive Train Front Right Vel", Robot.driveTrain.rightMotorVel());*/
			getDebugTable().putNumber("Agitator", Robot.agitator.agitatorState());
			getDebugTable().putString("Transmission State", Robot.transmission.currentState);	
        }
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
        if(Robot.isInDebugMode()) {
			//getDebugTable().putNumber("Shooter Velocity", Robot.shooter.rightEncoderVel());
			getDebugTable().putNumber("Rope Climber Velocity", Robot.ropeClimber.climbEncoderVel());
			getDebugTable().putBoolean("Gear Manipulator Cover", Robot.gearManipulator.coverState());
			getDebugTable().putBoolean("Gear Manipulator Holder", Robot.gearManipulator.holderState());
			getDebugTable().putBoolean("Gear Manipulator Infrared", Robot.gearManipulator.detectorState());
			/*getDebugTable().putNumber("Drive Train Front Left Pos", Robot.driveTrain.leftMotorPos());
			getDebugTable().putNumber("Drive Train Front Right Pos", Robot.driveTrain.rightMotorPos());
			getDebugTable().putNumber("Drive Train Front Left Vel", Robot.driveTrain.leftMotorVel());
			getDebugTable().putNumber("Drive Train Front Right Vel", Robot.driveTrain.rightMotorVel());*/
			getDebugTable().putNumber("Agitator", Robot.agitator.agitatorState());
			getDebugTable().putString("Transmission State", Robot.transmission.currentState);	
		}
	}
	
	public static boolean isInDebugMode() {
		return debug;
	}
	
	public static NetworkTable getDebugTable() {
		return debugTable;
	}
	
}
