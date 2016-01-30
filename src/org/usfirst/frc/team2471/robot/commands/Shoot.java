package org.usfirst.frc.team2471.robot.commands;

import org.usfirst.frc.team2471.robot.Robot;
import org.usfirst.frc.team2471.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Shoot extends Command {
	
	private double x, y;

	public Shoot() {
		requires(Robot.shooter);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void execute() {
		x = SmartDashboard.getNumber("Top");
		y = SmartDashboard.getNumber("Bottom");
		
		Robot.shooter.shoot(x, y);
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		Robot.shooter.stop();
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		Robot.shooter.stop();
	}

}
