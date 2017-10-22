package projetoextra.diegodev.com.br.projetoextra;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Atributos
    private EditText edtUsuario;
    private EditText edtSenha;
    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUsuario = (EditText) findViewById(R.id.edtUsuario);
        edtSenha = (EditText) findViewById(R.id.edtSenha);
        btn_login = (Button) findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario = edtUsuario.getText().toString();
                String senha = edtSenha.getText().toString();

                if(usuario.equals("Diego") && senha.equals("123")){

                    Toast.makeText(getContext(), "Login Realizado com Sucesso!!", Toast.LENGTH_SHORT).show();

                    //Passando para Uma Intent
                    Intent pag2 = new Intent(getContext(), BoasVindas.class);
                    pag2.putExtra("nome", usuario);
                    startActivity(pag2);
                }else{
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                    alertDialog.setMessage("Login ou Senha Incorretos!!!");
                    alertDialog.setNeutralButton("Voltar", null);
                    alertDialog.show();
                }
            }
        });

        //Up Navigation
    }

    private Context getContext(){
            return this;
    }
}
