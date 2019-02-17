package ac.uiu.messmanagementsystem.fragments.members;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AlertDialogLayout;
import android.support.v7.widget.PopupMenu;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import ac.uiu.messmanagementsystem.Dashboard;
import ac.uiu.messmanagementsystem.R;
import ac.uiu.messmanagementsystem.adapters.MemberListAdapter;
import ac.uiu.messmanagementsystem.model.MemberModel;
import ac.uiu.messmanagementsystem.serializable.Member;

import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 */
public class MemberHome extends Fragment {


    private ListView listView;
    private FloatingActionButton fab;
    private ArrayList<MemberModel> membersList;
    private MemberListAdapter adapter;

    public MemberHome() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle("Members");
        View view = inflater.inflate(R.layout.fragment_member_home, container, false);


        membersList = new ArrayList<MemberModel>();
        listView = view.findViewById(R.id.lv_member);
        fab = view.findViewById(R.id.fab_member);
        adapter = new MemberListAdapter(membersList, getActivity());
        listView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(getActivity(), AddMemberActivity.class), 1);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            }
        });

      listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
          @Override
          public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

              showPopup(view,position);
              return true;
          }
      });

    }

    private void showPopup(View view, final int position) {
        PopupMenu popupMenu = new PopupMenu(getActivity(),view, Gravity.RIGHT);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {

                if(menuItem.getItemId() == R.id.item_edit){
                    MemberModel member = membersList.get(position);
                    Intent intent = new Intent();
                    intent.putExtra("id","11");
                    startActivity(intent);
                }
                else if(menuItem.getItemId() == R.id.item_delete){
                    Toast.makeText(getActivity(),"Delete Clicked",Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });

        popupMenu.inflate(R.menu.member_popup_menu);
        popupMenu.show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                Member m = (Member) data.getSerializableExtra("dataObject");
                membersList.add(new MemberModel(m.getName(), R.drawable.logo, m.getEmail(), m.getPhone(), m.getBalance()));
                adapter.notifyDataSetChanged();
            }
        }
    }
}
