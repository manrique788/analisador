package com.analisadorr.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends Activity {
    private final int bg = Color.rgb(4, 14, 23);
    private final int panel = Color.rgb(12, 31, 46);
    private final int green = Color.rgb(0, 230, 160);
    private TextView status;
    private boolean monitoring = false;

    @Override public void onCreate(Bundle state) {
        super.onCreate(state);
        getWindow().setStatusBarColor(bg);
        getWindow().setNavigationBarColor(bg);
        buildScreen();
    }

    private void buildScreen() {
        ScrollView scroll = new ScrollView(this);
        scroll.setBackgroundColor(bg);
        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(dp(20), dp(18), dp(20), dp(28));
        scroll.addView(root);

        TextView mark = text("◉  ANALISADOR R", 27, green, true);
        root.addView(mark);
        root.addView(text("Leitura e análise estatística da roleta", 14, Color.LTGRAY, false));
        space(root, 22);

        root.addView(section("LEITURA INICIAL"));
        root.addView(text("Leia o histórico da FBbet7 e tente reunir até 500 resultados. A tela do histórico precisa estar aberta e legível.", 15, Color.WHITE, false));
        space(root, 10);
        Button read = button("Ler os últimos 500 números");
        root.addView(read);
        read.setOnClickListener(v -> new AlertDialog.Builder(this)
            .setTitle("Próxima etapa da leitura")
            .setMessage("Esta versão é um protótipo de interface. O pedido de captura de tela, OCR e validação dos 500 números ainda precisam ser implementados e testados antes de afirmar que a leitura funciona.")
            .setPositiveButton("Entendi", (d, w) -> {}).show());

        space(root, 20);
        root.addView(section("ACOMPANHAMENTO CONTÍNUO"));
        status = text("●  Monitoramento ainda não iniciado", 15, Color.YELLOW, true);
        panel(root, status);
        space(root, 8);
        Button monitor = button("Iniciar / pausar acompanhamento");
        root.addView(monitor);
        monitor.setOnClickListener(v -> {
            monitoring = !monitoring;
            status.setText(monitoring ? "●  Pedido de início selecionado — captura ainda não conectada" : "●  Acompanhamento pausado");
            status.setTextColor(monitoring ? Color.YELLOW : Color.LTGRAY);
        });

        space(root, 20);
        root.addView(section("ESTATÍSTICAS"));
        root.addView(text("Ainda sem resultados lidos. Os cartões abaixo são exemplos de categorias, não dados reais.", 14, Color.LTGRAY, false));
        space(root, 10);
        panel(root, text("DÚZIAS\n1ª (1–12)     2ª (13–24)     3ª (25–36)\nAguardando dados reais", 15, Color.WHITE, true));
        space(root, 8);
        panel(root, text("COLUNAS\n1ª coluna     2ª coluna     3ª coluna\nAguardando dados reais", 15, Color.WHITE, true));
        space(root, 8);
        panel(root, text("CORES E PARIDADE\nVermelho · Preto · Zero · Pares · Ímpares\nAguardando dados reais", 15, Color.WHITE, true));
        space(root, 8);
        panel(root, text("NÚMEROS INDIVIDUAIS\nFrequência de 0 a 36 e percentuais\nAguardando dados reais", 15, Color.WHITE, true));
        space(root, 20);
        TextView disclaimer = text("Importante: frequências passadas descrevem apenas a amostra observada e não garantem o próximo resultado. Não use estatísticas como promessa de ganho.", 13, Color.LTGRAY, false);
        panel(root, disclaimer);
        setContentView(scroll);
    }

    private TextView text(String value, int size, int color, boolean bold) {
        TextView t = new TextView(this); t.setText(value); t.setTextSize(size); t.setTextColor(color);
        t.setGravity(Gravity.CENTER_VERTICAL); t.setPadding(0, dp(5), 0, dp(5));
        if (bold) t.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        return t;
    }
    private TextView section(String value) {
        TextView t = text(value, 12, green, true); t.setLetterSpacing(0.08f); return t;
    }
    private Button button(String label) {
        Button b = new Button(this); b.setText(label); b.setTextColor(Color.rgb(0, 25, 22)); b.setTextSize(15);
        b.setAllCaps(false); b.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        GradientDrawable gd = new GradientDrawable(); gd.setColor(green); gd.setCornerRadius(dp(14)); b.setBackground(gd);
        b.setPadding(dp(10), dp(8), dp(10), dp(8)); return b;
    }
    private void panel(LinearLayout parent, View child) {
        LinearLayout box = new LinearLayout(this); box.setOrientation(LinearLayout.VERTICAL); box.setPadding(dp(14), dp(10), dp(14), dp(10));
        GradientDrawable gd = new GradientDrawable(); gd.setColor(panel); gd.setCornerRadius(dp(14)); gd.setStroke(dp(1), Color.rgb(24, 69, 83)); box.setBackground(gd);
        box.addView(child); parent.addView(box);
    }
    private void space(LinearLayout parent, int height) { View v = new View(this); parent.addView(v, new LinearLayout.LayoutParams(1, dp(height))); }
    private int dp(int value) { return (int)(value * getResources().getDisplayMetrics().density + 0.5f); }
}
