/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewParent
 *  b.i.q.w
 *  b.w.u
 *  java.lang.Class
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.Method
 *  java.util.ArrayList
 */
package b.w;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import b.i.q.w;
import b.w.b0;
import b.w.u;
import java.lang.reflect.Method;
import java.util.ArrayList;

class z
implements b0 {
    protected a a;

    z(Context context, ViewGroup viewGroup, View view) {
        this.a = new a(context, viewGroup, view, this);
    }

    static z e(View view) {
        ViewGroup viewGroup = z.f(view);
        if (viewGroup != null) {
            int n2 = viewGroup.getChildCount();
            for (int i2 = 0; i2 < n2; ++i2) {
                View view2 = viewGroup.getChildAt(i2);
                if (!(view2 instanceof a)) continue;
                return ((a)view2).j;
            }
            return new u(viewGroup.getContext(), viewGroup, view);
        }
        return null;
    }

    static ViewGroup f(View view) {
        while (view != null) {
            if (view.getId() == 16908290 && view instanceof ViewGroup) {
                return (ViewGroup)view;
            }
            if (!(view.getParent() instanceof ViewGroup)) continue;
            view = (ViewGroup)view.getParent();
        }
        return null;
    }

    @Override
    public void a(Drawable drawable) {
        this.a.a(drawable);
    }

    @Override
    public void b(Drawable drawable) {
        this.a.f(drawable);
    }

    static class a
    extends ViewGroup {
        static Method f;
        ViewGroup g;
        View h;
        ArrayList<Drawable> i = null;
        z j;
        private boolean k;

        static {
            try {
                Class class_ = Integer.TYPE;
                Class[] arrclass = new Class[]{class_, class_, Rect.class};
                f = ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", arrclass);
            }
            catch (NoSuchMethodException noSuchMethodException) {}
        }

        a(Context context, ViewGroup viewGroup, View view, z z2) {
            super(context);
            this.g = viewGroup;
            this.h = view;
            this.setRight(viewGroup.getWidth());
            this.setBottom(viewGroup.getHeight());
            viewGroup.addView((View)this);
            this.j = z2;
        }

        private void c() {
            if (!this.k) {
                return;
            }
            throw new IllegalStateException("This overlay was disposed already. Please use a new one via ViewGroupUtils.getOverlay()");
        }

        private void d() {
            ArrayList<Drawable> arrayList;
            if (this.getChildCount() == 0 && ((arrayList = this.i) == null || arrayList.size() == 0)) {
                this.k = true;
                this.g.removeView((View)this);
            }
        }

        private void e(int[] arrn) {
            int[] arrn2 = new int[2];
            int[] arrn3 = new int[2];
            this.g.getLocationOnScreen(arrn2);
            this.h.getLocationOnScreen(arrn3);
            arrn[0] = arrn3[0] - arrn2[0];
            arrn[1] = arrn3[1] - arrn2[1];
        }

        public void a(Drawable drawable) {
            this.c();
            if (this.i == null) {
                this.i = new ArrayList();
            }
            if (!this.i.contains((Object)drawable)) {
                this.i.add((Object)drawable);
                this.invalidate(drawable.getBounds());
                drawable.setCallback((Drawable.Callback)this);
            }
        }

        public void b(View view) {
            this.c();
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup)view.getParent();
                if (viewGroup != this.g && viewGroup.getParent() != null && w.V((View)viewGroup)) {
                    int[] arrn = new int[2];
                    int[] arrn2 = new int[2];
                    viewGroup.getLocationOnScreen(arrn);
                    this.g.getLocationOnScreen(arrn2);
                    w.b0((View)view, (int)(arrn[0] - arrn2[0]));
                    w.c0((View)view, (int)(arrn[1] - arrn2[1]));
                }
                viewGroup.removeView(view);
                if (view.getParent() != null) {
                    viewGroup.removeView(view);
                }
            }
            super.addView(view);
        }

        protected void dispatchDraw(Canvas canvas) {
            int n2;
            int[] arrn = new int[2];
            int[] arrn2 = new int[2];
            this.g.getLocationOnScreen(arrn);
            this.h.getLocationOnScreen(arrn2);
            int n3 = 0;
            canvas.translate((float)(arrn2[0] - arrn[0]), (float)(arrn2[1] - arrn[1]));
            canvas.clipRect(new Rect(0, 0, this.h.getWidth(), this.h.getHeight()));
            super.dispatchDraw(canvas);
            ArrayList<Drawable> arrayList = this.i;
            if (arrayList == null) {
                n2 = 0;
                n3 = 0;
            } else {
                n2 = arrayList.size();
            }
            while (n3 < n2) {
                ((Drawable)this.i.get(n3)).draw(canvas);
                ++n3;
            }
        }

        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        public void f(Drawable drawable) {
            ArrayList<Drawable> arrayList = this.i;
            if (arrayList != null) {
                arrayList.remove((Object)drawable);
                this.invalidate(drawable.getBounds());
                drawable.setCallback(null);
                this.d();
            }
        }

        public void g(View view) {
            super.removeView(view);
            this.d();
        }

        public ViewParent invalidateChildInParent(int[] arrn, Rect rect) {
            if (this.g != null) {
                rect.offset(arrn[0], arrn[1]);
                if (this.g instanceof ViewGroup) {
                    arrn[0] = 0;
                    arrn[1] = 0;
                    int[] arrn2 = new int[2];
                    this.e(arrn2);
                    rect.offset(arrn2[0], arrn2[1]);
                    return super.invalidateChildInParent(arrn, rect);
                }
                this.invalidate(rect);
            }
            return null;
        }

        public void invalidateDrawable(Drawable drawable) {
            this.invalidate(drawable.getBounds());
        }

        protected void onLayout(boolean bl, int n2, int n3, int n4, int n5) {
        }

        protected boolean verifyDrawable(Drawable drawable) {
            ArrayList<Drawable> arrayList;
            return super.verifyDrawable(drawable) || (arrayList = this.i) != null && arrayList.contains((Object)drawable);
            {
            }
        }
    }

}

