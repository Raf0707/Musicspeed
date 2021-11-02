/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.ActionMode
 *  android.view.ActionMode$Callback
 *  android.view.KeyEvent
 *  android.view.KeyboardShortcutGroup
 *  android.view.Menu
 *  android.view.MenuItem
 *  android.view.MotionEvent
 *  android.view.SearchEvent
 *  android.view.View
 *  android.view.Window
 *  android.view.Window$Callback
 *  android.view.WindowManager
 *  android.view.WindowManager$LayoutParams
 *  android.view.accessibility.AccessibilityEvent
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package b.a.o;

import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public class i
implements Window.Callback {
    final Window.Callback f;

    public i(Window.Callback callback) {
        if (callback != null) {
            this.f = callback;
            return;
        }
        throw new IllegalArgumentException("Window callback may not be null");
    }

    public final Window.Callback a() {
        return this.f;
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.f.dispatchGenericMotionEvent(motionEvent);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.f.dispatchKeyShortcutEvent(keyEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.f.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.f.dispatchTouchEvent(motionEvent);
    }

    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.f.dispatchTrackballEvent(motionEvent);
    }

    public void onActionModeFinished(ActionMode actionMode) {
        this.f.onActionModeFinished(actionMode);
    }

    public void onActionModeStarted(ActionMode actionMode) {
        this.f.onActionModeStarted(actionMode);
    }

    public void onAttachedToWindow() {
        this.f.onAttachedToWindow();
    }

    public void onContentChanged() {
        this.f.onContentChanged();
    }

    public boolean onCreatePanelMenu(int n2, Menu menu) {
        return this.f.onCreatePanelMenu(n2, menu);
    }

    public View onCreatePanelView(int n2) {
        return this.f.onCreatePanelView(n2);
    }

    public void onDetachedFromWindow() {
        this.f.onDetachedFromWindow();
    }

    public boolean onMenuItemSelected(int n2, MenuItem menuItem) {
        return this.f.onMenuItemSelected(n2, menuItem);
    }

    public boolean onMenuOpened(int n2, Menu menu) {
        return this.f.onMenuOpened(n2, menu);
    }

    public void onPanelClosed(int n2, Menu menu) {
        this.f.onPanelClosed(n2, menu);
    }

    public void onPointerCaptureChanged(boolean bl) {
        this.f.onPointerCaptureChanged(bl);
    }

    public boolean onPreparePanel(int n2, View view, Menu menu) {
        return this.f.onPreparePanel(n2, view, menu);
    }

    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int n2) {
        this.f.onProvideKeyboardShortcuts(list, menu, n2);
    }

    public boolean onSearchRequested() {
        return this.f.onSearchRequested();
    }

    public boolean onSearchRequested(SearchEvent searchEvent) {
        return this.f.onSearchRequested(searchEvent);
    }

    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.f.onWindowAttributesChanged(layoutParams);
    }

    public void onWindowFocusChanged(boolean bl) {
        this.f.onWindowFocusChanged(bl);
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return this.f.onWindowStartingActionMode(callback);
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int n2) {
        return this.f.onWindowStartingActionMode(callback, n2);
    }
}

