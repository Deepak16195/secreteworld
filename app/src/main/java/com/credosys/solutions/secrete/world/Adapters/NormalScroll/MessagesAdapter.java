package com.credosys.solutions.secrete.world.Adapters.NormalScroll;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.credosys.solutions.secrete.world.Pojos.App.Messages;
import com.credosys.solutions.secrete.world.R;

import java.util.List;

/**
 * Created by win7 on 12-Jan-18.
 */

public class MessagesAdapter extends BaseAdapter {
    Context context;
    List<Messages> list;
    LayoutInflater inflater;

    public MessagesAdapter(Context context, List<Messages> list) {
        this.context = context;
        this.list = list;
        this.inflater = ( LayoutInflater )context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MessageHolder holder=new MessageHolder();
        View v = holder.getHolder();
        holder.name.setText(list.get(position).getName());
        holder.content.setText(list.get(position).getContent());
        holder.image.setBackgroundResource(list.get(position).getImg());
        return v;
    }

    class MessageHolder {
        TextView name;
        TextView content;
ImageView image;
        View getHolder() {
           View view=inflater.inflate(R.layout.single_message_row,null,false);
            name = view.findViewById(R.id.txt_message_user_name);
            image = view.findViewById(R.id.img_message_user);
            content = view.findViewById(R.id.txt_message_content);
            return view;
        }
    }
}
