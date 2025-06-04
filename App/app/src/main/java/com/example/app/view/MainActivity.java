package com.example.app.view;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.app.R;
import com.example.app.controller.CursoController;
import com.example.app.controller.PessoaController;
import com.example.app.model.Curso;
import com.example.app.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    private static final String prefs = "dados_usuario";

    Pessoa pessoa;
    Curso curso;
    private Button btnSalvar, btnLimpar, btnFinalizar;
    private EditText etNome, etSobrenome, etCurso, etTelefone;
    private PessoaController pessoaController;
    private CursoController cursoController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences(prefs,0);
        SharedPreferences.Editor listaVip = sharedPreferences.edit();

        btnSalvar = findViewById(R.id.btn_salvar);
        btnLimpar = findViewById(R.id.btn_limpar);
        btnFinalizar = findViewById(R.id.btn_finalizar);

        etNome = findViewById(R.id.etNome);
        etSobrenome = findViewById(R.id.etSobrenome);
        etCurso =findViewById(R.id.etCurso);
        etTelefone = findViewById(R.id.etTelefone);

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etNome.setText("");
                etCurso.setText("");
                etSobrenome.setText("");
                etTelefone.setText("");
            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pessoa = new Pessoa(
                        String.valueOf(etNome.getText()),
                        String.valueOf(etSobrenome.getText()),
                        String.valueOf(etCurso.getText()),
                        String.valueOf(etTelefone.getText())
                );

                curso = new Curso(String.valueOf(etCurso.getText()));

                pessoaController = new PessoaController();
                cursoController = new CursoController();

                listaVip.putString("NOME: ",pessoa.getNome());
                listaVip.putString("SOBRENOME: ", pessoa.getSobrenome());
                listaVip.putString("CURSO: ", pessoa.getCurso());
                listaVip.putString("TELEFONE: ", pessoa.getTelefone());
                listaVip.apply();

                pessoaController.salvar(pessoa);
                cursoController.salvar(curso);

                etNome.setText("");
                etCurso.setText("");
                etSobrenome.setText("");
                etTelefone.setText("");
            }
        });


    }

}






































































































































































































































































































