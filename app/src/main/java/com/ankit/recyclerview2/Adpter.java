package com.ankit.recyclerview2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class Adpter extends RecyclerView.Adapter<Adpter.ViewHolder> {///////////////////////////////////

    private String[] data;
    private int[] image;



    public Adpter( int[] image, String[] data){
    this.data=data;
    this.image=image;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.langlist, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final String title = data[position];
        final int img = image[position];
///

        ///
        holder.imageView.setImageResource(img);
        holder.textView.setText(title);
        /////////
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), GalleryActivity.class);
                intent.putExtra("image_name", title);
                //
                Bundle dataBundle = new Bundle();
                dataBundle.putInt("image_url", img);
                intent.putExtras(dataBundle);
                //
                //intent.putExtra("image_url", img);
                v.getContext().startActivity(intent);
                Log.d("Onclick Event","On click Working");
            }
        });
        //////////
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {///////////////////////////////////////////
        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);

        }


//        @Override
//        public void onClick(View v) {
//            int pos = this.getAdapterPosition();
//
//            Log.d("d","dd"+String.valueOf(pos));
//
//            Intent intent = new Intent(v.getContext(), GalleryActivity.class);
////https://www.dropbox.com/s/wrn2hm4xgu3z9wn/download.jpg?raw=1
//            intent.putExtra("image_name", "ghh");
//            intent.putExtra("image_url", "https://www.dropbox.com/s/wrn2hm4xgu3z9wn/download.jpg?raw=1");
//            v.getContext().startActivity(intent);
//
//        }
    }
}
