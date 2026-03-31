package com.nhom18.lab2_mobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<Hero> mHeros;

    public HeroAdapter(Context mContext, ArrayList<Hero> mHeros) {
        this.mContext = mContext;
        this.mHeros = mHeros;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Tạo view mới từ layout item_hero.xml
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View heroView = inflater.inflate(R.layout.item_hero, parent, false);
        return new ViewHolder(heroView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Gắn dữ liệu vào View
        Hero hero = mHeros.get(position);

        // Sử dụng thư viện Glide để load ảnh cho mượt
        Glide.with(mContext)
                .load(hero.getImage())
                .into(holder.mImageHero);

        holder.mTextName.setText(hero.getName());
    }

    @Override
    public int getItemCount() {
        return mHeros.size();
    }

    // Lớp ViewHolder để tái sử dụng View
    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageHero;
        private TextView mTextName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageHero = itemView.findViewById(R.id.image_hero);
            mTextName = itemView.findViewById(R.id.text_name);
        }
    }
}