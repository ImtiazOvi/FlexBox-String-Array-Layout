package com.example.flexbox_textarray_layout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {



    private ArrayList<Model> arrayList;
    public RecyclerViewAdapter(ArrayList<Model> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);

        final TextView textItem = (TextView)itemView.findViewById(R.id.txt_item);
        textItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "You click text : " + textItem.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        MyViewHolder ret = new MyViewHolder(itemView);
        return ret;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        Model model = arrayList.get(position);

        holder.getTextItem().setText(model.getText());
    }

    @Override
    public int getItemCount() {
        int retrn = 0;
        if(this.arrayList!=null)
        {
            retrn = arrayList.size();
        }
        return retrn;
    }

     class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView textItem;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            if(itemView!=null) {
                textItem = itemView.findViewById(R.id.txt_item);
            }
        }

        public TextView getTextItem() {
            return textItem;
        }
        }

}
