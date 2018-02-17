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
public class AutoScL2 extends Command {

	
	private boolean finished = false;
	//this might be redundant check if different than setting line 47 to return false as opposed to return finished -R.P.
	
    public AutoScL2() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Drive.safety(false);
    	//first move about three feet forward, rotate, then traverse yonder (UND) until middle then 168" in total- 4 ft, then ten feet and more until scale
    	Drive.driveStraight(.5, .5);
    	Timer.delay(.5);
    	Drive.cartesian(0, 0, 0);
    	Drive.cartesian(0, 0, -90);
    	Drive.driveStraight(.75, .75);
    	Timer.delay(.1);
    	Drive.cartesian(0, 0, 90);
    	Drive.driveStraight(.75, 1);
    	//lift arm up ~2' (over switch fence)
    	Lift.timedset(.25, .25);
    	Timer.delay(.2);
    	//rotate 90 degrees to the right
    	while (Drive.getGyroAngle() < 90) {
    		Drive.cartesian(0,0, .38);
    		Timer.delay(.05);
    	}
    	
    	
    	//shoot box out of arm
    	Arm.set(.25);
    	Timer.delay(.2);
    	//Drive.driveStraight(-.25, .5);
    	
    	finished = true;
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
