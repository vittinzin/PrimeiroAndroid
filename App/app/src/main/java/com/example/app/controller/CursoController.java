package com.example.app.controller;

import android.content.Context;
import android.content.SharedPreferences;

public class CursoController {
    private static final String prefs = "dados_usuario";
    SharedPreferences sharedPreferences;

    public CursoController(Context context) {
        sharedPreferences = context.getSharedPreferences(prefs, Context.MODE_PRIVATE);
    }

    public void salvarPosicao(int posicao) {
        SharedPreferences.Editor listaVip = sharedPreferences.edit();
        listaVip.putInt("posicao", posicao);
        listaVip.apply();
    }

    public int carregarSpiner() {
        int posicao = sharedPreferences.getInt("posicao", 0);
        return posicao;
    }

    public void deletarSpinner() {
        sharedPreferences.edit().clear().apply();
    }
}
