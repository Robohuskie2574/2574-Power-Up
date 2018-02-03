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
public class AutoSwR3 extends Command {

	
	private boolean finished = false;
    public AutoSwR3() {
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
       	Timer.delay(.2);
        Drive.cartesian(0, 0, 0);
        
    	//move forward slightly
    	Drive.driveStraight(.25, .1);
    	Timer.delay(.2);
    	
    	//rotate 90° to the right
    	while (Drive.getGyroAngle() < 90) {
    		Drive.cartesian(0, 0, .38);
    		Timer.delay(.05);
    		
    	//move forward
       	Drive.driveStraight(.25, .5);
        Timer.delay(.2);		
        	
        //rotate 90° to the left
    	while (Drive.getGyroAngle() < -90) {
    		Drive.cartesian(0, 0, -.38);
    		Timer.delay(.05);
    	}
    		
    	//move forward
       	Drive.driveStraight(.25, .5);
        Timer.delay(.2);		

    	//rotate 90° to the right
    	while (Drive.getGyroAngle() < 90) {
    		Drive.cartesian(0, 0, .38);
    		Timer.delay(.05);
    	}
    	
    	//lift arm up ~6' (over scale)
       	Lift.timedset(.25, .75);
       	Timer.delay(.2);
    	    		
    	//shoot box out of arm
    	Arm.set(.25);
    	Timer.delay(.2);
    	
    	finished = true;
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
