package com.example.app.controller;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.app.model.Curso;
import com.example.app.model.Pessoa;

public class CursoController {

    @NonNull
    @Override
    public String toString() {

        Log.d("MVC controller", "Curso iniciada ");
        return super.toString();
    }

    public void salvar(Curso curso){
        Log.d("MVC controller","Curso salvo: " + curso.toString());
    }


}
