 
package ca.team4519.lib.PID;

/**
 *
 * @author Connor Adams
 */
public class MechaPID {

    protected final PIDSource source;
    protected float threshold, kP, kI, kD, integralError, prevError, deltaError;
    protected boolean onTarget;
    
    public MechaPID(final PIDSource source, final float threshold, final float kP, final float kI, final float kD){
        this.source = source;
        this.threshold = threshold;
        this.kP = kP;
        this.kI = kI;
        this.kD = kD;
        this.onTarget = false;
    }
    
    public void clear() {
       integralError = 0.0f;
       prevError = 0.0f;
       deltaError = 0.0f;
    }
    
        public float pid(final float target) {
        float remain;
        float pOut;
        float iOut;
        float dOut;
        float output;

        remain = (float)(target - source.getValue());

        deltaError = prevError - remain;
        prevError = remain;
        integralError += remain;

        pOut = remain * kP;
        iOut = integralError * kI;
        dOut = deltaError * kD;

        if (iOut > 1.0f) {
            iOut = 1.0f;
        }
        
        if (Math.abs(remain) < threshold) {
            onTarget = true;
            return 0.0f;
        } else {
            onTarget = false;
        }

        output = (pOut + iOut + dOut);

        if (output > 1.0f) {
            return 1.0f;
        }
        if (output < -1.0f) {
            return -1.0f;
        }
        return output;
    }
    
}
