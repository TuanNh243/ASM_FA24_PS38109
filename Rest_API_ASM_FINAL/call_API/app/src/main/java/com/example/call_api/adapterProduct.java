package com.example.call_api;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.call_api.Models.product;

import java.util.ArrayList;

public class adapterProduct extends RecyclerView.Adapter<adapterProduct.ViewHolder> {

    private Context context;
    private ArrayList<product> productList;

    public adapterProduct(Context context, ArrayList<product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        product item = productList.get(position);

        holder.type.setText("Loại: " + item.getVoucherType());
//        Log.e("API Response", "Lỗi kết nối: " + item.get_id());
        holder.name.setText("Khuyến mãi : " + item.getVoucherCon());
        holder.dateUnVai.setText("Ngày hết hạn: " + item.getDateAvai());
        holder.quantity.setText("Số luợng: " + item.getAmount());
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView type, name, quantity, dateUnVai;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            type = itemView.findViewById(R.id.voucherType);
            name = itemView.findViewById(R.id.voucherCon);
            dateUnVai = itemView.findViewById(R.id.dateUnVai);
            quantity = itemView.findViewById(R.id.amount);
        }
    }
}
