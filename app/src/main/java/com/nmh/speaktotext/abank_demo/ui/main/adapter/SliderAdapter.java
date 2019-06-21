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
    private List<Integer> accountNo;
    private List<String> accountName;
    private List<Integer> amount;
    private List<String> amountName;

    public SliderAdapter(Context context, List<Integer> accountNo,
                         List<String> accountName, List<Integer> amount, List<String> amountName)
    {
        this.context = context;
        this.accountNo = accountNo;
        this.accountName = accountName;
        this.amount = amount;
        this.amountName = amountName;
    }

    @Override
    public int getCount() {
        return amount.size();
    }



    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_slider, null);

        TextView text_accountNO = (TextView) view.findViewById(R.id.account);
        TextView text_accountName = (TextView) view.findViewById(R.id.accountName);
        TextView text_amount = (TextView) view.findViewById(R.id.amount);
        TextView text_amountName= (TextView) view.findViewById(R.id.amountName);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.linearLayout);

        text_accountNO.setText(Integer.toString(accountNo.get(position)));
        text_accountName.setText(accountName.get(position));
        text_amount.setText(Integer.toString(amount.get(position)));
        text_amountName.setText(amountName.get(position));
        

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
