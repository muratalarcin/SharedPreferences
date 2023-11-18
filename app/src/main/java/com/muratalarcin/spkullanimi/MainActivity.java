package com.muratalarcin.spkullanimi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.muratalarcin.spkullanimi.databinding.ActivityMainBinding;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SharedPreferences sp = getSharedPreferences("Bilgiler", MODE_PRIVATE);

        //Veri Kaydı
        SharedPreferences.Editor editor = sp.edit();

        //Nesneleri json foratında kayıt edebilirsin
        //GSON kütüphaneler kullanılır
        editor.putString("ad", "Ahmet");
        editor.putInt("yas", 23);
        editor.putFloat("boy", 1.78f);
        editor.putBoolean("bekar", true);

        Set<String> liste = new HashSet<String>();
        liste.add("Ali");
        liste.add("Ece");


        editor.putStringSet("liste", liste);

        editor.apply();

        //Veri Silme
//        editor.remove("ad");
//        editor.apply();

        //Veri Okuma
        String gelenAd = sp.getString("ad", "isim yok");
        int gelenYas = sp.getInt("yas", 0);
        float gelenBoy = sp.getFloat("Boy", 0.0f);
        boolean gelenBekar = sp.getBoolean("Bekar", false);
        Log.e("Gelen Ad", gelenAd);
        Log.e("Gelen Yas", String.valueOf(gelenYas));
        Log.e("Gelen Boy", String.valueOf(gelenBoy));
        Log.e("Gelen Bekar", String.valueOf(gelenBekar));

        Set<String> gelenListe = sp.getStringSet("liste", null);
        for(String a : gelenListe) {
            Log.e("Gelen Liste", a);
        }

        //Sayaç uygulaması
        int sayac = sp.getInt("sayac", 0);

        sayac = sayac + 1 ;

        editor.putInt("sayac", sayac);
        editor.apply();

        binding.textViewSayac.setText("Açılış Sayısı: " + sayac);


    }
}