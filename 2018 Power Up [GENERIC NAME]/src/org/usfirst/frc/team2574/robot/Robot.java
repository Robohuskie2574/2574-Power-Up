//2018 Power Up

package org.usfirst.frc.team2574.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2574.robot.commands.AutoCrossLine;
import org.usfirst.frc.team2574.robot.commands.AutoSwL1;
import org.usfirst.frc.team2574.robot.commands.AutoSwR3;
import org.usfirst.frc.team2574.robot.commands.ExampleCommand;
import org.usfirst.frc.team2574.robot.subsystems.Arm;
import org.usfirst.frc.team2574.robot.subsystems.Drive;
import org.usfirst.frc.team2574.robot.subsystems.ExampleSubsystem;
import org.usfirst.frc.team2574.robot.subsystems.Grabber;
import org.usfirst.frc.team2574.robot.subsystems.Lift;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	public static final ExampleSubsystem kExampleSubsystem
			= new ExampleSubsystem();
	public static OI oi;   //joystick
	public static final Lift lift = new Lift();   //cascading lift
	public static final Arm arm = new Arm();   //arm
	public static final Grabber grabber = new Grabber();   //grabber
	public static final Drive drive = new Drive();   //drivetrain
	
	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();
		m_chooser.addDefault("Default Auto", new ExampleCommand());
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", m_chooser);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		m_autonomousCommand = m_chooser.getSelected();

		/**
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
		
		String gameData;
		int robotPosition;
		gameData = DriverStation.getInstance().getGameSpecificMessage(); //Coloration for Switches and Scale
		//"https://wpilib.screenstepslive.com/s/currentCS/m/getting_started/l/826278-2018-game-data-details"
		robotPosition = DriverStation.getInstance().getLocation(); //Starting Position of Robot
		//No code yet for Scale, only Close Switch (we are not programming to do anything with Far Switch, at least for the time being)
		if(robotPosition == 1) { //Left Starting Position
			if(gameData.charAt(0) == 'L') {
				new AutoSwL1(); //Autonomous for Left Switch; Position 1
			} else {
				new AutoCrossLine(); //Autonomous for Right Switch; Position 1
			}
		} if(robotPosition == 2) { //Center Starting Position
			new AutoCrossLine(); //Autonomous for Either Switch; Position 2
		} else {
			if(gameData.charAt(0) == 'R') { //Right Starting Position
				new AutoSwR3(); //Autonomous for Right Switch; Position 3
			} else {
				new AutoCrossLine(); //Autonomous for Left Switch; Position 3
			}
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		/* This makes sure that the autonomous stops running when
		/* teleop starts running. If you want the autonomous to
		/* continue until interrupted by another command, remove
		/* this line or comment it out. */
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
