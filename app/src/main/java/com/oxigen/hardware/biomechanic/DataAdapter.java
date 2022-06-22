package com.oxigen.hardware.biomechanic;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.myViewHolder>{

    ArrayList<DataModel> dataHolder;
    private final RecyclerViewClickListener listener;

    public DataAdapter(ArrayList<DataModel> dataHolder, RecyclerViewClickListener listener) {
        this.dataHolder = dataHolder;
        this.listener = listener;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.record_item, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.img.setImageResource(dataHolder.get(position).getImage());
        holder.header.setText(dataHolder.get(position).getHeader());
        holder.desc.setText(dataHolder.get(position).getDesc());
    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    protected class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView img;
        TextView header, desc;

        public myViewHolder(final View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.item_image);
            header = itemView.findViewById(R.id.item_header);
            desc = itemView.findViewById(R.id.item_sub_header);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onClick(view, getAdapterPosition());
        }
    }

    public interface RecyclerViewClickListener{
        void onClick(View v, int position);
    }
}
