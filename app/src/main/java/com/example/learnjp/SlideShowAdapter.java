package com.example.learnjp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SlideShowAdapter extends PagerAdapter {


    private Context context;
    LayoutInflater inflater;

    public SlideShowAdapter(Context context) {
        this.context = context;
    }


    public int image[]= {


            R.drawable.song,
            R.drawable.albums,
            R.drawable.musicvideo,
            R.drawable.wallpaper,
            R.drawable.news,
            R.drawable.bg

    };

    @Override
    public int getCount() {
        return image.length;
    }


    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view==(LinearLayout)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view=inflater.inflate(R.layout.slideshow_layout,container,false);

        ImageView img=(ImageView) view.findViewById(R.id.imgSlideShow);

        img.setImageResource(image[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }


}
