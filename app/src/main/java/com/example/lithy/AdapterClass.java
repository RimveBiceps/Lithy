package com.example.lithy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.MyViewHolder>{

    private ArrayList<Place> list;
    private OnNoteListener mOnNoteListener;

    AdapterClass(ArrayList<Place> list, OnNoteListener onNoteListener)
    {
        this.list = list;
        this.mOnNoteListener = onNoteListener;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_holder, parent, false);

        return new MyViewHolder(view, mOnNoteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Place listas = list.get(position);

        holder.place_name.setText(list.get(position).getName());
        holder.place_location.setText(list.get(position).getPlace());
/*
        Transformation transformation = new RoundedTransformationBuilder()
                .borderColor(Color.BLACK)
                .borderWidthDp(3)
                .cornerRadiusDp(30)
                .oval(false)
                .build();
*/
        Picasso.get()
                .load(listas.getImg())
                .into(holder.place_img);

    }

    @Override
    public int getItemCount() {
        //return 5;
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView place_name, place_location;
        CircleImageView place_img;

        OnNoteListener onNoteListener;

        MyViewHolder(@NonNull View itemView, OnNoteListener onNoteListener) {
            super(itemView);
            place_name = itemView.findViewById(R.id.name);
            place_location = itemView.findViewById(R.id.place);
            place_img = itemView.findViewById(R.id.foto);

            this.onNoteListener = onNoteListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onNoteListener.OnNoteClick(getAdapterPosition());

        }
    }
    public interface OnNoteListener {
        void OnNoteClick(int position);
    }
}
