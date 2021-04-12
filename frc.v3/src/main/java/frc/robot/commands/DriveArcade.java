package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.RobotContainer;
import frc.robot.Constants;

public class DriveArcade extends Command {
  public DriveArcade() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_drivetrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double moveSpeed = -RobotContainer.driverController.getRawAxis(Constants.DRIVER_CONTROLLER_MOVE_AXIS);
    double rotateSpeed = RobotContainer.driverController.getRawAxis(Constants.DRIVER_CONTROLLER_ROTATE_AXIS);

    RobotContainer.m_drivetrain.arcadeDrive(moveSpeed, rotateSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  protected void end(boolean interrupted) {
    Robot.m_drivetrain.arcadeDrive(0, 0);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }
}