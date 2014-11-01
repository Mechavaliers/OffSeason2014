 
package ca.team4519.frc2014.subsystems;


import ca.team4519.frc2014.Constants;
import ca.team4519.lib.Controller;
import ca.team4519.lib.Loopable;
import ca.team4519.lib.Subsystem;
import ca.team4519.lib.MechaGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import java.util.Hashtable;

/**
 *
 * @author Connor Adams
 */
public class DriveBase extends Subsystem implements Loopable{
    
    public boolean canReset;
    public boolean hasReset;
    
  //Ticks to Feet
  public final double RIGHT_ENCOCDER_TO_DISTANCE_RATIO = (Constants.wheelSize.getDouble() * Math.PI) / (12.0 * 256.0);
  public final double LEFT_ENCOCDER_TO_DISTANCE_RATIO = (Constants.wheelSize.getDouble() * Math.PI) / (12.0 * 256.0);

  //Speed Controllers
  public Victor leftDriveA = new Victor(Constants.leftDriveA.getInt());
  public Victor leftDriveB = new Victor(Constants.leftDriveB.getInt());
  public Victor rightDriveA = new Victor(Constants.rightDriveA.getInt());
  public Victor rightDriveB = new Victor(Constants.rightDriveB.getInt());
  
  //Encoders
  private Encoder leftEncoder = new Encoder(Constants.leftDriveEncoderA.getInt(), Constants.leftDriveEncoderB.getInt(), false);
  private Encoder rightEncoder = new Encoder(Constants.rightDriveEncoderA.getInt(), Constants.rightDriveEncoderB.getInt(), true);
  
  //Solenoids 
  private Solenoid highGear = new Solenoid(Constants.highGearSolenoidPort.getInt());
  private Solenoid lowGear = new Solenoid(Constants.lowGearSolenoidPort.getInt());
  
  public MechaGyro gyro;
  
    public void setLeftRightPower(double leftPower, double rightPower) {
    leftDriveA.set(-leftPower);
    leftDriveB.set(-leftPower);
    rightDriveA.set(rightPower);
    rightDriveB.set(rightPower);
    }
  public void smartDrive(double rightStick, double leftStick, double gyroHeading){
      if(rightStick == 0 && leftStick == 0){
         if(canReset && !hasReset){
             gyro.reset();
             canReset = false;
             hasReset = true;
         } 
          if(gyroHeading <= 360 && gyroHeading >= 0 && hasReset){
              setLeftRightPower(gyroHeading/22.5, -gyroHeading/22.5);
          }else if(gyroHeading  >= -360  && gyroHeading <= 0 && hasReset){
              setLeftRightPower(gyroHeading/22.5, -gyroHeading/22.5);
          }
      }else{
        leftDriveA.set(-leftStick);
        leftDriveB.set(-leftStick);
        rightDriveA.set(rightStick);
        rightDriveB.set(rightStick);
        canReset = true;
        hasReset = false;
      }
      
  }
       
  public void setLowGear(boolean shift){
      highGear.set(!shift);
      lowGear.set(shift);
      }
  
   public DriveBase() {
    super("Drivebase");
    gyro = new MechaGyro(Constants.gyroPort.getInt());
    leftEncoder.start();
    rightEncoder.start();
  }
  
   
   public Hashtable serialize() {
    Hashtable leftDrive = new Hashtable();
    Hashtable rightDrive = new Hashtable();
    Hashtable encoders = new Hashtable();

    leftDrive.put("leftDriveA", new Double(leftDriveA.get()));
    leftDrive.put("leftDriveB", new Double(leftDriveB.get()));

    rightDrive.put("rightDriveA", new Double(rightDriveA.get()));
    rightDrive.put("rightDriveB", new Double(rightDriveB.get()));

    encoders.put("leftEncoder", new Double(leftEncoder.get()));
    encoders.put("rightEncoder", new Double(rightEncoder.get()));    
    data.put("leftDrive", leftDrive);
    data.put("rightDrive", rightDrive);
    data.put("encoders", encoders);
    data.put("gyro", new Double(getGyroAngle()));
    return data;
  }
   
 public Encoder getLeftEncoder() {
    return leftEncoder;
  }

  public double getLeftEncoderDistance() { // in feet
    return leftEncoder.get() * LEFT_ENCOCDER_TO_DISTANCE_RATIO;
  }

  public double getLeftEncoderDistanceInMeters() {
    return getLeftEncoderDistance() * 0.3048;
  }

  public Encoder getRightEncoder() {
    return rightEncoder;
  }

  public double getRightEncoderDistance() {
    return rightEncoder.get() * RIGHT_ENCOCDER_TO_DISTANCE_RATIO;
  }

  public double getRightEncoderDistanceInMeters() {
    return getRightEncoderDistance() * 0.3048;
  }

  public double getGyroAngle(){
      return gyro.getAngle();
  }
  
  public double getGyroRate(){
      return gyro.getRate();
  }
  
  
  public double nonContAngle(){
     double angle = gyro.getAngle();
        if(gyro.getAngle() > 0){
          angle = gyro.getAngle()%360;
          return angle;
       }else if(gyro.getAngle() < 0){
          angle = gyro.getAngle()%-360;
          return angle;
       }
     return angle;
  }
  
  public double smartAngle(){
      double degRot = 0;
        if(3 <= nonContAngle() && nonContAngle() >= -3){
           degRot = 0;
           return degRot;
        }else{
            degRot = nonContAngle();
            return degRot;
        }
  }
  
  public void resetGyro(){
      gyro.reset();
  }
  
   public double getAverageDistance() {
    return (getRightEncoderDistance() + getLeftEncoderDistance()) / 2.0;
  }
  
    public void resetEncoders() {
    leftEncoder.reset();
    rightEncoder.reset();
  }
   
  public void update(){
      SmartDashboard.putNumber("Left Drive Distance", getLeftEncoderDistance());
      SmartDashboard.putNumber("Right Drive Distance", getRightEncoderDistance());
      SmartDashboard.putNumber("Both Encoders, Average Distance", getAverageDistance());
      SmartDashboard.putNumber("gyro", smartAngle());
      super.update();
    
}







}
  
  
  
  
  
  
