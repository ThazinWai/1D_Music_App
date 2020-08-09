package com.example.learnjp;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {

    public ImageView image;
    public TextView txtName;
    public TextView txtDesc;
    public LinearLayout linearLayout;


    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        image=(ImageView)itemView.findViewById(R.id.imageview_id);
        txtName=(TextView)itemView.findViewById(R.id.txtName);
        txtDesc=(TextView)itemView.findViewById(R.id.txtDesc);
        linearLayout=(LinearLayout)itemView.findViewById(R.id.linearlayout_id);

    }
}
