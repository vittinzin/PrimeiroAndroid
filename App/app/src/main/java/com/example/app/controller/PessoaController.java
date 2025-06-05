package com.example.app.controller;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import com.example.app.model.Pessoa;

public class PessoaController {

    private static final String prefs = "dados_usuario";
    SharedPreferences sharedPreferences;

    public PessoaController (Context context){
        sharedPreferences = context.getSharedPreferences(prefs, Context.MODE_PRIVATE);
    }

    public void salvarPessoa (Pessoa pessoa){
        SharedPreferences.Editor listaVip = sharedPreferences.edit();
        listaVip.putString("NOME: ",pessoa.getNome());
        listaVip.putString("SOBRENOME: ", pessoa.getSobrenome());
        listaVip.putString("CURSO: ", pessoa.getCurso());
        listaVip.putString("TELEFONE: ", pessoa.getTelefone());
        listaVip.apply();
    }

    public Pessoa carregarPessoa (){
        String nome = sharedPreferences.getString("NOME: ","");
        String sobrenome = sharedPreferences.getString("SOBRENOME: ", "");
        String curso = sharedPreferences.getString("CURSO: ","");
        String telefone = sharedPreferences.getString("TELEFONE: ", "");

        return new Pessoa(nome, sobrenome, curso, telefone);
    }

    public void deletarPessoa (){
        sharedPreferences.edit().clear().apply();
    }
}
