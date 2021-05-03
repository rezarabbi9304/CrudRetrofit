package com.example.postapi;

import android.content.Context;
import android.media.session.PlaybackState;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserModelAdapter extends RecyclerView.Adapter<UserModelAdapter.MyView> {


    private Context mContext;
    List<UserModel> userModels;

    public UserModelAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setUserModels(List<UserModel> userModels) {
        this.userModels = userModels;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.get_api_layout,null);
        MyView holder = new MyView(view);


        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyView holder, int position) {
        holder.firstName.setText("" +userModels.get(position).getFirst_name());
        holder.LastName.setText("" +userModels.get(position).getLast_name());
        holder.email.setText("" +userModels.get(position).getEmail());


    }

    @Override
    public int getItemCount() {
        return userModels.size();
    }

    public static class MyView extends RecyclerView.ViewHolder{
        private TextView firstName;
        private  TextView LastName;
        private TextView email;

        public MyView(@NonNull View itemView) {
            super(itemView);
            firstName = itemView.findViewById(R.id.getTextFirstName);
            LastName = itemView.findViewById(R.id.textViewLastName);
            email = itemView.findViewById(R.id.textViewEmail);

        }
    }
}
