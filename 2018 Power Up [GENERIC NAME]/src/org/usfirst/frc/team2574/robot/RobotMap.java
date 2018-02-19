/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2574.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */

public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drive subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;
	
	public static int leftFrontId = 4;
	public static int leftRearId = 3;
	public static int rightFrontId = 2;
	public static int rightRearId = 1;
	//motors
	
	public static int gyro = 0;
	//gyro for proper autonomous
	
	public static int lift = 0;
	public static int grabber1 = 4;
	public static int grabber2 = 5;
	public static int arm = 1;
	public static int arm2 = 2;
	public static int winch = 8;
	
	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
