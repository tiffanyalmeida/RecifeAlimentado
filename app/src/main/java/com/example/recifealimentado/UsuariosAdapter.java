package com.example.recifealimentado;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import java.util.List;

public class UsuariosAdapter extends RecyclerView.Adapter<UsuariosAdapter.UsuarioViewHolder> {

    private List<Usuario> usuarios;
    private OnUsuarioClickListener onUsuarioClickListener; //

    public UsuariosAdapter(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void setOnUsuarioClickListener(OnUsuarioClickListener listener) {
        this.onUsuarioClickListener = listener;
    }

    @NonNull
    @Override
    public UsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_usuario, parent, false);
        return new UsuarioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioViewHolder holder, int position) {
        Usuario usuario = usuarios.get(position);
        if (usuario != null) {
            holder.nameTextView.setText(usuario.getName());
            holder.emailTextView.setText(usuario.getEmail());
            holder.avatarImageView.setImageResource(R.drawable.perfilicone);

        } else {

            holder.nameTextView.setText("");
            holder.emailTextView.setText("");
            holder.avatarImageView.setImageDrawable(null);
        }


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onUsuarioClickListener != null) {
                    onUsuarioClickListener.onUsuarioClick(usuario);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return usuarios.size();
    }

    public static class UsuarioViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView emailTextView;
        ImageView avatarImageView;

        public UsuarioViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            emailTextView = itemView.findViewById(R.id.emailTextView);
            avatarImageView = itemView.findViewById(R.id.avatarImageView);
        }
    }

    public interface OnUsuarioClickListener {
        void onUsuarioClick(Usuario usuario);
    }
}