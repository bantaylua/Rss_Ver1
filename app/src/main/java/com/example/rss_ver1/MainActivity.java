package com.example.rss_ver1;

import android.app.Activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
    public class MyAdapter extends BaseAdapter{
        final int NumberOfItem = 4;
        private Bitmap[] bitmaps = new Bitmap[NumberOfItem];

        Integer[] image ={R.drawable.logo_dantri, R.drawable.logo_laodong, R.drawable.logo_thanhnien, R.drawable.logo_vnexpress};

        private Context context;
        private LayoutInflater layoutInflater;

        MyAdapter(Context c){
            context = c;
            layoutInflater = LayoutInflater.from(context);

            //init dummy bitmap
            // using R.drawable.icon for all items
            for (int i = 0; i < NumberOfItem; i++){
                bitmaps[i] = BitmapFactory.decodeResource(context.getResources(), image[i]);
            }
        }
        @Override
        public int getCount() {
            return bitmaps.length;
        }

        @Override
        public Object getItem(int position){
            return bitmaps[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            View grid;
            if (convertView == null){
                grid = new View(context);
                grid = layoutInflater.inflate(R.layout.gridlayout, null);

            } else {
                grid = (View) convertView;
            }

            ImageView imageView = (ImageView)grid.findViewById(R.id.image);
            imageView.setImageBitmap(bitmaps[position]);
            TextView textView = (TextView)grid.findViewById(R.id.text);
            textView.setText(String.valueOf(position));

            return grid;
        }
    }

    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = (GridView)findViewById(R.id.grid);

        MyAdapter adapter = new MyAdapter(this);
        gridView.setAdapter(adapter);
    }
}
