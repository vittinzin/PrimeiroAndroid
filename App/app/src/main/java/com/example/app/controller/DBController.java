package com.example.app.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.example.app.DB.DB;

public class DBController {
    private SQLiteDatabase db;
    private DB banco;

    public DBController(Context context) {
        banco = new DB(context);
    }

    public String inserirDados(String nome, String sobrenome, String telefone, String curso) {
        ContentValues dados;
        long resultado;

        db = banco.getWritableDatabase();
        dados = new ContentValues();
        dados.put(DB.NOME, nome);
        dados.put(DB.SOBRENOME, sobrenome);
        dados.put(DB.TELEFONE, telefone);
        dados.put(DB.CURSO, curso);

        resultado = db.insert(DB.TABELA, null, dados);

        if (resultado == -1) {
            return "Erro ao inserir registro";
        } else {
            return "Registro inserido";
        }
    }

}


