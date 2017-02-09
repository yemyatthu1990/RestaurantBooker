package com.yemyatthu.restaurantbooker.presentation.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.yemyatthu.restaurantbooker.R;
import com.yemyatthu.restaurantbooker.presentation.model.TownshipModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ye Myat Thu on 2/8/2017.
 */


public class TownshipAdapter extends RecyclerView.Adapter<TownshipAdapter.TownshipViewHolder> {
    List<TownshipModel> townshipModels;
    @Override
    public TownshipAdapter.TownshipViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_township_item, parent, false);
        return new TownshipViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TownshipAdapter.TownshipViewHolder holder, int position) {
        holder.bind(townshipModels.get(position));
    }
    @Override
    public int getItemCount() {
        return townshipModels!=null?townshipModels.size():0;
    }

    public void setTownships(List<TownshipModel> townships){
        if(townships == null){
            throw  new IllegalArgumentException("List can't be null");
        }
        townshipModels = townships;
        notifyDataSetChanged();
    }

    class TownshipViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.township_image)
        ImageView townshipImage;
        @BindView(R.id.township_name)
        TextView townshipName;

        TownshipViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        void bind(TownshipModel township){
            Picasso.with(townshipImage.getContext())
                    .load(township.getImageUrl())
                    .into(townshipImage);
            townshipName.setText(township.getName());
        }
    }

}
