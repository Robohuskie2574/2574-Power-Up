package org.usfirst.frc.team2574.robot.subsystems;

import org.usfirst.frc.team2574.robot.commands.StopArm;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */

public class Arm extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public static Spark arm = new Spark(6);

	public Arm() {
		
	}
	
	public static void set(double speed) {
		arm.set(speed);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new StopArm());
    }
}

