package com.example.android.SEUNotify;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.telecom.Call;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {

    private static final String TAG = "MessageAdapter";

    private ArrayList<Messages> messages = new ArrayList<>();
    private Context context;

    public MessageAdapter(ArrayList<Messages> messages, Context context) {
        this.messages = messages;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        try {
            holder.timestamp.setText(messages.get(position).getDatePublish());
            holder.title.setText(messages.get(position).getTitle());
            holder.parentLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                        Intent i = new Intent(context.getApplicationContext(), MessageDetail.class);
                        i.putExtra("messages", new Gson().toJson(messages.get(holder.getAdapterPosition())));
                        //you have also forgot to start the new activity :-)
                        context.startActivity(i);
                        Log.d(TAG, "Adaptersize " + messages.size());
                        messages.clear();
                }
            });


        } catch (NullPointerException e) {
            Log.e(TAG, "onBindViewHolder: Null Pointer: " + e.getMessage());
        }
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView timestamp, title;
        LinearLayout parentLayout;


        public ViewHolder(View itemView) {
            super(itemView);
            timestamp = itemView.findViewById(R.id.dateTextView);
            title = itemView.findViewById(R.id.messageTextView);
            parentLayout = itemView.findViewById(R.id.list_root);
        }

    }


}

