/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  F
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.util.AttributeSet
 *  android.view.View
 *  java.lang.String
 *  java.lang.reflect.Array
 *  java.util.Random
 */
package io.gresse.hugo.vumeterlibrary;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import io.gresse.hugo.vumeterlibrary.Dynamics;
import io.gresse.hugo.vumeterlibrary.R;
import java.lang.reflect.Array;
import java.util.Random;

public class VuMeterView
extends View {
    public static final int DEFAULT_BLOCK_SPACING = 20;
    public static final int DEFAULT_NUMBER_BLOCK = 3;
    public static final int DEFAULT_NUMBER_RANDOM_VALUES = 10;
    public static final int DEFAULT_SPEED = 10;
    public static final boolean DEFAULT_START_OFF = false;
    public static final int DEFAULT_STOP_SIZE = 30;
    public static final int FPS = 60;
    public static final String LOG_TAG = "VuMeterView";
    public static final int STATE_PAUSE = 0;
    public static final int STATE_PLAYING = 2;
    public static final int STATE_STOP = 1;
    private int mBlockNumber;
    private int mBlockPass;
    private float mBlockSpacing;
    private float[][] mBlockValues;
    private int mBlockWidth;
    private int mColor;
    private int mContentHeight;
    private int mContentWidth;
    private Dynamics[] mDestinationValues;
    private int mDrawPass;
    private int mLeft;
    private int mPaddingBottom;
    private int mPaddingLeft;
    private int mPaddingRight;
    private int mPaddingTop;
    private Paint mPaint = new Paint();
    private Random mRandom = new Random();
    private int mRight;
    private int mSpeed;
    private int mState;
    private float mStopSize;
    private int mTop;

    public VuMeterView(Context context) {
        super(context);
        this.init(null, 0);
    }

    public VuMeterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.init(attributeSet, 0);
    }

    public VuMeterView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.init(attributeSet, n2);
    }

    private void changeDynamicsTarget(int n2, float f2) {
        this.incrementAndGetDrawPass();
        this.mDestinationValues[n2].setTargetPosition(f2);
    }

    private int incrementAndGetDrawPass() {
        int n2;
        this.mDrawPass = n2 = 1 + this.mDrawPass;
        if (n2 >= 10) {
            this.mDrawPass = 0;
        }
        return this.mDrawPass;
    }

    private void init(AttributeSet attributeSet, int n2) {
        TypedArray typedArray = this.getContext().obtainStyledAttributes(attributeSet, R.styleable.vumeter_VuMeterView, n2, 0);
        this.mColor = typedArray.getColor(R.styleable.vumeter_VuMeterView_vumeter_backgroundColor, -16777216);
        this.mBlockNumber = typedArray.getInt(R.styleable.vumeter_VuMeterView_vumeter_blockNumber, 3);
        this.mBlockSpacing = typedArray.getDimension(R.styleable.vumeter_VuMeterView_vumeter_blockSpacing, 20.0f);
        this.mSpeed = typedArray.getInt(R.styleable.vumeter_VuMeterView_vumeter_speed, 10);
        this.mStopSize = typedArray.getDimension(R.styleable.vumeter_VuMeterView_vumeter_stopSize, 30.0f);
        boolean bl = typedArray.getBoolean(R.styleable.vumeter_VuMeterView_vumeter_startOff, false);
        typedArray.recycle();
        this.initialiseCollections();
        this.mPaint.setColor(this.mColor);
        this.mState = bl ? 0 : 2;
        this.mRight = 0;
        this.mPaddingBottom = 0;
        this.mPaddingRight = 0;
        this.mTop = 0;
        this.mLeft = 0;
        this.mPaddingTop = 0;
        this.mPaddingLeft = 0;
        this.mContentWidth = 0;
        this.mContentHeight = 0;
        this.mBlockPass = 0;
        this.mDrawPass = 0;
    }

    private void initialiseCollections() {
        int n2 = this.mBlockNumber;
        int[] arrn = new int[2];
        arrn[1] = 10;
        arrn[0] = n2;
        this.mBlockValues = (float[][])Array.newInstance(F.class, (int[])arrn);
        this.mDestinationValues = new Dynamics[this.mBlockNumber];
        this.updateRandomValues();
    }

    private void pickNewDynamics(int n2, float f2) {
        this.mDestinationValues[this.mBlockPass] = new Dynamics(this.mSpeed, f2);
        this.incrementAndGetDrawPass();
        Dynamics[] arrdynamics = this.mDestinationValues;
        int n3 = this.mBlockPass;
        arrdynamics[n3].setTargetPosition((float)n2 * this.mBlockValues[n3][this.mDrawPass]);
    }

    private void updateRandomValues() {
        for (int i2 = 0; i2 < this.mBlockNumber; ++i2) {
            for (int i3 = 0; i3 < 10; ++i3) {
                this.mBlockValues[i2][i3] = this.mRandom.nextFloat();
                float[][] arrf = this.mBlockValues;
                if (!((double)arrf[i2][i3] < 0.1)) continue;
                arrf[i2][i3] = 0.1f;
            }
        }
    }

    public int getBlockNumber() {
        return this.mBlockNumber;
    }

    public float getBlockSpacing() {
        return this.mBlockSpacing;
    }

    public int getColor() {
        return this.mColor;
    }

    public int getSpeed() {
        return this.mSpeed;
    }

    @SuppressLint(value={"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        int n2;
        int n3;
        super.onDraw(canvas);
        this.mPaddingLeft = this.getPaddingLeft();
        this.mPaddingTop = this.getPaddingTop();
        this.mPaddingRight = this.getPaddingRight();
        this.mPaddingBottom = this.getPaddingBottom();
        this.mContentWidth = this.getWidth() - this.mPaddingLeft - this.mPaddingRight;
        this.mContentHeight = n2 = this.getHeight() - this.mPaddingTop - this.mPaddingBottom;
        if (this.mBlockWidth == 0) {
            float f2 = this.mContentWidth;
            int n4 = this.mBlockNumber;
            this.mBlockWidth = (int)((f2 - (float)(n4 - 1) * this.mBlockSpacing) / (float)n4);
            if (this.mState == 0) {
                int n5 = (int)((float)n2 - this.mStopSize);
                for (int i2 = 0; i2 < this.mBlockNumber; ++i2) {
                    this.mDestinationValues[i2] = new Dynamics(this.mSpeed, n5);
                    this.mDestinationValues[i2].setAtRest(true);
                }
            }
        }
        this.mBlockPass = 0;
        this.mBlockPass = 0;
        while ((n3 = this.mBlockPass) < this.mBlockNumber) {
            int n6;
            int n7;
            int n8;
            int n9 = this.mPaddingLeft;
            int n10 = this.mBlockWidth;
            this.mLeft = n7 = n9 + n3 * n10;
            this.mLeft = n8 = (int)((float)n7 + this.mBlockSpacing * (float)n3);
            this.mRight = n8 + n10;
            if (this.mDestinationValues[n3] == null) {
                int n11 = this.mContentHeight;
                this.pickNewDynamics(n11, (float)n11 * this.mBlockValues[n3][this.mDrawPass]);
            }
            if (this.mDestinationValues[this.mBlockPass].isAtRest() && this.mState == 2) {
                int n12 = this.mBlockPass;
                this.changeDynamicsTarget(n12, (float)this.mContentHeight * this.mBlockValues[n12][this.mDrawPass]);
            } else if (this.mState != 0) {
                this.mDestinationValues[this.mBlockPass].update();
            }
            this.mTop = n6 = this.mPaddingTop + (int)this.mDestinationValues[this.mBlockPass].getPosition();
            canvas.drawRect((float)this.mLeft, (float)n6, (float)this.mRight, (float)this.mContentHeight, this.mPaint);
            this.mBlockPass = 1 + this.mBlockPass;
        }
        this.postInvalidateDelayed(16L);
    }

    public void pause() {
        this.mState = 0;
    }

    public void resume(boolean bl) {
        if (this.mState == 0) {
            this.mState = 2;
            return;
        }
        this.mState = 2;
        if (!bl) {
            for (int i2 = 0; i2 < this.mBlockNumber; ++i2) {
                this.mDestinationValues[i2].setPosition((float)this.mContentHeight * this.mBlockValues[i2][this.mDrawPass]);
                this.changeDynamicsTarget(i2, (float)this.mContentHeight * this.mBlockValues[i2][this.mDrawPass]);
            }
        }
    }

    public void setBlockNumber(int n2) {
        this.mBlockNumber = n2;
        this.initialiseCollections();
        this.mBlockPass = 0;
        this.mBlockWidth = 0;
    }

    public void setBlockSpacing(float f2) {
        this.mBlockSpacing = f2;
        this.mBlockWidth = 0;
    }

    public void setColor(int n2) {
        this.mColor = n2;
        this.mPaint.setColor(n2);
    }

    public void setSpeed(int n2) {
        this.mSpeed = n2;
    }

    public void stop(boolean bl) {
        if (this.mDestinationValues == null) {
            this.initialiseCollections();
        }
        this.mState = 1;
        int n2 = (int)((float)this.mContentHeight - this.mStopSize);
        if (this.mDestinationValues.length <= 0) {
            return;
        }
        for (int i2 = 0; i2 < this.mBlockNumber; ++i2) {
            Dynamics[] arrdynamics = this.mDestinationValues;
            if (arrdynamics[i2] == null) continue;
            if (bl) {
                arrdynamics[i2].setTargetPosition(n2);
                continue;
            }
            arrdynamics[i2].setPosition(n2);
        }
    }
}

