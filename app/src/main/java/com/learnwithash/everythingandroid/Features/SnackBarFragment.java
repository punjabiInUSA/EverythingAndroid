package com.learnwithash.everythingandroid.Features;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.learnwithash.everythingandroid.R;

/**
 * Created by Ash on 11/12/16.
 */
public class SnackBarFragment extends BaseFragment implements View.OnClickListener {

    private View mView;
    private Button mRegularBtn, mSnackActionBtn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);
         mView = inflater.inflate(R.layout.frag_snack_menu_layout, container, false);
         init();
         return mView;
    }

    private void init() {
        mRegularBtn = (Button) mView.findViewById(R.id.btn_regular_snackbar);
        mSnackActionBtn = (Button) mView.findViewById(R.id.btn_with_action_snackbar);
        mRegularBtn.setOnClickListener(this);
        mSnackActionBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_regular_snackbar:
                showRegularSnack();
                break;
            case R.id.btn_with_action_snackbar:
                showSnackWithAction();
                break;
            default:
                break;
        }
    }

    private void showSnackWithAction() {
        Snackbar actionSnack = Snackbar.make(mView.findViewById(R.id.coordinator_container),
                "Snack Bar with Action Button",Snackbar.LENGTH_LONG);
        actionSnack.setAction("OK", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity().getApplicationContext(),"Action was tapped",
                        Toast.LENGTH_SHORT).show();
            }
        });
        actionSnack.setActionTextColor(getResources().getColor(R.color.colorAccent));
        actionSnack.show();
    }

    private void showRegularSnack() {
        Snackbar regSnack = Snackbar.make(mView.findViewById(R.id.coordinator_container),
                "Regular snack bar message",Snackbar.LENGTH_LONG);
        regSnack.show();
    }
}
