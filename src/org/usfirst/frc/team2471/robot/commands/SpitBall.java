package org.usfirst.frc.team2471.robot.commands;

import org.usfirst.frc.team2471.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class SpitBall extends Command {
	private double releaseTime;
	private double endTime = Timer.getFPGATimestamp() + 2;
	private boolean released = false;
	
	public SpitBall() { // TODO: Fix this shit
		requires(Robot.intake);
	}

	@Override
	protected void initialize() {
		Robot.intake.intakeStop();
		Robot.intake.intakeDown();
		releaseTime = Timer.getFPGATimestamp() + 2;
	}

	@Override
	protected void execute() {
		Robot.intake.intakeDown();
		if(Timer.getFPGATimestamp() > releaseTime) {
			Robot.intake.intakeOut(1.0);
			if(!Robot.intake.getBallState() && !released) {
				endTime = Timer.getFPGATimestamp() + 0.3;
				released = true;
			}
		}
	}

	@Override
	protected boolean isFinished() {
		return Timer.getFPGATimestamp() > endTime;
	}

	@Override
	protected void end() {
		Robot.intake.intakeStop();
		Robot.intake.intakeUp();
	}

	@Override
	protected void interrupted() {
		end();
	}

}
