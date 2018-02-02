package org.usfirst.frc.team2574.robot.subsystems;

import org.usfirst.frc.team2574.robot.RobotMap;
import org.usfirst.frc.team2574.robot.commands.StopGrabber;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Grabber extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public static DoubleSolenoid grabber = new DoubleSolenoid(RobotMap.grabber1,RobotMap.grabber2);
	
	public Grabber() {
		
	}
	
	public static void set(Value direction) {
		grabber.set(direction);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new StopGrabber());
    }
}

