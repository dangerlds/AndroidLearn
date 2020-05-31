package com.dangerdasheng.listviewtest;

import android.content.Context;
import android.nfc.Tag;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class FruitAdapter extends ArrayAdapter<Fruit> {

    private int resourceId;
    public FruitAdapter(Context context, int textViewResourceId,
                        List<Fruit> objects){
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //converView为用于将之前加载好的布局进行缓存
        Fruit fruit = getItem(position);
        View view;
        ViewHolder viewHolder;
        //如果convertView没有加载过，那么初始化一个并将Viewholder存储到view里
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,
                    parent,false);//根据xml的id和父视图获取单行view
            viewHolder = new ViewHolder();
            viewHolder.fruitImage = (ImageView)view.findViewById(R.id.fruit_image);
            viewHolder.fruitName = (TextView) view.findViewById(R.id.fruit_name);
            view.setTag(viewHolder);//将Viewholder存储到View中
        }else {
            view = convertView;
            viewHolder = (ViewHolder)view.getTag();//从View中获取ViewHolder
        }
        Log.i("viewHolder = ",viewHolder.toString());
        Log.i("view = ",view.toString());


        viewHolder.fruitImage.setImageResource(fruit.getImageId());
        viewHolder.fruitName.setText(fruit.getName());
        return view;
    }
    class ViewHolder {
        ImageView fruitImage;
        TextView fruitName;
    }
}
