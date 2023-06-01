package com.example.recifealimentado;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;




public class DetalhesUsuarioActivity extends AppCompatActivity {
    private TextView nameTextView;
    private TextView emailTextView;
    private TextView collaborationTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_usuario);

        nameTextView = findViewById(R.id.nameTextView);
        emailTextView = findViewById(R.id.emailTextView);
        collaborationTextView = findViewById(R.id.collaborationTextView);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String email = intent.getStringExtra("email");
        String collaboration = intent.getStringExtra("collaboration");


        String nameText = "<b>Name:</b> " + name;
        String emailText = "<b>Email:</b> " + email;
        String collaborationText = "<b>Arrecadação:</b> " + collaboration;

        nameTextView.setText(Html.fromHtml(nameText));
        emailTextView.setText(Html.fromHtml(emailText));
        collaborationTextView.setText(Html.fromHtml(collaborationText));

        Button inicioButton = findViewById(R.id.inicioButton);
        inicioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetalhesUsuarioActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        }
    }