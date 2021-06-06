package com.kubernet.followers;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.widget.Button;
import java.util.Locale;
import java.util.Objects;
import p000a.p005b.p006c.C0030h;
import p076b.p077a.p078a.p079a.C0928a;
import p076b.p231d.p232a.C3255h;
import p076b.p231d.p232a.C3256i;
import p076b.p231d.p232a.C3257j;
import p076b.p231d.p232a.p233a0.C3247c;

public class MainActivity extends C0030h {

    /* renamed from: r */
    public static Activity f9638r;

    /* renamed from: o */
    public Button f9639o;

    /* renamed from: p */
    public Button f9640p;

    /* renamed from: q */
    public C3247c f9641q;

    public void onCreate(Bundle bundle) {
        C3247c cVar = new C3247c(this);
        this.f9641q = cVar;
        String country = getResources().getConfiguration().locale.getCountry();
        if (!country.equals("")) {
            C0928a.m3097h(cVar.f8851a, "locale_country", country);
        }
        C3247c cVar2 = this.f9641q;
        Objects.requireNonNull(cVar2);
        cVar2.f8851a.edit().putString("user_web_useragent", new WebView(cVar2.f8852b).getSettings().getUserAgentString()).apply();
        mo8607v();
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_main);
        Button button = (Button) findViewById(R.id.changeLang);
        this.f9640p = button;
        button.setOnClickListener(new C3255h(this));
        C3247c cVar3 = new C3247c(this);
        String f = this.f9641q.mo7602f();
        Locale locale = new Locale(f);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        getBaseContext().getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());
        cVar3.f8851a.edit().putString("language", f).apply();
        Button button2 = (Button) findViewById(R.id.signIn);
        this.f9639o = button2;
        button2.setOnClickListener(new C3257j(this));
        f9638r = this;
    }

    public void onResume() {
        CookieManager.getInstance().removeAllCookies(C3256i.f8860a);
        mo8607v();
        super.onResume();
    }

    /* renamed from: v */
    public void mo8607v() {
        if (getSharedPreferences("com.kubernet.followers", 100).getString("ig_cookie", (String) null) != null) {
            startActivity(new Intent(this, AppActivity.class));
            finish();
        }
    }
}
