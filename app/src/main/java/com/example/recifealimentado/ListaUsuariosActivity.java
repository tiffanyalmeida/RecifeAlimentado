package com.example.recifealimentado;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class ListaUsuariosActivity extends AppCompatActivity {
    private List<Usuario> usuarios;
    private RecyclerView recyclerView;
    private UsuariosAdapter usuariosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_usuarios);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        usuarios = new ArrayList<>();
        usuariosAdapter = new UsuariosAdapter(usuarios);
        recyclerView.setAdapter(usuariosAdapter);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                usuarios.clear(); // Limpa a lista de usuários existente
                for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                    String name = userSnapshot.child("name").getValue(String.class);
                    String email = userSnapshot.child("email").getValue(String.class);
                    String collaboration = userSnapshot.child("collaboration").getValue(String.class);

                    if (name != null && email != null) {
                        Usuario usuario = new Usuario(name, email, collaboration);
                        usuarios.add(usuario);
                    }
                }
                usuariosAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        usuariosAdapter.setOnUsuarioClickListener(new UsuariosAdapter.OnUsuarioClickListener() {
            @Override
            public void onUsuarioClick(Usuario usuario) {
                Intent intent = new Intent(ListaUsuariosActivity.this, DetalhesUsuarioActivity.class);
                intent.putExtra("name", usuario.getName());
                intent.putExtra("email", usuario.getEmail());
                intent.putExtra("collaboration", usuario.getCollaboration());
                startActivity(intent);
            }
        });
    }
}