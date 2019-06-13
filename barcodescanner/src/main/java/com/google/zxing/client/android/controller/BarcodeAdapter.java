package com.google.zxing.client.android.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import barcodescanner.xservices.nl.barcodescanner.R;

public class BarcodeAdapter extends RecyclerView.Adapter<BarcodeAdapter.BarcodeViewHolder> {
    private String barcodes[];

    public BarcodeAdapter(String[] barcodes) {
        this.barcodes = barcodes;
    }


    @Override
    public BarcodeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.barcode_list_item, parent, false);
        BarcodeViewHolder barcode = new BarcodeViewHolder(v);
        return barcode;
    }

    @Override
    public void onBindViewHolder(@NonNull BarcodeViewHolder holder, int position) {
        holder.setText(barcodes[position]);
    }

    @Override
    public int getItemCount() {
        return barcodes.length;
    }

    public static class BarcodeViewHolder extends RecyclerView.ViewHolder {
        public TextView barcode;

        public BarcodeViewHolder(@NonNull LinearLayout itemView) {
            super(itemView);
            barcode = itemView.findViewById(R.id.barcode);
        }

        public void setText(String text) {
            barcode.setText(text);
        }
    }
}
