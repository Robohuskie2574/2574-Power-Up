package org.usfirst.frc.team2574.robot.commands;

import org.usfirst.frc.team2574.robot.Robot;
import org.usfirst.frc.team2574.robot.subsystems.Arm;
import org.usfirst.frc.team2574.robot.subsystems.Drive;
import org.usfirst.frc.team2574.robot.subsystems.Lift;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoSwL1 extends Command {

    public AutoSwL1() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//move forward 168" (middle of switch, includes crossing the auto line)
    	Drive.driveStraight(.25, .5);
    	Timer.delay(.2);
    	//lift arm up ~2' (over switch fence)
    	Lift.timedset(.25, .25);
    	Timer.delay(.2);
    	//rotate 90° to the right, I am likely going to steal last years rotation code (AutoLeftGear), but it requires encoders on the motors
    	
    	//shoot box out of arm
    	Arm.set(.25);
    	Timer.delay(.2);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
