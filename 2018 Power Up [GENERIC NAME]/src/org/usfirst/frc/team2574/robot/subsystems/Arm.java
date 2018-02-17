package org.usfirst.frc.team2574.robot.subsystems;

import org.usfirst.frc.team2574.robot.RobotMap;
import org.usfirst.frc.team2574.robot.commands.StopArm;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */

public class Arm extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.my name a jeff

	public static Spark arm = new Spark(RobotMap.arm);
	public static Spark arm2 = new Spark(RobotMap.arm2);

	public Arm() {
		
	}
	
	public static void set(double speed) {
		arm.set(speed);
		arm2.set(speed);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new StopArm());
    }
}

