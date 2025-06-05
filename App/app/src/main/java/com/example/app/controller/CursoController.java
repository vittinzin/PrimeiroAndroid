package com.example.app.controller;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.aware.PublishConfig;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.app.model.Curso;
import com.example.app.model.Pessoa;

public class CursoController {

    private static final String prefs = "dados_usuario";
    private SharedPreferences sharedPreferences;


    public CursoController (Context context){
        sharedPreferences = context.getSharedPreferences(prefs, Context.MODE_PRIVATE);
    }

    public void salvarCurso (Curso curso){
        SharedPreferences.Editor listaVip = sharedPreferences.edit();
        listaVip.putString("CURSO: ", curso.getCursoDesejado());
        listaVip.apply();
    }

    public Curso carregarCurso () {
        String curso = sharedPreferences.getString("CURSO: ", "");
        return new Curso(curso);
    }

}
