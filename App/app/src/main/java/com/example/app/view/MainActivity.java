package com.example.app.view;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.example.app.R;
import com.example.app.controller.PessoaController;
import com.example.app.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    Context context = this;
    Button btnSalvar, btnLimpar, btnFinalizar;
    EditText etNome, etSobrenome, etCurso, etTelefone;
    PessoaController pessoaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        pessoaController = new PessoaController(this);

        btnSalvar = findViewById(R.id.btn_salvar);
        btnLimpar = findViewById(R.id.btn_limpar);
        btnFinalizar = findViewById(R.id.btn_finalizar);

        etNome = findViewById(R.id.etNome);
        etSobrenome = findViewById(R.id.etSobrenome);
        etCurso = findViewById(R.id.etCurso);
        etTelefone = findViewById(R.id.etTelefone);

        btnSalvar.setOnClickListener(v -> {
            Pessoa pessoa = new Pessoa(
                    etNome.getText().toString(),
                    etSobrenome.getText().toString(),
                    etCurso.getText().toString(),
                    etTelefone.getText().toString()
            );

            pessoaController.salvarPessoa(pessoa);

            Toast.makeText(this,pessoa.toString(),Toast.LENGTH_SHORT).show();

        });

        btnLimpar.setOnClickListener( v -> {
                etNome.setText("");
                etCurso.setText("");
                etSobrenome.setText("");
                etTelefone.setText("");
                pessoaController.deletarPessoa();

            Toast.makeText(this, "Pessoa deletada!",Toast.LENGTH_SHORT).show();
        });

        btnFinalizar.setOnClickListener(v -> {
            Toast.makeText(this, "App finalizado!",Toast.LENGTH_SHORT).show();
                finish();
        });
        carregarPessoaSalva();

    }

    public void carregarPessoaSalva () {
        Pessoa pessoa = pessoaController.carregarPessoa();

        etNome.setText(pessoa.getNome());
        etSobrenome.setText(pessoa.getSobrenome());
        etCurso.setText(pessoa.getSobrenome());
        etTelefone.setText(pessoa.getTelefone());
    }

}






































































































































































































































































































