package ca.team4519.lib.PID;

import edu.wpi.first.wpilibj.Gyro;

/**
 * @author Connor Adams
 */
public class PIDSrcGyro {
    
    private final Gyro gyro;
 
    public PIDSrcGyro(final Gyro gyro) {
        this.gyro = gyro;
    }
  
    public Gyro getSensor() {
        return gyro;
    }
 
    public float getValue() {
        return (float)gyro.getAngle();
    }
 
    public float getMinAngle() {
        return 0.0f;
    }
 
    public float getMaxAngle() {
        return 360.0f;
    }
}
