package ca.team4519.frc2014;

import ca.team4519.frc2014.actions.DriveDistance;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.Timer;
import ca.team4519.lib.MechaIterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class MechavaliersCompetition extends MechaIterativeRobot {
    
    DriverController driver;
    OperatorJoystick op;
    
    DriverStationLCD lcd;
       
    double leftDriveSpeed;
    double rightDriveSpeed;
    
    boolean canShoot;
    boolean hasShot;
    boolean IMHAWT;
    
    BallCounter numBalls;
       
    DriveDistance dontMove;
    DriveDistance oneBall;
    DriveDistance oneHot;
    DriveDistance oneHotOneNot;
    DriveDistance twoBall;
    DriveDistance toTruss;
    
    
 
 public void robotInit() {
   Constants.readConstantsFromFile();
   MechaRobot.driveBase.resetGyro();
   MechaRobot.subsystemUpdater100Hz.start();
   
   driver = new DriverController(Constants.gamepadPort.getInt());
   op = new OperatorJoystick(Constants.operatorBoard.getInt());
   
   numBalls = new BallCounter("Num_Balls", 3);
   
   dontMove = new DriveDistance(Constants.doNothingDistance.getDouble(), Constants.doNothingHeading.getDouble());
   oneBall = new DriveDistance(Constants.oneBallDistance.getDouble(), Constants.oneBallHeading.getDouble());
   oneHot = new DriveDistance(Constants.oneHotDistance.getDouble(), Constants.oneHotHeading.getDouble());
   oneHotOneNot = new DriveDistance(Constants.oneHotOneNotDistance.getDouble(), Constants.oneHotOneNotHeading.getDouble());
   twoBall = new DriveDistance(Constants.twoBallDistance.getDouble(), Constants.twoBallHeading.getDouble());
   toTruss = new DriveDistance(Constants.toTrussDistance.getDouble(), Constants.toTrussDistance.getDouble());
           
 }
 
 public void autonomousInit() {
       numBalls.autonStart();
     
       MechaRobot.driveBase.resetEncoders();
       MechaRobot.driveBase.resetGyro();
       canShoot = false;
       hasShot = false;
 

 }
 public void disabledInit() {
    Constants.readConstantsFromFile();
    MechaRobot.driveBase.gyro.reset();
    
  }

 public void teleopInit(){
     MechaRobot.driveBase.gyro.reset();
 }
 
public void autonomousPeriodic() {

    
      if(DriverStation.getInstance().getDigitalIn(Constants.doNothingButton.getInt())){
            dontMove.run();
            numBalls.noBalls();
      }else if(DriverStation.getInstance().getDigitalIn(Constants.oneBallButton.getInt())){
          //Drives to desired destination  
          oneBall.run();
          /*Essentially checks if a ball has been shot
           * It does this by checking the value of our numBalls counter,
           * because this is a one ball auton, it makes sure it has only one ball in the robots possesion
           * Next, it checks that the catapult is in the down position
           * the last check it does is to see if the bot has shot
           * if all of these checks are succesful, the boolean canShoot becomes true, allowing a shot to be made      
           */
            if(numBalls.Value() == 1 && MechaRobot.shooter.shotReady() && !hasShot){
                canShoot = true;
            }
            /*
             * Once canShoot is true, the robot shoots, and lowers the ball count by 1
             * you may notice that it doesnt update the hasShot boolean
             * if that were done here, if would freeze the program untill auto ended, causing the robot not to shoot
             */
            if(canShoot){
                MechaRobot.shooter.shoot();
                hasShot = false;
                numBalls.lessBalls();
            }            
            /*
             * checks that we shot all our balls, and that the catapult is back in the ready position
             * if the above is true, it updates hasShot to true, sucessfully completing the oneBall 
             * auton routine
             */
            if(numBalls.Value() == 0 && MechaRobot.shooter.shotReady()){
                hasShot = true;
            }
            
      }else if(DriverStation.getInstance().getDigitalIn(Constants.oneHotButton.getInt())){
            oneHot.run();
                        
            if(numBalls.Value() == 1 && MechaRobot.shooter.shotReady() && !hasShot && IMHAWT){
                canShoot = true;
            }
            if(canShoot){
                MechaRobot.shooter.shoot();
                hasShot = false;
                numBalls.lessBalls();
            }
            if(numBalls.Value() == 0 && MechaRobot.shooter.shotReady() && true ){
                hasShot = true;
            }
            
      }else if(DriverStation.getInstance().getDigitalIn(Constants.oneHotOneNotButton.getInt())){
            oneHotOneNot.run();
            
      }else if(DriverStation.getInstance().getDigitalIn(Constants.twoBallButton.getInt())){
            twoBall.run();
            
      }else if(DriverStation.getInstance().getDigitalIn(Constants.toTrussButton.getInt()));
            toTruss.run();
            numBalls.noBalls();
  }

public void teleopPeriodic() {
        
    
     //Axi
     leftDriveSpeed = driver.getRawAxis(2);
     rightDriveSpeed = driver.getRawAxis(5);
    
      if (leftDriveSpeed <0.099 && leftDriveSpeed>-0.099) leftDriveSpeed=0;
       if (rightDriveSpeed <0.099 && rightDriveSpeed>-0.099) rightDriveSpeed=0;
           
     SmartDashboard.putNumber("leftDriveSpeed", leftDriveSpeed);
     SmartDashboard.putNumber("rightDriveSpeed", rightDriveSpeed);

     if(driver.getShiftButton()){
         MechaRobot.driveBase.setLowGear(true);
     }else{
         MechaRobot.driveBase.setLowGear(false);
     }
     
    //Takes joystick pos and makes wheels go vroom
    MechaRobot.driveBase.smartDrive(rightDriveSpeed, leftDriveSpeed, MechaRobot.driveBase.smartAngle());
        
    //Controling intake roller direction
    if(op.getSuckBallButton()){
        MechaRobot.intake.suckBall();
    }else if(op.getExaustBallButton()){
        MechaRobot.intake.exaustBall();
    }
    
    //Controling intake position. and presets?
    if(op.getDropIntakeButton()){
        MechaRobot.intake.setIntakePosition(false);
    }else if(op.getHPInboundButton()){
        MechaRobot.intake.hpInbound();
    }else if(op.get1114PassButton()){
        MechaRobot.intake.inboundSpitPass();
    }else{
        MechaRobot.intake.setRollerPower(0.0);
    }
        
    }


 
public void allPeriodic() {

    lcd();
    
    MechaRobot.driveBase.update();
    MechaRobot.intake.update();
    MechaRobot.shooter.update();
    
    
}

 Timer lcdUpdateTimer = new Timer();
  public void lcd() {
    if (lcdUpdateTimer.get() < .1) {
      return;
    }
    lcdUpdateTimer.reset();
    lcd.println(DriverStationLCD.Line.kUser1, 1, "Gyro Angle" + MechaRobot.driveBase.gyro.getAngle());
    lcd.println(DriverStationLCD.Line.kUser2, 1, "Number of Auton Balls" + numBalls.Value());
    lcd.println(DriverStationLCD.Line.kUser3, 1, "im an unused line!");
    lcd.println(DriverStationLCD.Line.kUser4, 1, "Hey, im a line too!");
    lcd.println(DriverStationLCD.Line.kUser6, 1, "Im a line with math" + "2+2=6");
    lcd.println(DriverStationLCD.Line.kUser5, 1, "im a string"); 
    lcd.updateLCD();
 
  }

}