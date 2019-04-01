package com.example.heyverson.estagiando;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class AnotacaoActivity extends AppCompatActivity {

    String usuario;
    List<Anotacao> listAnotacao = new ArrayList<Anotacao>();
    ArrayAdapter<Anotacao> anotacaoArrayAdapter;
    ListView listViewAnotacao;
    Anotacao anotacaoSelecionado;
    private AlertDialog alerta;
    EditText mData, mSetor, mComentario;
    TextView mId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anotacao);


        //
        // mData = findViewById(R.id.edtData);
        mSetor = findViewById(R.id.edtSetor);
        mComentario = findViewById(R.id.edtComentario);
        mId = findViewById(R.id.tvId);
        Button salvarRelatorio = findViewById(R.id.btnSalvarRelatorio);
        listViewAnotacao = findViewById(R.id.listRelatorios);
        listViewAnotacao.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                anotacaoSelecionado = (Anotacao) parent.getItemAtPosition(position);
                alert_simples();
            }
        });
        usuario = FirebaseAuth.getInstance().getCurrentUser().getUid();

        salvarRelatorio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Anotacao anotacao = new Anotacao();
                anotacao.setData(mData.getText().toString());
                anotacao.setSetor(mSetor.getText().toString());
                anotacao.setComentario(mComentario.getText().toString());
                anotacao.setCheio(true);
                if (mId.length() == 0) {
                  //  ref.child("relatorios").child(usuario).push().setValue(anotacao);
                } else {
                    //ref.child("relatorios").child(usuario).child(mId.getText().toString()).setValue(anotacao);
                }
                mData.setText("");
                mSetor.setText("");
                mComentario.setText("");
                mensagem("Salvo com sucesso");

            }
        });

        eventoDatabase();
    }
    private void eventoDatabase() {
        mensagem("Carregando lista");
       /*
        ref.child("relatorios").child(usuario).orderByValue().limitToLast(12).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listRelatorio.clear();
                for (DataSnapshot objSnapshot : dataSnapshot.getChildren()) {
                    Relatorio relatorioBackup = objSnapshot.getValue(Relatorio.class);
                    relatorioBackup.setChave(objSnapshot.getKey());
                    listRelatorio.add(relatorioBackup);
                }
                relatorioArrayAdapter = new ArrayAdapter<Relatorio>(RelatoriosActivity.this, android.R.layout.simple_list_item_1, listRelatorio);
                listViewRelatorio.setAdapter(relatorioArrayAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        */
    }




    private void alert_simples() {
        //Cria o gerador do AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //define o titulo
        builder.setTitle(anotacaoSelecionado.getData() + " - " + anotacaoSelecionado.getSetor());
        //define a mensagem
        builder.setMessage(anotacaoSelecionado.getComentario());
        //define um botão como positivo
        builder.setPositiveButton("Fechar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                alerta.dismiss();
            }
        });
        builder.setNeutralButton("Excluir", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               // ref.child("relatorios").child(usuario).child(relatorioSelecionado.getChave()).removeValue();
                mensagem("Excluido com Sucesso");
            }
        });
        builder.setNegativeButton("Editar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mData.setText(anotacaoSelecionado.getData());
                mSetor.setText(anotacaoSelecionado.getSetor());
                mComentario.setText(anotacaoSelecionado.getComentario());
                mId.setText(anotacaoSelecionado.getChave());
            }
        });
        //define um botão como negativo.

        //cria o AlertDialog
        alerta = builder.create();
        //Exibe
        alerta.show();
    }

    private void mensagem(String msg) {
        Toast.makeText(AnotacaoActivity.this, msg, Toast.LENGTH_LONG).show();
    }
}
