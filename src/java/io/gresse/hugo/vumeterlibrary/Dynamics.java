/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package io.gresse.hugo.vumeterlibrary;

public class Dynamics {
    private static final float TOLERANCE = 0.01f;
    private boolean mIsToTarget;
    private float mPosition;
    private int mStep;
    private float mTargetPosition;

    public Dynamics(int n2, float f2) {
        this.mStep = n2;
        this.mPosition = f2;
        this.mIsToTarget = false;
    }

    public float getPosition() {
        return this.mPosition;
    }

    public float getTargetPos() {
        return this.mTargetPosition;
    }

    public boolean isAtRest() {
        return this.mIsToTarget;
    }

    public void setAtRest(boolean bl) {
        this.mIsToTarget = bl;
    }

    public void setPosition(float f2) {
        this.mPosition = f2;
        this.mIsToTarget = true;
    }

    public void setTargetPosition(float f2) {
        this.mTargetPosition = f2;
        this.mIsToTarget = false;
    }

    public void update() {
        if (this.mIsToTarget) {
            return;
        }
        float f2 = this.mTargetPosition;
        float f3 = this.mPosition;
        if (f2 > f3) {
            float f4;
            this.mPosition = f4 = f3 + (float)this.mStep;
            if (f4 >= f2) {
                this.mPosition = f2;
                this.mIsToTarget = true;
                return;
            }
        } else {
            float f5;
            this.mPosition = f5 = f3 - (float)this.mStep;
            if (f5 <= f2) {
                this.mPosition = f2;
                this.mIsToTarget = true;
            }
        }
    }
}

