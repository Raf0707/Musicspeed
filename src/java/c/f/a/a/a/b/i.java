/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package c.f.a.a.a.b;

public class i {
    private final int a;
    private final int b;

    public i(int n2, int n3) {
        if (n2 <= n3) {
            this.a = n2;
            this.b = n3;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("end position (= ");
        stringBuilder.append(n3);
        stringBuilder.append(") is smaller than start position (=");
        stringBuilder.append(n2);
        stringBuilder.append(")");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public boolean a(int n2) {
        return n2 >= this.a && n2 <= this.b;
    }

    protected String b() {
        return "ItemDraggableRange";
    }

    public int c() {
        return this.b;
    }

    public int d() {
        return this.a;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.b());
        stringBuilder.append("{");
        stringBuilder.append("mStart=");
        stringBuilder.append(this.a);
        stringBuilder.append(", mEnd=");
        stringBuilder.append(this.b);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

