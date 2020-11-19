package com.study.myapplication;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import org.w3c.dom.NameList;

import java.util.ArrayList;
import java.util.List;

public class MyContactRecyclerViewAdapter extends RecyclerView.Adapter<MyContactRecyclerViewAdapter.ViewHolder> {
    private Context context;
    private LayoutInflater layoutInflater;
    private ArrayList<Contacts> contacts;

    public MyContactRecyclerViewAdapter(Context context, LayoutInflater layoutInflater, ArrayList<Contacts> contacts) {
        this.layoutInflater = layoutInflater.from(context);
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public MyContactRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.custom_contact_list,parent,false);

        return new ViewHolder(view,this);
    }

    @Override
    public void onBindViewHolder(@NonNull MyContactRecyclerViewAdapter.ViewHolder holder, int position) {
        Contacts mCurrent = contacts.get(position);
        holder.contactAdapter.contacts.add(mCurrent);
    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView txtname;
        public TextView txtPhoneNum;
        MyContactRecyclerViewAdapter contactAdapter;
        public ViewHolder(@NonNull View itemView, MyContactRecyclerViewAdapter adapter) {
            super(itemView);
            txtname = itemView.findViewById(R.id.txtName);
            txtPhoneNum = itemView.findViewById(R.id.txtPhoneNum);
            this.contactAdapter = adapter;

        }
    }
}