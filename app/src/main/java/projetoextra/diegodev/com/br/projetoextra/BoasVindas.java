package projetoextra.diegodev.com.br.projetoextra;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BoasVindas extends AppCompatActivity {
    //Atributos
    private EditText edtNomeMsg;
    private EditText edtEmailMsg;
    private EditText edtObsMsg;
    private Button btn_enviar_msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boas_vindas);

        edtNomeMsg = (EditText) findViewById(R.id.edtNomeMsg);
        edtEmailMsg = (EditText) findViewById(R.id.edtEmailMsg);
        edtObsMsg = (EditText) findViewById(R.id.edtObsMsg);
        btn_enviar_msg = (Button) findViewById(R.id.btn_enviar_msg);

        //Recebendo o Parametro da Activity
        Intent intent = getIntent();
        String nome = intent.getStringExtra("nome");

        //Alterando o Nome da VIew
        TextView txtNome = (TextView) findViewById(R.id.text_nome);
        txtNome.setText(nome + " Bem Vindo!!!");

        btn_enviar_msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome  = edtNomeMsg.getText().toString();
                String email = edtEmailMsg.getText().toString();
                String obs = edtObsMsg.getText().toString();

                Toast.makeText(BoasVindas.this, "Mensagem Salva Com Sucesso!!!", Toast.LENGTH_SHORT).show();
                //TODO mostrar AlertDialog
                AlertDialog.Builder alert = new AlertDialog.Builder(BoasVindas.this);
                alert.setMessage("Nome: " + nome + "\nEmail: " + email + " \nObs: " + obs);
                alert.setNeutralButton("Fechar", null);
                alert.show();
                //finish();
            }
        });

        //Up Navigation
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_boas_vindas, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case android.R.id.home:
                finish();//Finalizar uma Activity
            break;

            case R.id.config:
                Toast.makeText(this, "Configurações", Toast.LENGTH_SHORT).show();
             break;

            case R.id.sobre:
                Toast.makeText(this, "Sobre", Toast.LENGTH_SHORT).show();
             break;
        }
        return super.onOptionsItemSelected(item);
    }
}
