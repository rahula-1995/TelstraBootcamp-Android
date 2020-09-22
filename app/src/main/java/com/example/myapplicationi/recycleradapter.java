package com.example.myapplicationi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class recycleradapter extends RecyclerView.Adapter<recycleradapter.countryholder> {
    String[] mCountries;
    String[] mstate;
    private LayoutInflater mInflater;
    public recycleradapter(String[] countries, String[] state, Context context){
        mCountries = countries;
        mstate = state;
        mInflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public countryholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.recycle_row, parent, false);//12

        return new countryholder(mItemView);

    }

    @Override
    public void onBindViewHolder(@NonNull countryholder holder, int position) {
        holder.countryText.setText(mCountries[position]);
        //holder.countrypic.setImageIcon();
        holder.countryname.setText(mstate[position]);

    }



    @Override
    public int getItemCount() {
        return mCountries.length;
    }

    public class countryholder extends RecyclerView.ViewHolder{
        public TextView countryText;
        public ImageView countrypic;
        public TextView countryname;
        
        public countryholder(@NonNull View itemView) {
            super(itemView);
            countryText =  itemView.findViewById(R.id.textViewcountry);
            countrypic = itemView.findViewById(R.id.imageView);
            countryname=itemView.findViewById(R.id.textViewstate);
        }
    }
}
