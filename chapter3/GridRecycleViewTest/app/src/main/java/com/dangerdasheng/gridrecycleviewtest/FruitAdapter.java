package com.dangerdasheng.gridrecycleviewtest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {

    private List<Fruit> mFruitList;

    static class ViewHolder extends RecyclerView.ViewHolder{

        ImageView fruitImage;
        TextView fruitName;
        View fruitView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fruitView = itemView;
            fruitImage = (ImageView)itemView.findViewById(R.id.fruit_image);
            fruitName = (TextView)itemView.findViewById(R.id.fruit_name);

        }
    }
    public FruitAdapter(List<Fruit> fruitList){
        mFruitList = fruitList;
    }

    @NonNull
    @Overridec
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);

        holder.fruitImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Toast.makeText(view.getContext(),
                        "you clicked image " + fruit.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        });
        holder.fruitView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Toast.makeText(view.getContext(),
                        "you clicked view " + fruit.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,
                                 int position) {
        Fruit fruit = mFruitList.get(position);
        holder.fruitImage.setImageResource(fruit.getImageId());
        holder.fruitName.setText(fruit.getName());

    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }
}
