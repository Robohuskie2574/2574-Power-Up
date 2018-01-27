package org.usfirst.frc.team2574.robot.commands;

import org.usfirst.frc.team2574.robot.OI;
import org.usfirst.frc.team2574.robot.Robot;
import org.usfirst.frc.team2574.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TeleDrive extends Command {
	
	private static double deadzone = 0.2;

    public TeleDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drive); //Drive.java subsystem
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	// Uses "public static void safety" and "public static boolean safety" from Drive.java subsystem.
    	if (!Drive.safety()) {
    		Drive.safety(true);
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	// This is why the safety existed, if I remember, so we can set it true and skip execute, or something similar.
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	double x = OI.getDriveAxes()[0];
    	double y = OI.getDriveAxes()[1];
    	double rotation = OI.getDriveAxes()[2];
    	// Uses "public static void cartesian" from Drive.java subsystem and "public static double[] getDriveAxes()" from OI.java.
    	
    	if (Math.abs(OI.getDriveAxes()[0]) < deadzone) {
    		x = 0;
    	}
    	if (Math.abs(OI.getDriveAxes()[1]) < deadzone) {
    		y = 0;
    	}
    	
    	if (Math.abs(OI.getDriveAxes()[2]) < deadzone*.5) {
    		rotation = 0; //smaller deadzone for more specificity
    	}
    	
    	Drive.cartesian(x, y, rotation*.75); //rotation is 75% of the power, max value is 1, for 100% when axis on joystick is maxed
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
