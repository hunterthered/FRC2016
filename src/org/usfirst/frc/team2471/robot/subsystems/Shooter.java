package org.usfirst.frc.team2471.robot.subsystems;

import org.usfirst.frc.team2471.robot.RobotMap;
import org.usfirst.frc.team2471.robot.commands.Shoot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem{
	public static boolean launching = false;
	public static boolean isLocked = true;
	
	Solenoid launcherPiston;
    public static DigitalInput launcherIsDown;
    public static AnalogInput launcherIsLockedSensor, launcherPsiSensor;

	protected void initDefaultCommand() {
		setDefaultCommand(new Shoot());
	}

	public Shooter(){
		launcherPiston = RobotMap.launcherPiston;
		launcherIsDown = RobotMap.launcherIsDown;
		launcherIsLockedSensor = RobotMap.launcherIsLocked;
		launcherPsiSensor = RobotMap.launcherPsiSensor;
	}
	
	public void goDown(){
		launcherPiston.set(false);
	}

}