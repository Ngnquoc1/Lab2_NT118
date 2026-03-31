package com.nhom18.lab2_mobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class ThumbnailAdapter extends ArrayAdapter<Thumbnail> {
    public ThumbnailAdapter(Context context, Thumbnail[] objects) {
        super(context, 0, objects);
    }

    // Hiển thị khi đã chọn xong (Chỉ có Text)
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_selected_thumbnail, parent, false);
        }
        TextView tvName = convertView.findViewById(R.id.tvSelectedName);
        tvName.setText(getItem(position).getName());
        return convertView;
    }

    // Hiển thị danh sách trong Dialog (Có Text + Image)
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_thumbnail, parent, false);
        }
        TextView tvName = convertView.findViewById(R.id.tvName);
        ImageView ivImg = convertView.findViewById(R.id.ivThumbnail);

        Thumbnail thumbnail = getItem(position);
        assert thumbnail != null;
        tvName.setText(thumbnail.getName());
        ivImg.setImageResource(thumbnail.getImg());

        return convertView;
    }
}