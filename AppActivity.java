package com.kubernet.followers;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.webkit.CookieManager;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.messaging.FirebaseMessaging;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import p000a.p005b.p006c.C0030h;
import p000a.p053l.p054b.C0499a;
import p076b.p109c.p110a.p125b.p151i.C2361h;
import p076b.p109c.p110a.p125b.p151i.C2362i;
import p076b.p109c.p184b.C2633c;
import p076b.p109c.p184b.p212r.p213w.C2970a;
import p076b.p109c.p184b.p221v.C3062s;
import p076b.p109c.p184b.p221v.C3064t;
import p076b.p231d.p232a.C3244a;
import p076b.p231d.p232a.C3249b;
import p076b.p231d.p232a.C3250c;
import p076b.p231d.p232a.C3251d;
import p076b.p231d.p232a.C3278n;
import p076b.p231d.p232a.C3279o;
import p076b.p231d.p232a.C3280p;
import p076b.p231d.p232a.p233a0.C3245a;
import p076b.p231d.p232a.p233a0.C3247c;
import p076b.p231d.p232a.p234k.C3261d;
import p076b.p231d.p232a.p234k.C3262e;
import p076b.p231d.p232a.p234k.C3263f;
import p076b.p231d.p232a.p234k.C3264g;
import p076b.p231d.p232a.p234k.C3265h;
import p076b.p231d.p232a.p237s.C3307s;
import p076b.p231d.p232a.p238t.C3330g0;
import p076b.p231d.p232a.p238t.C3346w;
import p076b.p231d.p232a.p239u.C3356d;
import p076b.p231d.p232a.p239u.C3361h;
import p251e.C3648w;
import p280h.C3769c0;
import p280h.p281h0.p282a.C3786a;

public class AppActivity extends C0030h {

    /* renamed from: t */
    public static final /* synthetic */ int f9617t = 0;

    /* renamed from: o */
    public BottomNavigationView f9618o;

    /* renamed from: p */
    public C3247c f9619p;

    /* renamed from: q */
    public C3245a f9620q;

    /* renamed from: r */
    public C3361h f9621r;

    /* renamed from: s */
    public boolean f9622s = false;

    public void onBackPressed() {
        if (mo2232m().mo2014J() != 1) {
            this.f2740g.mo2830a();
        } else if (!this.f9622s || mo2232m().mo2014J() != 1) {
            this.f9622s = true;
            Toast.makeText(this, getString(R.string.double_logout), 0).show();
            new Handler().postDelayed(new C3244a(this), 15000);
        } else {
            finish();
        }
    }

    public void onCreate(Bundle bundle) {
        C2361h hVar;
        Class cls = C3263f.class;
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_app);
        this.f9619p = new C3247c(this);
        this.f9620q = new C3245a(this);
        SharedPreferences sharedPreferences = getSharedPreferences("com.kubernet.followers", 100);
        String f = this.f9619p.mo7602f();
        Locale locale = new Locale(f);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        getBaseContext().getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());
        sharedPreferences.edit().putString("language", f).apply();
        CookieManager.getInstance().removeAllCookies(C3250c.f8854a);
        C2633c.m6760e(this);
        FirebaseMessaging c = FirebaseMessaging.m8220c();
        C2970a aVar = c.f9601b;
        if (aVar != null) {
            hVar = aVar.mo7250c();
        } else {
            C2362i iVar = new C2362i();
            c.f9607h.execute(new C3062s(c, iVar));
            hVar = iVar.f6742a;
        }
        hVar.mo6257b(new C3249b(this));
        FirebaseMessaging.m8220c().f9608i.mo6270o(new C3064t("all"));
        if (this.f9620q.mo7594b() == null) {
            this.f9620q.mo7593a();
            this.f9619p.mo7597a();
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.customBottomBar);
        this.f9618o = bottomNavigationView;
        bottomNavigationView.mo7855a(R.menu.bottom_menu);
        this.f9618o.setOnNavigationItemSelectedListener(new C3251d(this));
        new C3356d(this);
        try {
            ((C3265h) new C3264g(this).mo7636a().mo10166b(C3265h.class)).getMe().mo10155C(new C3278n(this));
        } catch (Exception unused) {
        }
        mo8599x();
        ((C3263f) new C3262e(this).mo7623a().mo10166b(cls)).mo7628e().mo10155C(new C3279o(this));
        mo8597v();
        if (this.f9619p.f8851a.getBoolean("user_show_feedback_dialog", false)) {
            new C3307s(this).mo7683a();
        }
        SharedPreferences sharedPreferences2 = getSharedPreferences("com.kubernet.followers", 100);
        getSharedPreferences("com.kubernet.followers", 100);
        String string = sharedPreferences2.getString("ig_cookie", (String) null) == null ? "" : sharedPreferences2.getString("ig_cookie", (String) null);
        if (sharedPreferences2.getString("ig_token", (String) null) != null) {
            sharedPreferences2.getString("ig_token", (String) null);
        }
        String format = String.format("Instagram %s Android(%s/%s; %sdpi; %sx%s %s; %s; %s; %s)", new Object[]{"177.0.0.30.119", Integer.valueOf(Build.VERSION.SDK_INT), Build.VERSION.RELEASE, Integer.valueOf(getResources().getDisplayMetrics().densityDpi), "1080", "2131", Build.HARDWARE, Build.PRODUCT, Locale.getDefault().toString(), 276028020});
        C3648w.C3650b bVar = new C3648w.C3650b();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        bVar.mo9829c(60, timeUnit);
        bVar.mo9828b(60, timeUnit);
        bVar.f10350u = false;
        bVar.mo9827a(new C3261d(format, string));
        C3769c0.C3771b bVar2 = new C3769c0.C3771b();
        bVar2.mo10172a("https://i.instagram.com/api/v1/");
        bVar2.mo10174c(new C3648w(bVar));
        bVar2.f10633d.add(C3786a.m9106c());
        ((C3263f) bVar2.mo10173b().mo10166b(cls)).mo7631h(this.f9619p.mo7605i()).mo10155C(new C3280p(this));
        this.f9621r = new C3361h(this, "FRONT");
    }

    public void onDestroy() {
        super.onDestroy();
        C3361h hVar = this.f9621r;
        Objects.requireNonNull(hVar);
        try {
            hVar.f9128a.disconnect();
        } catch (Exception unused) {
        }
    }

    /* renamed from: v */
    public void mo8597v() {
        this.f9618o.getMenu().getItem(0).setChecked(true);
        C0499a aVar = new C0499a(mo2232m());
        aVar.mo2134c("HomeFragment");
        aVar.mo2135f(R.id.appFrame, new C3346w());
        aVar.mo1964d();
    }

    /* renamed from: w */
    public void mo8598w() {
        this.f9618o.getMenu().getItem(2).setChecked(true);
        C0499a aVar = new C0499a(mo2232m());
        aVar.mo2134c("SettingsFragment");
        aVar.mo2135f(R.id.appFrame, new C3330g0());
        aVar.mo1964d();
    }

    /* renamed from: x */
    public void mo8599x() {
        ((TextView) findViewById(R.id.genericCredit)).setText(String.valueOf(this.f9619p.mo7601e()));
    }
}
