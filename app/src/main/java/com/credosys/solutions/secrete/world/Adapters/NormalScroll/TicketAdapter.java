package com.credosys.solutions.secrete.world.Adapters.NormalScroll;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.credosys.solutions.secrete.world.Pojos.App.Ticket;
import com.credosys.solutions.secrete.world.R;

import java.util.List;

/**
 * Created by Yogesh on 15-Feb-18.
 */

public class TicketAdapter extends RecyclerView.Adapter<TicketAdapter.TicketHolder> {
    List<Ticket> list;
    public TicketAdapter(List<Ticket> list) {
        this.list=list;
    }

    @Override
    public TicketHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_museum_concert_ticket,parent,false);
        return new TicketHolder(v);
    }

    @Override
    public void onBindViewHolder(TicketHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    class TicketHolder extends RecyclerView.ViewHolder{

        public TicketHolder(View itemView) {
            super(itemView);
        }
    }
}
