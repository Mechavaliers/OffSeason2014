 
package ca.team4519.frc2014;

import ca.team4519.lib.util.ConstantsBase;


public class Constants extends ConstantsBase {
  // Declare the constants and their default values here.
  
  //Auton Distances and Headings
  public static final Constant doNothingButton = new Constant("doNothingButton", 1);
  public static final Constant doNothingDistance = new Constant("doNothingDistance", 0.0);
  public static final Constant doNothingHeading = new Constant("doNothingHeading", 0.0);
  public static final Constant oneBallDistance = new Constant("oneBallDistance", 0.0);
  public static final Constant oneBallHeading = new Constant("oneBallHeading", 0.0);
  public static final Constant oneBallButton = new Constant ("oneBallButton", 2);
  public static final Constant oneHotDistance = new Constant("oneHotDistance", 0.0);
  public static final Constant oneHotHeading = new Constant("oneHotHeading", 0.0);
  public static final Constant oneHotButton = new Constant("oneHotButton", 3);
  public static final Constant oneHotOneNotDistance = new Constant("oneHotOneNotDistance", 0.0);
  public static final Constant oneHotOneNotHeading = new Constant("oneHotOneNotHeading", 0.0);
  public static final Constant oneHotOneNotButton = new Constant("oneHotOneNotButton", 4);
  public static final Constant twoBallDistance = new Constant("twoBallDistance", 0.0);
  public static final Constant twoBallHeading = new Constant("twoBallHeading", 0.0);
  public static final Constant twoBallButton = new Constant("twoBallButton", 5);
  public static final Constant toTrussDistance = new Constant("toTrussDistance", 5);
  public static final Constant toTrussHeading = new Constant("toTrussHeading", 0.0);
  public static final Constant toTrussButton = new Constant("toTrussButton", 6);
  
  //Controll Board Mappings
  public static final Constant gamepadPort = new Constant("gamepadPort", 1);
  public static final Constant operatorBoard = new Constant("operatorBoard", 2);
   
  //Speed Controller Mappings
  public static final Constant leftDriveA = new Constant("leftDriveA", 1);
  public static final Constant leftDriveB = new Constant("leftDriveB", 2);
  public static final Constant rightDriveA = new Constant("rightDriveA", 3);
  public static final Constant rightDriveB = new Constant("rightDriveB", 4);
  
  public static final Constant intakeRollerA = new Constant("intakeRollerA", 5);
  public static final Constant intakeRollerB = new Constant("intakeRollerB", 6);
  
  public static final Constant catapultMotor = new Constant("catapultMotor", 7);
   
  //Pneumatic Systems Mappings
  public static final Constant compressorRelay = new Constant("compressorRelay", 1);
  public static final Constant pressureSwitch = new Constant ("pressureSwitch", 14);
  public static final Constant highGearSolenoidPort = new Constant ("highGearSolenoidPort", 1);
  public static final Constant lowGearSolenoidPort = new Constant("lowGearSolenoidPort", 2);
  public static final Constant intakeDownSolenoidPort = new Constant("intakeDownSolenoidPort", 3);
  public static final Constant intakeUpSolenoidPort = new Constant("intakeUpSolenoidPort", 4);
  
  //Drive Encoders
  public static final Constant leftDriveEncoderA = new Constant("leftDriveEncoderA", 1);
  public static final Constant leftDriveEncoderB = new Constant("leftDriveEncoderB", 2);
  public static final Constant rightDriveEncoderA = new Constant("rightDriveEncoderA", 3);
  public static final Constant rightDriveEncoderB = new Constant("rightDriveEncoderB", 4);
  
  //Sensor Mappings
  public static final Constant catapultSwitch = new Constant("catapultSwitch", 5);
  
  public static final Constant gyroPort = new Constant("gyroPort", 1);
  
  //Intake Constraints
  public static final Constant intakeSpeed = new Constant("intakeSpeed", 0.8);
  public static final Constant controlledBallRoll = new Constant("controlledBallRoll", 0.3);
  
  //Catapult Constraints
  public static final Constant rearmSpeed = new Constant("rearmSpeed", -1.0);
  
  
  //Robot Dimensions
  public static final Constant robotWidth = new Constant("robotWidth", 27.5);
  public static final Constant wheelSize = new Constant("wheelSize", 4.0);
  
   static {
    // Set any overridden constants from the file on startup.
    readConstantsFromFile();
  }
 
   
  // Prevent instantiation of this class, as it should only be used statically.
  private Constants() {
  }
}