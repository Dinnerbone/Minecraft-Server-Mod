import java.util.Random;

public class gj extends dx {
    public hl a;
    private int e;
    public int b = 0;
    public int c;
    // hMod: This is set to private/5 by the server, it needs to be public/0
    public int f = 0;

    public float d = (float) (Math.random() * 3.141592653589793D * 2.0D);

    public gj(eo parameo, double paramDouble1, double paramDouble2, double paramDouble3, hl paramhl) {
        super(parameo);
        a(0.25F, 0.25F);
        this.H = (this.J / 2.0F);
        a(paramDouble1, paramDouble2, paramDouble3);
        this.a = paramhl;

        this.v = (float) (Math.random() * 360.0D);

        this.s = (float) (Math.random() * 0.2000000029802322D - 0.1000000014901161D);
        this.t = 0.2000000029802322D;
        this.u = (float) (Math.random() * 0.2000000029802322D - 0.1000000014901161D);
        this.M = false;
    }

    public gj(eo parameo) {
        super(parameo);
        a(0.25F, 0.25F);
        this.H = (this.J / 2.0F);
    }

    @Override
    public void b_() {
        super.b_();
        if (this.c > 0) {
            this.c -= 1;
        }
        this.m = this.p;
        this.n = this.q;
        this.o = this.r;

        this.t -= 0.03999999910593033D;
        if (this.l.c(hf.b(this.p), hf.b(this.q), hf.b(this.r)) == jw.g) {
            this.t = 0.2000000029802322D;
            this.s = ((this.W.nextFloat() - this.W.nextFloat()) * 0.2F);
            this.u = ((this.W.nextFloat() - this.W.nextFloat()) * 0.2F);
            this.l.a(this, "random.fizz", 0.4F, 2.0F + this.W.nextFloat() * 0.4F);
        }
        g(this.p, this.q, this.r);
        r();
        c(this.s, this.t, this.u);

        float f1 = 0.98F;
        if (this.A) {
            f1 = 0.5880001F;
            int i = this.l.a(hf.b(this.p), hf.b(this.z.b) - 1, hf.b(this.r));
            if (i > 0) {
                f1 = ga.m[i].bt * 0.98F;
            }
        }

        this.s *= f1;
        this.t *= 0.9800000190734863D;
        this.u *= f1;

        if (this.A) {
            this.t *= -0.5D;
        }

        this.e += 1;
        this.b += 1;
        if (this.b >= 6000) {
            l();
        }
    }

    @Override
    public boolean r() {
        return this.l.a(this.z, jw.f, this);
    }

    private boolean g(double paramDouble1, double paramDouble2, double paramDouble3) {
        int i = hf.b(paramDouble1);
        int j = hf.b(paramDouble2);
        int k = hf.b(paramDouble3);

        double d1 = paramDouble1 - i;
        double d2 = paramDouble2 - j;
        double d3 = paramDouble3 - k;

        if (ga.o[this.l.a(i, j, k)] != false) {
            int m = ga.o[this.l.a(i - 1, j, k)] == false ? 1 : 0;
            int n = ga.o[this.l.a(i + 1, j, k)] == false ? 1 : 0;
            int i1 = ga.o[this.l.a(i, j - 1, k)] == false ? 1 : 0;
            int i2 = ga.o[this.l.a(i, j + 1, k)] == false ? 1 : 0;
            int i3 = ga.o[this.l.a(i, j, k - 1)] == false ? 1 : 0;
            int i4 = ga.o[this.l.a(i, j, k + 1)] == false ? 1 : 0;

            int i5 = -1;
            double d4 = 9999.0D;
            if ((m != 0) && (d1 < d4)) {
                d4 = d1;
                i5 = 0;
            }
            if ((n != 0) && (1.0D - d1 < d4)) {
                d4 = 1.0D - d1;
                i5 = 1;
            }
            if ((i1 != 0) && (d2 < d4)) {
                d4 = d2;
                i5 = 2;
            }
            if ((i2 != 0) && (1.0D - d2 < d4)) {
                d4 = 1.0D - d2;
                i5 = 3;
            }
            if ((i3 != 0) && (d3 < d4)) {
                d4 = d3;
                i5 = 4;
            }
            if ((i4 != 0) && (1.0D - d3 < d4)) {
                d4 = 1.0D - d3;
                i5 = 5;
            }

            float f1 = this.W.nextFloat() * 0.2F + 0.1F;
            if (i5 == 0) {
                this.s = (-f1);
            }
            if (i5 == 1) {
                this.s = f1;
            }
            if (i5 == 2) {
                this.t = (-f1);
            }
            if (i5 == 3) {
                this.t = f1;
            }
            if (i5 == 4) {
                this.u = (-f1);
            }
            if (i5 == 5) {
                this.u = f1;
            }
        }

        return false;
    }

    @Override
    protected void b(int paramInt) {
        a(null, paramInt);
    }

    @Override
    public boolean a(dx paramdx, int paramInt) {
        u();
        this.f -= paramInt;
        if (this.f <= 0) {
            l();
        }
        return false;
    }

    @Override
    public void a(v paramv) {
        // hMod: Make sure this ends up as a short!
        paramv.a("Health", (short) (byte) this.f);
        paramv.a("Age", (short) this.b);
        paramv.a("Item", this.a.a(new v()));
    }

    @Override
    public void b(v paramv) {
        this.f = (paramv.c("Health") & 0xFF);
        this.b = paramv.c("Age");
        v localv = paramv.j("Item");
        this.a = new hl(localv);
    }

    @Override
    public void b(fx paramfx) {
        if (this.l.z) {
            return;
        }

        int i = this.a.a;
        if ((this.c == 0) && (paramfx.al.a(this.a))) {
            // hMod: allow item pickups

            Item item = new Item(a.c, a.a);
            item.setDamage(f);
            if (!(Boolean) etc.getLoader().callHook(PluginLoader.Hook.ITEM_PICK_UP, new Object[]{paramfx, item})) {
                this.l.a(this, "random.pop", 0.2F, ((this.W.nextFloat() - this.W.nextFloat()) * 0.7F + 1.0F) * 2.0F);
                paramfx.c(this, i);
                l();
            }
        }
    }
}
