package org.usfirst.frc.team2574.robot.subsystems;

import org.usfirst.frc.team2574.robot.commands.StopGrabber;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Grabber extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public static Spark grabber = new Spark(7);
	
	public Grabber() {
		
	}
	
	public static void set(double speed) {
		grabber.set(speed);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new StopGrabber());
    }
}

