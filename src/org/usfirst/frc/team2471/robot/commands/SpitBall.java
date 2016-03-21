package org.usfirst.frc.team2471.robot.commands;

import org.usfirst.frc.team2471.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SpitBall extends Command {
	long endTime;
	
	public SpitBall() {
		requires(Robot.intake);		
	}

	@Override
	protected void initialize() {
		Robot.logger.logInfo("Spitting ball");
		Robot.intake.intakeStop();
		if(Robot.intake.getIntakeSensor()) {
			Robot.intake.intakeDown();	
			Robot.logger.logInfo("Ball found in intake. Spitting out ball");
		}
		else {
			Robot.logger.logWarning("Ball not found in intake!");
		}
		this.endTime = System.currentTimeMillis() + 500; // Run intake after .5 seconds
	}

	@Override
	protected void execute() {
		if(System.currentTimeMillis() > endTime) {
			Robot.intake.intakeOut(1.0);
		}
	}

	@Override
	protected boolean isFinished() {
		return Robot.intake.getBallState();
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
