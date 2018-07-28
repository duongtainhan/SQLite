package com.example.duongtainhan555.sqlite;


import android.content.Context;
import android.database.DataSetObserver;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class NhaHangAdapter extends RecyclerView.Adapter<NhaHangAdapter.ViewHolder>{
    Context context;
    ArrayList<NhaHang> arrayRes;

    public NhaHangAdapter(Context context, ArrayList<NhaHang> arrayRes) {
        this.context = context;
        this.arrayRes = arrayRes;
    }

    @NonNull
    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.dong_item_nhahang,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        NhaHang nhaHang = arrayRes.get(i);
        viewHolder.txtTen.setText(nhaHang.getTenmonan());
        viewHolder.txtGia.setText(nhaHang.getGiamonan()+" Dong");
        viewHolder.txtDiaChi.setText(nhaHang.getDiadiem());

    }

    @Override
    public int getItemCount() {
        return arrayRes.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView txtTen, txtGia,txtDiaChi;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            txtTen = itemView.findViewById(R.id.txtTen);
            txtGia = itemView.findViewById(R.id.txtGia);
            txtDiaChi = itemView.findViewById(R.id.txtDiaChi);
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    String delete = "DELETE FROM NhaHang Where Id = '"+arrayRes.get(getPosition()).getId()+"'";
                    MainActivity.sqLiteDB.QueryData(delete);
                    arrayRes.remove(arrayRes.get(getPosition()));
                    notifyDataSetChanged();
                    Toast.makeText(context,"Xoa thanh cong", Toast.LENGTH_SHORT).show();
                    return false;
                }
            });
        }

    }
}
