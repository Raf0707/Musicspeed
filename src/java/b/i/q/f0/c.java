/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.text.SpannableString
 *  android.text.Spanned
 *  android.text.TextUtils
 *  android.text.style.ClickableSpan
 *  android.util.Log
 *  android.util.SparseArray
 *  android.view.View
 *  android.view.accessibility.AccessibilityNodeInfo
 *  android.view.accessibility.AccessibilityNodeInfo$AccessibilityAction
 *  android.view.accessibility.AccessibilityNodeInfo$CollectionInfo
 *  android.view.accessibility.AccessibilityNodeInfo$CollectionItemInfo
 *  b.i.q.f0.f$b
 *  b.i.q.f0.f$c
 *  b.i.q.f0.f$d
 *  b.i.q.f0.f$e
 *  b.i.q.f0.f$f
 *  b.i.q.f0.f$g
 *  b.i.q.f0.f$h
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Deprecated
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.ref.WeakReference
 *  java.lang.reflect.Constructor
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.List
 */
package b.i.q.f0;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import b.i.d;
import b.i.q.f0.f;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class c {
    private static int a;
    private final AccessibilityNodeInfo b;
    public int c = -1;
    private int d = -1;

    private c(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.b = accessibilityNodeInfo;
    }

    private int A(ClickableSpan clickableSpan, SparseArray<WeakReference<ClickableSpan>> sparseArray) {
        if (sparseArray != null) {
            for (int i2 = 0; i2 < sparseArray.size(); ++i2) {
                if (!clickableSpan.equals((Object)((ClickableSpan)((WeakReference)sparseArray.valueAt(i2)).get()))) continue;
                return sparseArray.keyAt(i2);
            }
        }
        int n2 = a;
        a = n2 + 1;
        return n2;
    }

    public static c F0(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new c(accessibilityNodeInfo);
    }

    public static c O() {
        return c.F0(AccessibilityNodeInfo.obtain());
    }

    public static c P(View view) {
        return c.F0(AccessibilityNodeInfo.obtain((View)view));
    }

    public static c Q(c c2) {
        return c.F0(AccessibilityNodeInfo.obtain((AccessibilityNodeInfo)c2.b));
    }

    private void U(View view) {
        SparseArray<WeakReference<ClickableSpan>> sparseArray = this.w(view);
        if (sparseArray != null) {
            ArrayList arrayList = new ArrayList();
            int n2 = 0;
            do {
                int n3 = sparseArray.size();
                if (n2 >= n3) break;
                if (((WeakReference)sparseArray.valueAt(n2)).get() == null) {
                    arrayList.add((Object)n2);
                }
                ++n2;
            } while (true);
            for (int i2 = 0; i2 < arrayList.size(); ++i2) {
                sparseArray.remove(((Integer)arrayList.get(i2)).intValue());
            }
        }
    }

    private void W(int n2, boolean bl) {
        Bundle bundle = this.t();
        if (bundle != null) {
            int n3 = bundle.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & n2;
            if (!bl) {
                n2 = 0;
            }
            bundle.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", n2 | n3);
        }
    }

    private void e(ClickableSpan clickableSpan, Spanned spanned, int n2) {
        this.h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add((Object)spanned.getSpanStart((Object)clickableSpan));
        this.h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add((Object)spanned.getSpanEnd((Object)clickableSpan));
        this.h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add((Object)spanned.getSpanFlags((Object)clickableSpan));
        this.h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add((Object)n2);
    }

    private void g() {
        if (Build.VERSION.SDK_INT >= 19) {
            this.b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            this.b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
            this.b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
            this.b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        }
    }

    private List<Integer> h(String string) {
        if (Build.VERSION.SDK_INT < 19) {
            return new ArrayList();
        }
        ArrayList arrayList = this.b.getExtras().getIntegerArrayList(string);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.b.getExtras().putIntegerArrayList(string, arrayList);
        }
        return arrayList;
    }

    private static String j(int n2) {
        if (n2 != 1) {
            if (n2 != 2) {
                switch (n2) {
                    default: {
                        switch (n2) {
                            default: {
                                switch (n2) {
                                    default: {
                                        return "ACTION_UNKNOWN";
                                    }
                                    case 16908362: {
                                        return "ACTION_PRESS_AND_HOLD";
                                    }
                                    case 16908361: {
                                        return "ACTION_PAGE_RIGHT";
                                    }
                                    case 16908360: {
                                        return "ACTION_PAGE_LEFT";
                                    }
                                    case 16908359: {
                                        return "ACTION_PAGE_DOWN";
                                    }
                                    case 16908358: {
                                        return "ACTION_PAGE_UP";
                                    }
                                    case 16908357: {
                                        return "ACTION_HIDE_TOOLTIP";
                                    }
                                    case 16908356: 
                                }
                                return "ACTION_SHOW_TOOLTIP";
                            }
                            case 16908349: {
                                return "ACTION_SET_PROGRESS";
                            }
                            case 16908348: {
                                return "ACTION_CONTEXT_CLICK";
                            }
                            case 16908347: {
                                return "ACTION_SCROLL_RIGHT";
                            }
                            case 16908346: {
                                return "ACTION_SCROLL_DOWN";
                            }
                            case 16908345: {
                                return "ACTION_SCROLL_LEFT";
                            }
                            case 16908344: {
                                return "ACTION_SCROLL_UP";
                            }
                            case 16908343: {
                                return "ACTION_SCROLL_TO_POSITION";
                            }
                            case 16908342: 
                        }
                        return "ACTION_SHOW_ON_SCREEN";
                    }
                    case 16908372: {
                        return "ACTION_IME_ENTER";
                    }
                    case 16908354: {
                        return "ACTION_MOVE_WINDOW";
                    }
                    case 2097152: {
                        return "ACTION_SET_TEXT";
                    }
                    case 524288: {
                        return "ACTION_COLLAPSE";
                    }
                    case 262144: {
                        return "ACTION_EXPAND";
                    }
                    case 131072: {
                        return "ACTION_SET_SELECTION";
                    }
                    case 65536: {
                        return "ACTION_CUT";
                    }
                    case 32768: {
                        return "ACTION_PASTE";
                    }
                    case 16384: {
                        return "ACTION_COPY";
                    }
                    case 8192: {
                        return "ACTION_SCROLL_BACKWARD";
                    }
                    case 4096: {
                        return "ACTION_SCROLL_FORWARD";
                    }
                    case 2048: {
                        return "ACTION_PREVIOUS_HTML_ELEMENT";
                    }
                    case 1024: {
                        return "ACTION_NEXT_HTML_ELEMENT";
                    }
                    case 512: {
                        return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
                    }
                    case 256: {
                        return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
                    }
                    case 128: {
                        return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
                    }
                    case 64: {
                        return "ACTION_ACCESSIBILITY_FOCUS";
                    }
                    case 32: {
                        return "ACTION_LONG_CLICK";
                    }
                    case 16: {
                        return "ACTION_CLICK";
                    }
                    case 8: {
                        return "ACTION_CLEAR_SELECTION";
                    }
                    case 4: 
                }
                return "ACTION_SELECT";
            }
            return "ACTION_CLEAR_FOCUS";
        }
        return "ACTION_FOCUS";
    }

    private boolean l(int n2) {
        Bundle bundle = this.t();
        if (bundle == null) {
            return false;
        }
        int n3 = n2 & bundle.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0);
        boolean bl = false;
        if (n3 == n2) {
            bl = true;
        }
        return bl;
    }

    public static ClickableSpan[] q(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[])((Spanned)charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    private SparseArray<WeakReference<ClickableSpan>> u(View view) {
        SparseArray sparseArray = this.w(view);
        if (sparseArray == null) {
            sparseArray = new SparseArray();
            view.setTag(d.Q, (Object)sparseArray);
        }
        return sparseArray;
    }

    private SparseArray<WeakReference<ClickableSpan>> w(View view) {
        return (SparseArray)view.getTag(d.Q);
    }

    private boolean z() {
        return true ^ this.h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    }

    public void A0(CharSequence charSequence) {
        if (b.i.m.a.a()) {
            this.b.setStateDescription(charSequence);
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            this.b.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence);
        }
    }

    public boolean B() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.b.isAccessibilityFocused();
        }
        return false;
    }

    public void B0(CharSequence charSequence) {
        this.b.setText(charSequence);
    }

    public boolean C() {
        return this.b.isCheckable();
    }

    public void C0(View view) {
        if (Build.VERSION.SDK_INT >= 22) {
            this.b.setTraversalAfter(view);
        }
    }

    public boolean D() {
        return this.b.isChecked();
    }

    public void D0(boolean bl) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.b.setVisibleToUser(bl);
        }
    }

    public boolean E() {
        return this.b.isClickable();
    }

    public AccessibilityNodeInfo E0() {
        return this.b;
    }

    public boolean F() {
        return this.b.isEnabled();
    }

    public boolean G() {
        return this.b.isFocusable();
    }

    public boolean H() {
        return this.b.isFocused();
    }

    public boolean I() {
        return this.b.isLongClickable();
    }

    public boolean J() {
        return this.b.isPassword();
    }

    public boolean K() {
        return this.b.isScrollable();
    }

    public boolean L() {
        return this.b.isSelected();
    }

    public boolean M() {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.b.isShowingHintText();
        }
        return this.l(4);
    }

    public boolean N() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.b.isVisibleToUser();
        }
        return false;
    }

    public boolean R(int n2, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.b.performAction(n2, bundle);
        }
        return false;
    }

    public void S() {
        this.b.recycle();
    }

    public boolean T(a a2) {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.b.removeAction((AccessibilityNodeInfo.AccessibilityAction)a2.N);
        }
        return false;
    }

    public void V(boolean bl) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.b.setAccessibilityFocused(bl);
        }
    }

    @Deprecated
    public void X(Rect rect) {
        this.b.setBoundsInParent(rect);
    }

    public void Y(Rect rect) {
        this.b.setBoundsInScreen(rect);
    }

    public void Z(boolean bl) {
        this.b.setCheckable(bl);
    }

    public void a(int n2) {
        this.b.addAction(n2);
    }

    public void a0(boolean bl) {
        this.b.setChecked(bl);
    }

    public void b(a a2) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.b.addAction((AccessibilityNodeInfo.AccessibilityAction)a2.N);
        }
    }

    public void b0(CharSequence charSequence) {
        this.b.setClassName(charSequence);
    }

    public void c(View view) {
        this.b.addChild(view);
    }

    public void c0(boolean bl) {
        this.b.setClickable(bl);
    }

    public void d(View view, int n2) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.b.addChild(view, n2);
        }
    }

    public void d0(Object object) {
        if (Build.VERSION.SDK_INT >= 19) {
            AccessibilityNodeInfo accessibilityNodeInfo = this.b;
            AccessibilityNodeInfo.CollectionInfo collectionInfo = object == null ? null : (AccessibilityNodeInfo.CollectionInfo)((b)object).a;
            accessibilityNodeInfo.setCollectionInfo(collectionInfo);
        }
    }

    public void e0(Object object) {
        if (Build.VERSION.SDK_INT >= 19) {
            AccessibilityNodeInfo accessibilityNodeInfo = this.b;
            AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo = object == null ? null : (AccessibilityNodeInfo.CollectionItemInfo)((c)object).a;
            accessibilityNodeInfo.setCollectionItemInfo(collectionItemInfo);
        }
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!(object instanceof c)) {
            return false;
        }
        c c2 = (c)object;
        AccessibilityNodeInfo accessibilityNodeInfo = this.b;
        if (accessibilityNodeInfo == null ? c2.b != null : !accessibilityNodeInfo.equals((Object)c2.b)) {
            return false;
        }
        if (this.d != c2.d) {
            return false;
        }
        return this.c == c2.c;
    }

    public void f(CharSequence charSequence, View view) {
        int n2 = Build.VERSION.SDK_INT;
        if (n2 >= 19 && n2 < 26) {
            this.g();
            this.U(view);
            ClickableSpan[] arrclickableSpan = c.q(charSequence);
            if (arrclickableSpan != null && arrclickableSpan.length > 0) {
                this.t().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", d.a);
                SparseArray<WeakReference<ClickableSpan>> sparseArray = this.u(view);
                for (int i2 = 0; i2 < arrclickableSpan.length; ++i2) {
                    int n3 = this.A(arrclickableSpan[i2], sparseArray);
                    sparseArray.put(n3, (Object)new WeakReference((Object)arrclickableSpan[i2]));
                    this.e(arrclickableSpan[i2], (Spanned)charSequence, n3);
                }
            }
        }
    }

    public void f0(CharSequence charSequence) {
        this.b.setContentDescription(charSequence);
    }

    public void g0(boolean bl) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.b.setDismissable(bl);
        }
    }

    public void h0(boolean bl) {
        this.b.setEnabled(bl);
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.b;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public List<a> i() {
        List list = Build.VERSION.SDK_INT >= 21 ? this.b.getActionList() : null;
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            int n2 = list.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                arrayList.add((Object)new a(list.get(i2)));
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    public void i0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.b.setError(charSequence);
        }
    }

    public void j0(boolean bl) {
        this.b.setFocusable(bl);
    }

    public int k() {
        return this.b.getActions();
    }

    public void k0(boolean bl) {
        this.b.setFocused(bl);
    }

    public void l0(boolean bl) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.b.setHeading(bl);
            return;
        }
        this.W(2, bl);
    }

    @Deprecated
    public void m(Rect rect) {
        this.b.getBoundsInParent(rect);
    }

    public void m0(CharSequence charSequence) {
        int n2 = Build.VERSION.SDK_INT;
        if (n2 >= 26) {
            this.b.setHintText(charSequence);
            return;
        }
        if (n2 >= 19) {
            this.b.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", charSequence);
        }
    }

    public void n(Rect rect) {
        this.b.getBoundsInScreen(rect);
    }

    public void n0(boolean bl) {
        this.b.setLongClickable(bl);
    }

    public int o() {
        return this.b.getChildCount();
    }

    public void o0(int n2) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.b.setMaxTextLength(n2);
        }
    }

    public CharSequence p() {
        return this.b.getClassName();
    }

    public void p0(CharSequence charSequence) {
        this.b.setPackageName(charSequence);
    }

    public void q0(CharSequence charSequence) {
        int n2 = Build.VERSION.SDK_INT;
        if (n2 >= 28) {
            this.b.setPaneTitle(charSequence);
            return;
        }
        if (n2 >= 19) {
            this.b.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
        }
    }

    public c r() {
        AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo;
        if (Build.VERSION.SDK_INT >= 19 && (collectionItemInfo = this.b.getCollectionItemInfo()) != null) {
            return new c((Object)collectionItemInfo);
        }
        return null;
    }

    public void r0(View view) {
        this.c = -1;
        this.b.setParent(view);
    }

    public CharSequence s() {
        return this.b.getContentDescription();
    }

    public void s0(View view, int n2) {
        this.c = n2;
        if (Build.VERSION.SDK_INT >= 16) {
            this.b.setParent(view, n2);
        }
    }

    public Bundle t() {
        if (Build.VERSION.SDK_INT >= 19) {
            return this.b.getExtras();
        }
        return new Bundle();
    }

    public void t0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.b.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", charSequence);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        Rect rect = new Rect();
        this.m(rect);
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("; boundsInParent: ");
        stringBuilder2.append((Object)rect);
        stringBuilder.append(stringBuilder2.toString());
        this.n(rect);
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("; boundsInScreen: ");
        stringBuilder3.append((Object)rect);
        stringBuilder.append(stringBuilder3.toString());
        stringBuilder.append("; packageName: ");
        stringBuilder.append(this.v());
        stringBuilder.append("; className: ");
        stringBuilder.append(this.p());
        stringBuilder.append("; text: ");
        stringBuilder.append(this.x());
        stringBuilder.append("; contentDescription: ");
        stringBuilder.append(this.s());
        stringBuilder.append("; viewId: ");
        stringBuilder.append(this.y());
        stringBuilder.append("; checkable: ");
        stringBuilder.append(this.C());
        stringBuilder.append("; checked: ");
        stringBuilder.append(this.D());
        stringBuilder.append("; focusable: ");
        stringBuilder.append(this.G());
        stringBuilder.append("; focused: ");
        stringBuilder.append(this.H());
        stringBuilder.append("; selected: ");
        stringBuilder.append(this.L());
        stringBuilder.append("; clickable: ");
        stringBuilder.append(this.E());
        stringBuilder.append("; longClickable: ");
        stringBuilder.append(this.I());
        stringBuilder.append("; enabled: ");
        stringBuilder.append(this.F());
        stringBuilder.append("; password: ");
        stringBuilder.append(this.J());
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append("; scrollable: ");
        stringBuilder4.append(this.K());
        stringBuilder.append(stringBuilder4.toString());
        stringBuilder.append("; [");
        if (Build.VERSION.SDK_INT >= 21) {
            List<a> list = this.i();
            for (int i2 = 0; i2 < list.size(); ++i2) {
                a a2 = (a)list.get(i2);
                String string = c.j(a2.b());
                if (string.equals((Object)"ACTION_UNKNOWN") && a2.c() != null) {
                    string = a2.c().toString();
                }
                stringBuilder.append(string);
                if (i2 == list.size() - 1) continue;
                stringBuilder.append(", ");
            }
        } else {
            int n2 = this.k();
            while (n2 != 0) {
                int n3 = 1 << Integer.numberOfTrailingZeros((int)n2);
                stringBuilder.append(c.j(n3));
                if ((n2 &= n3) == 0) continue;
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void u0(boolean bl) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.b.setScreenReaderFocusable(bl);
            return;
        }
        this.W(1, bl);
    }

    public CharSequence v() {
        return this.b.getPackageName();
    }

    public void v0(boolean bl) {
        this.b.setScrollable(bl);
    }

    public void w0(boolean bl) {
        this.b.setSelected(bl);
    }

    public CharSequence x() {
        if (this.z()) {
            List<Integer> list = this.h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            List<Integer> list2 = this.h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
            List<Integer> list3 = this.h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
            List<Integer> list4 = this.h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
            CharSequence charSequence = this.b.getText();
            int n2 = this.b.getText().length();
            SpannableString spannableString = new SpannableString((CharSequence)TextUtils.substring((CharSequence)charSequence, (int)0, (int)n2));
            for (int i2 = 0; i2 < list.size(); ++i2) {
                spannableString.setSpan((Object)new b.i.q.f0.a((Integer)list4.get(i2), this, this.t().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), ((Integer)list.get(i2)).intValue(), ((Integer)list2.get(i2)).intValue(), ((Integer)list3.get(i2)).intValue());
            }
            return spannableString;
        }
        return this.b.getText();
    }

    public void x0(boolean bl) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.b.setShowingHintText(bl);
            return;
        }
        this.W(4, bl);
    }

    public String y() {
        if (Build.VERSION.SDK_INT >= 18) {
            return this.b.getViewIdResourceName();
        }
        return null;
    }

    public void y0(View view) {
        this.d = -1;
        this.b.setSource(view);
    }

    public void z0(View view, int n2) {
        this.d = n2;
        if (Build.VERSION.SDK_INT >= 16) {
            this.b.setSource(view, n2);
        }
    }

    public static class a {
        public static final a A;
        public static final a B;
        public static final a C;
        public static final a D;
        public static final a E;
        public static final a F;
        public static final a G;
        public static final a H;
        public static final a I;
        public static final a J;
        public static final a K;
        public static final a L;
        public static final a M;
        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        public static final a e;
        public static final a f;
        public static final a g;
        public static final a h;
        public static final a i;
        public static final a j;
        public static final a k;
        public static final a l;
        public static final a m;
        public static final a n;
        public static final a o;
        public static final a p;
        public static final a q;
        public static final a r;
        public static final a s;
        public static final a t;
        public static final a u;
        public static final a v;
        public static final a w;
        public static final a x;
        public static final a y;
        public static final a z;
        final Object N;
        private final int O;
        private final Class<? extends f.a> P;
        protected final f Q;

        static {
            a a2;
            a a3;
            a a4;
            a a5;
            a a6;
            a a7;
            a a8;
            a a9;
            a a10;
            a a11;
            a a12;
            a a13;
            a a14;
            a a15;
            a a16;
            a a17;
            a a18;
            a = new a(1, null);
            b = new a(2, null);
            c = new a(4, null);
            d = new a(8, null);
            e = new a(16, null);
            f = new a(32, null);
            g = new a(64, null);
            h = new a(128, null);
            i = new a(256, null, f.b.class);
            j = new a(512, null, f.b.class);
            k = new a(1024, null, f.c.class);
            l = new a(2048, null, f.c.class);
            m = new a(4096, null);
            n = new a(8192, null);
            o = new a(16384, null);
            p = new a(32768, null);
            q = new a(65536, null);
            r = new a(131072, null, f.g.class);
            s = new a(262144, null);
            t = new a(524288, null);
            u = new a(1048576, null);
            v = new a(2097152, null, f.h.class);
            int n2 = Build.VERSION.SDK_INT;
            Object object = n2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN : null;
            w = a12 = new a(object, 16908342, null, null, null);
            Object object2 = n2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION : null;
            x = a17 = new a(object2, 16908343, null, null, f.e.class);
            Object object3 = n2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP : null;
            y = a7 = new a(object3, 16908344, null, null, null);
            Object object4 = n2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT : null;
            z = a9 = new a(object4, 16908345, null, null, null);
            Object object5 = n2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN : null;
            A = a15 = new a(object5, 16908346, null, null, null);
            Object object6 = n2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT : null;
            B = a3 = new a(object6, 16908347, null, null, null);
            Object object7 = n2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null;
            C = a5 = new a(object7, 16908358, null, null, null);
            Object object8 = n2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null;
            D = a11 = new a(object8, 16908359, null, null, null);
            Object object9 = n2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null;
            E = a6 = new a(object9, 16908360, null, null, null);
            Object object10 = n2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null;
            F = a18 = new a(object10, 16908361, null, null, null);
            Object object11 = n2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK : null;
            G = a16 = new a(object11, 16908348, null, null, null);
            Object object12 = n2 >= 24 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS : null;
            H = a13 = new a(object12, 16908349, null, null, f.f.class);
            Object object13 = n2 >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null;
            I = a8 = new a(object13, 16908354, null, null, f.d.class);
            Object object14 = n2 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null;
            J = a4 = new a(object14, 16908356, null, null, null);
            Object object15 = n2 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP : null;
            K = a10 = new a(object15, 16908357, null, null, null);
            Object object16 = n2 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null;
            L = a14 = new a(object16, 16908362, null, null, null);
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction = null;
            if (n2 >= 30) {
                accessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER;
            }
            M = a2 = new a((Object)accessibilityAction, 16908372, null, null, null);
        }

        public a(int n2, CharSequence charSequence) {
            this(null, n2, charSequence, null, null);
        }

        public a(int n2, CharSequence charSequence, f f2) {
            this(null, n2, charSequence, f2, null);
        }

        private a(int n2, CharSequence charSequence, Class<? extends f.a> class_) {
            this(null, n2, charSequence, null, class_);
        }

        a(Object object) {
            this(object, 0, null, null, null);
        }

        a(Object object, int n2, CharSequence charSequence, f f2, Class<? extends f.a> class_) {
            this.O = n2;
            this.Q = f2;
            this.N = Build.VERSION.SDK_INT >= 21 && object == null ? new AccessibilityNodeInfo.AccessibilityAction(n2, charSequence) : object;
            this.P = class_;
        }

        public a a(CharSequence charSequence, f f2) {
            a a2 = new a(null, this.O, charSequence, f2, this.P);
            return a2;
        }

        public int b() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.AccessibilityAction)this.N).getId();
            }
            return 0;
        }

        public CharSequence c() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.AccessibilityAction)this.N).getLabel();
            }
            return null;
        }

        /*
         * Loose catch block
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Lifted jumps to return sites
         */
        public boolean d(View view, Bundle bundle) {
            void var5_8;
            f.a a2;
            block4 : {
                if (this.Q == null) return false;
                Class<? extends f.a> class_ = this.P;
                a2 = null;
                if (class_ == null) return this.Q.a(view, a2);
                f.a a3 = (f.a)class_.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                try {
                    a3.a(bundle);
                    a2 = a3;
                    return this.Q.a(view, a2);
                }
                catch (Exception exception) {
                    a2 = a3;
                }
                break block4;
                catch (Exception exception) {
                    // empty catch block
                }
            }
            Class<? extends f.a> class_2 = this.P;
            String string = class_2 == null ? "null" : class_2.getName();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to execute command with argument class ViewCommandArgument: ");
            stringBuilder.append(string);
            Log.e((String)"A11yActionCompat", (String)stringBuilder.toString(), (Throwable)var5_8);
            return this.Q.a(view, a2);
        }

        public boolean equals(Object object) {
            if (object == null) {
                return false;
            }
            if (!(object instanceof a)) {
                return false;
            }
            a a2 = (a)object;
            Object object2 = this.N;
            return !(object2 == null ? a2.N != null : !object2.equals(a2.N));
        }

        public int hashCode() {
            Object object = this.N;
            if (object != null) {
                return object.hashCode();
            }
            return 0;
        }
    }

    public static class b {
        final Object a;

        b(Object object) {
            this.a = object;
        }

        public static b a(int n2, int n3, boolean bl, int n4) {
            int n5 = Build.VERSION.SDK_INT;
            if (n5 >= 21) {
                return new b((Object)AccessibilityNodeInfo.CollectionInfo.obtain((int)n2, (int)n3, (boolean)bl, (int)n4));
            }
            if (n5 >= 19) {
                return new b((Object)AccessibilityNodeInfo.CollectionInfo.obtain((int)n2, (int)n3, (boolean)bl));
            }
            return new b(null);
        }
    }

    public static class c {
        final Object a;

        c(Object object) {
            this.a = object;
        }

        public static c f(int n2, int n3, int n4, int n5, boolean bl, boolean bl2) {
            int n6 = Build.VERSION.SDK_INT;
            if (n6 >= 21) {
                return new c((Object)AccessibilityNodeInfo.CollectionItemInfo.obtain((int)n2, (int)n3, (int)n4, (int)n5, (boolean)bl, (boolean)bl2));
            }
            if (n6 >= 19) {
                return new c((Object)AccessibilityNodeInfo.CollectionItemInfo.obtain((int)n2, (int)n3, (int)n4, (int)n5, (boolean)bl));
            }
            return new c(null);
        }

        public int a() {
            if (Build.VERSION.SDK_INT >= 19) {
                return ((AccessibilityNodeInfo.CollectionItemInfo)this.a).getColumnIndex();
            }
            return 0;
        }

        public int b() {
            if (Build.VERSION.SDK_INT >= 19) {
                return ((AccessibilityNodeInfo.CollectionItemInfo)this.a).getColumnSpan();
            }
            return 0;
        }

        public int c() {
            if (Build.VERSION.SDK_INT >= 19) {
                return ((AccessibilityNodeInfo.CollectionItemInfo)this.a).getRowIndex();
            }
            return 0;
        }

        public int d() {
            if (Build.VERSION.SDK_INT >= 19) {
                return ((AccessibilityNodeInfo.CollectionItemInfo)this.a).getRowSpan();
            }
            return 0;
        }

        public boolean e() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.CollectionItemInfo)this.a).isSelected();
            }
            return false;
        }
    }

}

