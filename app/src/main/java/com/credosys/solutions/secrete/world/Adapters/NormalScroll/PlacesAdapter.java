package com.credosys.solutions.secrete.world.Adapters.NormalScroll;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.credosys.solutions.secrete.world.Pojos.App.HomeContentsPlaces;
import com.credosys.solutions.secrete.world.R;

import java.util.List;

/**
 * Created by credosys on 22/2/18.
 */

public class PlacesAdapter extends RecyclerView.Adapter<PlacesAdapter.PlaceHolder> {
List<HomeContentsPlaces> list;

    public PlacesAdapter(List<HomeContentsPlaces> list) {
        this.list = list;
    }

    @Override
    public PlaceHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_places,parent,false);
        return new PlaceHolder(v);
    }

    @Override
    public void onBindViewHolder(PlaceHolder holder, int position) {
       HomeContentsPlaces obj= list.get(position);
    holder.txtTitleCard.setText(obj.getTitle());
    holder.txtAddress.setText(obj.getAddress());
    holder.txtPriceTag.setText(obj.getPrice());
    holder.ratingBar.setRating(obj.getRating());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class PlaceHolder extends RecyclerView.ViewHolder{
        TextView txtTitleCard,txtAddress,txtPhone,txtPriceTag;
        RatingBar ratingBar;
        public PlaceHolder(View itemView) {
            super(itemView);
            txtTitleCard=itemView.findViewById(R.id.txt_title_card);
            txtAddress=itemView.findViewById(R.id.txt_address);
            txtPhone=itemView.findViewById(R.id.txt_phone);
            txtPriceTag=itemView.findViewById(R.id.txt_price_tag);
            ratingBar=itemView.findViewById(R.id.ratingBar1);

        }
    }
}
