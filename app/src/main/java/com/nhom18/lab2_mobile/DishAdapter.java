package com.nhom18.lab2_mobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class DishAdapter extends ArrayAdapter<Dish> {
    public DishAdapter(Context context, List<Dish> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_dish, parent, false);
        }

        Dish dish = getItem(position);

        ImageView ivThumbnail = convertView.findViewById(R.id.ivDishThumbnail);
        TextView tvName = convertView.findViewById(R.id.tvDishName);
        ImageView ivPromotion = convertView.findViewById(R.id.ivPromotion);

        ivThumbnail.setImageResource(dish.getThumbnail().getImg());
        tvName.setText(dish.getName());
        tvName.setSelected(true); // Kích hoạt hiệu ứng chữ chạy Marquee

        if (dish.isPromotion()) {
            ivPromotion.setVisibility(View.VISIBLE);
        } else {
            ivPromotion.setVisibility(View.GONE);
        }

        return convertView;
    }
}