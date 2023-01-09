package id.ac.poliban.e020320049.listindemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import id.ac.poliban.e020320049.listindemo.model.Flag;

public class FlagAdapter extends BaseAdapter {
    private Context mContext;
    private List<Flag> mList;

    public FlagAdapter(Context mContext, List<Flag> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    private static class ViewHolder{
        ImageView imageFlag;
        TextView tvCountryName;

        public ViewHolder(View itemView) {
            imageFlag = itemView.findViewById(R.id.imageView);
            tvCountryName = itemView.findViewById(R.id.tv_country);
        }


    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null) {
            view = LayoutInflater.from(mContext)
                    .inflate(R.layout.flag_layout, viewGroup, false);

            holder = new ViewHolder(view);
            view.setTag(holder);
        }
        else
            holder = (ViewHolder) view.getTag();

        holder.imageFlag.setImageResource(mList.get(i).getFlag());
        holder.tvCountryName.setText(mList.get(i).getCountryName());

        return view;
    }
}
