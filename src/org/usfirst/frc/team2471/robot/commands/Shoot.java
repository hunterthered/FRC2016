package org.usfirst.frc.team2471.robot.commands;

import org.usfirst.frc.team2471.robot.Robot;
import org.usfirst.frc.team2471.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Shoot extends Command {
	
	public static double x, y;
	public static boolean lesdoit;

	public Shoot() {
		requires(Robot.shooter);
	}

	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		x = SmartDashboard.getNumber("Top", .6);
		y = SmartDashboard.getNumber("Bottom", -.4);
		
		if(SmartDashboard.getBoolean("Shoot"))
		{
			Robot.shooter.shoot(x, y);
		}else
		{
			Robot.shooter.stop();
		}
		
		
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
	}

}
