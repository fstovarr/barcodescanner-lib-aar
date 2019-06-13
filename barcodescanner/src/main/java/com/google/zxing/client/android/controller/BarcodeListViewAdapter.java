package com.google.zxing.client.android.controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.json.JSONArray;

import java.util.ArrayList;

import barcodescanner.xservices.nl.barcodescanner.R;

public class BarcodeListViewAdapter extends BaseAdapter {
    private ArrayList<String[]> barcodes;

    public BarcodeListViewAdapter(JSONArray barcodes) {
        ArrayList<String[]> array = new ArrayList<>(10);
        try {
            for (int i = 0; i < barcodes.length(); i++) {
                JSONArray barcode = barcodes.getJSONArray(i);
                array.add(new String[]{barcode.getString(0), barcode.getString(1)});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.barcodes = array;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }

    @Override
    public int getCount() {
        return barcodes.size();
    }

    @Override
    public String[] getItem(int i) {
        return barcodes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup container) {
        if (convertView == null) {
            convertView = LayoutInflater.from(container.getContext())
                    .inflate(R.layout.barcode_list_item, container, false);
        }

        ((TextView) convertView.findViewById(R.id.barcode))
                .setText(getItem(i)[0]);
        ((TextView) convertView.findViewById(R.id.barcode_name))
                .setText(getItem(i)[1]);

        return convertView;
    }
}
