package ac.uiu.messmanagementsystem.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import ac.uiu.messmanagementsystem.R;
import ac.uiu.messmanagementsystem.model.MemberModel;

public class MemberListAdapter extends ArrayAdapter<MemberModel> {
    Activity context;
    private ArrayList<MemberModel> memberModels;

    public MemberListAdapter(ArrayList<MemberModel> memberModels,Activity context) {
        super(context, android.R.layout.simple_list_item_1,memberModels);

        this.context = context;
        this.memberModels = memberModels;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View view = inflater.inflate(R.layout.member_list, null, true);

        TextView titleText = view.findViewById(R.id.tv_title);
        ImageView imageView = view.findViewById(R.id.iv_icon);
        TextView phoneText = view.findViewById(R.id.tv_phone);
        TextView email = view.findViewById(R.id.tv_email);
        TextView balance = view.findViewById(R.id.tv_amount);

        titleText.setText(memberModels.get(position).getName());
        imageView.setImageResource(memberModels.get(position).getImg());
        phoneText.setText(memberModels.get(position).getPhone());
        email.setText(memberModels.get(position).getEmail());
        balance.setText(memberModels.get(position).getBalance().toString());
        return view;
    }
}
