package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Constants;

/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  Talon leftFrontTalon = null;
  Talon leftBackTalon = null;
  Talon rightFrontTalon = null;
  Talon rightBackTalon = null;

  SpeedControllerGroup leftMotors = null;
  SpeedControllerGroup rightMotors = null;

  DifferentialDrive differentialDrive = null;

  double maxSpeed = 0.3;
  public Drivetrain() {
    // Talons
    leftFrontTalon = new Talon(Constants.DRIVETRAIN_LEFT_FRONT_TALN);
    leftBackTalon = new Talon(Constants.DRIVETRAIN_LEFT_BACK_TALON);
    rightFrontTalon = new Talon(Constants.DRIVETRAIN_RIGHT_FRONT_TALON);
    rightBackTalon = new Talon(Constants.DRIVETRAIN_RIGHT_BACK_TALON);

    leftMotors = new SpeedControllerGroup(leftFrontTalon, leftBackTalon);
    rightMotors = new SpeedControllerGroup(rightFrontTalon, rightBackTalon);

    differentialDrive = new DifferentialDrive(leftMotors, rightMotors);
  }

  public void arcadeDrive(double moveSpeed, double rotateSpeed) {
    differentialDrive.arcadeDrive(maxSpeed * moveSpeed,maxSpeed * rotateSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}