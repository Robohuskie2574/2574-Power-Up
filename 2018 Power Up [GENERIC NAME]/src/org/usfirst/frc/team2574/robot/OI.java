/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2574.robot;

import org.usfirst.frc.team2574.robot.commands.ArmIn;
import org.usfirst.frc.team2574.robot.commands.ArmOut;
import org.usfirst.frc.team2574.robot.commands.GrabberClose;
import org.usfirst.frc.team2574.robot.commands.GrabberOpen;
import org.usfirst.frc.team2574.robot.commands.LiftDown;
import org.usfirst.frc.team2574.robot.commands.LiftUp;
import org.usfirst.frc.team2574.robot.commands.WinchDown;
import org.usfirst.frc.team2574.robot.commands.WinchUp;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);
	
	public static Joystick stick = new Joystick(0);
	// Likely to only need one joystick, the numbers only matter due to sequence and not specific USB ports.
	// More joysticks will make this more complicated, but mostly in action and not in programming, due to unplugging between matches.
	
	Button liftUp = new JoystickButton(stick, 7);
	Button liftDown = new JoystickButton(stick, 9);
	
	Button armOut = new JoystickButton(stick, 2);
	Button armIn = new JoystickButton(stick, 1);
	
	Button grabberClose = new JoystickButton(stick, 5);
	Button grabberOpen = new JoystickButton(stick, 3);
	
	Button winchUp = new JoystickButton(stick, 8);
	Button winchDown = new JoystickButton(stick, 10);
	//this assigns variables to buttons to be used later to assign the variables, and therefore the buttons, to commands
	
	public static double[] getDriveAxes() {
		return new double[]{stick.getRawAxis(0), stick.getRawAxis(1), stick.getRawAxis(2)};
		// Array so that you can assign all three axes to a double (number value) and not just one, is called in TeleDrive.java
	}

	public OI() {
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
		
		liftUp.whileHeld(new LiftUp());   //these take various commands and assign them to the buttons we created earlier here on OI.java
		liftDown.whileHeld(new LiftDown());
		
		armOut.whileHeld(new ArmOut());
		armIn.whileHeld(new ArmIn());
		
		grabberClose.whileHeld(new GrabberClose());
		grabberOpen.whileHeld(new GrabberOpen());
		
		winchUp.whileHeld(new WinchUp());
		winchDown.whileHeld(new WinchDown());
	}
}
