package com.nmh.speaktotext.abank_demo.ui.main.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nmh.speaktotext.abank_demo.R;

import java.util.List;

public class SliderAdapter extends PagerAdapter {
    private Context context;
    private List<Integer> color;
    private List<String> colorName;

    public SliderAdapter(Context context, List<Integer> color, List<String> colorName)
    {
        this.context = context;
        this.color = color;
        this.colorName = colorName;
    }

    @Override
    public int getCount() {
        return color.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_slider, null);

        TextView textView = (TextView) view.findViewById(R.id.textView);
        TextView textView1 = (TextView) view.findViewById(R.id.textView1);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.linearLayout);

        textView.setText(colorName.get(position));
        textView1.setText(color.get(position).toString());

        ViewPager viewPager = (ViewPager) container;
        viewPager.addView(view, 0);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ViewPager viewPager = (ViewPager) container;
        View view = (View) object;
        viewPager.removeView(view);
    }
}
