package br.com.v2.appclientevip.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import br.com.v2.appclientevip.R;
import br.com.v2.appclientevip.api.AppUtil;

public class MainActivity extends AppCompatActivity {

    TextView textViewTitulo, textViewDataAtual, textViewHoraAtual;
    Button btnCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewTitulo = findViewById(R.id.txtv_titulo);
        textViewDataAtual = findViewById(R.id.txtv_DataAtual);
        textViewHoraAtual = findViewById(R.id.txtv_HoraAtual);
        btnCadastro = findViewById(R.id.btnCadastrar);

        textViewTitulo.setText("Curso Android");
        textViewTitulo.setTextColor(getResources().getColor(R.color.colorAccent));

        textViewDataAtual.setText(AppUtil.getDataAtual());
        textViewHoraAtual.setText(AppUtil.getHoraAtual());

        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iTelaCadastro = new Intent(MainActivity.this, CadastroUsuarioActivity.class);
                startActivity(iTelaCadastro);
            }
        });
    }
}