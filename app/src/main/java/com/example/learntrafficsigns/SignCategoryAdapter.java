package com.example.learntrafficsigns;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class SignCategoryAdapter extends RecyclerView.Adapter<SignCategoryAdapter.ViewHolder> {
    private final List<SignCategory> categories;
    private final Context context;

    public SignCategoryAdapter(Context context, List<SignCategory> categories) {
        this.context = context;
        this.categories = categories;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SignCategory category = categories.get(position);
        holder.textView.setText(category.getName());
        holder.imageView.setImageResource(category.getImageResId());

        holder.cardView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ViewSigns.class);
            intent.putExtra("Category", category.getName());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.categoryText);
            imageView = itemView.findViewById(R.id.categoryImage);
            cardView = itemView.findViewById(R.id.categoryCard);
        }
    }
}

