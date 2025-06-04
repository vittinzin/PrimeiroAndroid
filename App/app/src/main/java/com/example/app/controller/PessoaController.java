package com.example.app.controller;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;

import com.example.app.R;
import com.example.app.model.Pessoa;

public class PessoaController {

    @NonNull
    @Override
    public String toString() {

        Log.d("MVC controller", "PessoaController iniciada");
        return super.toString();
    }

    public void  salvar(Pessoa pessoa){
        Log.d("MVC controller","Pessoa salva: " + pessoa.toString());
    }
}
