/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.text.style.ClickableSpan
 *  android.util.SparseArray
 *  android.view.View
 *  android.view.View$AccessibilityDelegate
 *  android.view.ViewGroup
 *  android.view.accessibility.AccessibilityEvent
 *  android.view.accessibility.AccessibilityNodeInfo
 *  android.view.accessibility.AccessibilityNodeProvider
 *  b.i.q.w
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.ref.WeakReference
 *  java.util.Collections
 *  java.util.List
 */
package b.i.q;

import android.os.Build;
import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import b.i.q.f0.c;
import b.i.q.f0.d;
import b.i.q.w;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

public class a {
    private static final View.AccessibilityDelegate a = new View.AccessibilityDelegate();
    private final View.AccessibilityDelegate b;
    private final View.AccessibilityDelegate c;

    public a() {
        this(a);
    }

    public a(View.AccessibilityDelegate accessibilityDelegate) {
        this.b = accessibilityDelegate;
        this.c = new a(this);
    }

    static List<c.a> c(View view) {
        List list = (List)view.getTag(b.i.d.P);
        if (list == null) {
            list = Collections.emptyList();
        }
        return list;
    }

    private boolean e(ClickableSpan clickableSpan, View view) {
        if (clickableSpan != null) {
            ClickableSpan[] arrclickableSpan = c.q(view.createAccessibilityNodeInfo().getText());
            for (int i2 = 0; arrclickableSpan != null && i2 < arrclickableSpan.length; ++i2) {
                if (!clickableSpan.equals((Object)arrclickableSpan[i2])) continue;
                return true;
            }
        }
        return false;
    }

    private boolean k(int n2, View view) {
        WeakReference weakReference;
        ClickableSpan clickableSpan;
        SparseArray sparseArray = (SparseArray)view.getTag(b.i.d.Q);
        if (sparseArray != null && (weakReference = (WeakReference)sparseArray.get(n2)) != null && this.e(clickableSpan = (ClickableSpan)weakReference.get(), view)) {
            clickableSpan.onClick(view);
            return true;
        }
        return false;
    }

    public boolean a(View view, AccessibilityEvent accessibilityEvent) {
        return this.b.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public d b(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider;
        if (Build.VERSION.SDK_INT >= 16 && (accessibilityNodeProvider = this.b.getAccessibilityNodeProvider(view)) != null) {
            return new d((Object)accessibilityNodeProvider);
        }
        return null;
    }

    View.AccessibilityDelegate d() {
        return this.c;
    }

    public void f(View view, AccessibilityEvent accessibilityEvent) {
        this.b.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void g(View view, c c2) {
        this.b.onInitializeAccessibilityNodeInfo(view, c2.E0());
    }

    public void h(View view, AccessibilityEvent accessibilityEvent) {
        this.b.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.b.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean j(View view, int n2, Bundle bundle) {
        boolean bl;
        List<c.a> list = a.c(view);
        int n3 = 0;
        do {
            int n4 = list.size();
            bl = false;
            if (n3 >= n4) break;
            c.a a2 = (c.a)list.get(n3);
            if (a2.b() == n2) {
                bl = a2.d(view, bundle);
                break;
            }
            ++n3;
        } while (true);
        if (!bl && Build.VERSION.SDK_INT >= 16) {
            bl = this.b.performAccessibilityAction(view, n2, bundle);
        }
        if (!bl && n2 == b.i.d.a) {
            bl = this.k(bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1), view);
        }
        return bl;
    }

    public void l(View view, int n2) {
        this.b.sendAccessibilityEvent(view, n2);
    }

    public void m(View view, AccessibilityEvent accessibilityEvent) {
        this.b.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    static final class a
    extends View.AccessibilityDelegate {
        final a a;

        a(a a2) {
            this.a = a2;
        }

        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.a.a(view, accessibilityEvent);
        }

        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            d d2 = this.a.b(view);
            if (d2 != null) {
                return (AccessibilityNodeProvider)d2.e();
            }
            return null;
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.a.f(view, accessibilityEvent);
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            c c2 = c.F0(accessibilityNodeInfo);
            c2.u0(w.Z((View)view));
            c2.l0(w.U((View)view));
            c2.q0(w.p((View)view));
            c2.A0(w.L((View)view));
            this.a.g(view, c2);
            c2.f(accessibilityNodeInfo.getText(), view);
            List<c.a> list = a.c(view);
            for (int i2 = 0; i2 < list.size(); ++i2) {
                c2.b((c.a)list.get(i2));
            }
        }

        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.a.h(view, accessibilityEvent);
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.a.i(viewGroup, view, accessibilityEvent);
        }

        public boolean performAccessibilityAction(View view, int n2, Bundle bundle) {
            return this.a.j(view, n2, bundle);
        }

        public void sendAccessibilityEvent(View view, int n2) {
            this.a.l(view, n2);
        }

        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.a.m(view, accessibilityEvent);
        }
    }

}

