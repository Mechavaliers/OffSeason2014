package ca.team4519.lib.PID;

import edu.wpi.first.wpilibj.Encoder;

/**
 * @author Connor Adams
 */
public class PIDSrcEncoder implements PIDSource{

    private final Encoder enc;
    
    public PIDSrcEncoder(final Encoder enc) {
        this.enc = enc;
    }
    
    public Encoder getSensor() {
        return enc;
    }

    public float getValue() {
        return enc.get();
    }

}
