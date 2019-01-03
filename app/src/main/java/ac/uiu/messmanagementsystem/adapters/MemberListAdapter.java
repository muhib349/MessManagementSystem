package ac.uiu.messmanagementsystem.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import ac.uiu.messmanagementsystem.R;

public class MemberListAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] maintitle;
    private final String[] subtitle;
    private final Integer[] imgid;
    private final Integer[] amounts;

    public MemberListAdapter(Activity context, String[] maintitle, String[] subtitle, Integer[] imgid,Integer[] amounts) {
        super(context, R.layout.member_list, maintitle);

        this.context = context;
        this.maintitle = maintitle;
        this.subtitle = subtitle;
        this.imgid = imgid;
        this.amounts = amounts;
    }


    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View rowView = inflater.inflate(R.layout.member_list, null, true);

        TextView titleText = (TextView) rowView.findViewById(R.id.tv_title);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.iv_icon);
        TextView subtitleText = (TextView) rowView.findViewById(R.id.tv_subtitle);
        TextView amnt = (TextView) rowView.findViewById(R.id.tv_amount);

        titleText.setText(maintitle[position]);
        imageView.setImageResource(imgid[position]);
        subtitleText.setText(subtitle[position]);
        amnt.setText(amounts[position].toString());

        return rowView;
    }

    ;
}
