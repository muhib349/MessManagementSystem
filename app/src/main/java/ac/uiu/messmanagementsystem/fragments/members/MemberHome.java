package ac.uiu.messmanagementsystem.fragments.members;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import ac.uiu.messmanagementsystem.R;
import ac.uiu.messmanagementsystem.adapters.MemberListAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class MemberHome extends Fragment {

    private final String[] title = {"Title 1", "Title 2", "Title 3"};
    private final Integer[] amoutns = {1000, 1500, 3000};
    private final String[] sub_title = {"member 1", "member 2", "member 3 "};
    private final Integer[] img = {R.drawable.logo, R.drawable.logo, R.drawable.logo};


    private ListView listView;

    public MemberHome() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle("Members");
        View view = inflater.inflate(R.layout.fragment_member_home, container, false);

        listView = view.findViewById(R.id.lv_member);

        MemberListAdapter adapter = new MemberListAdapter(getActivity(), title, sub_title, img,amoutns);
        listView.setAdapter(adapter);
        return view;
    }

}
