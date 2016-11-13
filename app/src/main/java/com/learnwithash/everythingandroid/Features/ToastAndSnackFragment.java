package com.learnwithash.everythingandroid.Features;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.learnwithash.everythingandroid.R;

/**
 * Created by Ash on 11/11/16.
 */
public class ToastAndSnackFragment extends BaseFragment implements View.OnClickListener {

    private View mView;
    private RadioButton mRadioBtnOne, mRadioButtonTwo, mRadioButtonThree;
    private Toast mToast;
    private RelativeLayout mLayout;
    private int mDuration, mSnackDuration;
    private Button mRepeatBtn, mRegularbtn, mSnackActionBtn;
    private RadioGroup mRadioGroup;
    AlertDialog aD;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        mView = inflater.inflate(R.layout.frag_toast_and_snack_layout, container, false);
        init();
        return mView;
    }

    private void init() {
        mRadioBtnOne = (RadioButton) mView.findViewById(R.id.rb_one);
        mRadioButtonTwo = (RadioButton) mView.findViewById(R.id.rb_two);
        mRadioButtonThree = (RadioButton) mView.findViewById(R.id.rb_three);
        mRepeatBtn = (Button) mView.findViewById(R.id.btn_show_toast);
        mRadioGroup = (RadioGroup) mView.findViewById(R.id.rg_container);
        mRegularbtn = (Button) mView.findViewById(R.id.btn_regular_snackbar);
        mSnackActionBtn = (Button) mView.findViewById(R.id.btn_with_action_snackbar);
        mLayout = (RelativeLayout) mView.findViewById(R.id.toast_frag_container);
        attachListeners();

    }

    private void checkSettings() {
        if (!mRadioBtnOne.isChecked() && !mRadioButtonTwo.isChecked() &&
                !mRadioButtonThree.isChecked()) {
            showAlertDialog();
        } else {
            if (mRadioBtnOne.isChecked()) {
                mDuration = Toast.LENGTH_SHORT;
                mSnackDuration = Snackbar.LENGTH_SHORT;
            } else if (mRadioButtonTwo.isChecked()) {
                mDuration = Toast.LENGTH_LONG;
                mSnackDuration = Snackbar.LENGTH_LONG;
            } else if (mRadioButtonThree.isChecked()) {
                customToast();

            }
        }
    }

    private void showAlertDialog() {
        aD = new AlertDialog.Builder(getActivity()).create();
        aD.setMessage("No radio button option was selected" + "\n \n Note: Short and long apply to " +
                "snack bar options at the bottom of the screen as well");
        aD.setTitle("SELECT OPTION");
        aD.setButton(DialogInterface.BUTTON_POSITIVE, "Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        aD.show();
    }

    private void regularToast() {
        mToast = Toast.makeText(getActivity(), "Hello from here", mDuration);
        mToast.setGravity(Gravity.CENTER | Gravity.START, 100, 100);
        mToast.show();
    }

    private void customToast() {
        //Creating Custom View Object
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast_layout, (ViewGroup)
                mView.findViewById(R.id.customToastLayoutContainer));

        //Setting text in custom toast layout
        TextView tv = (TextView) layout.findViewById(R.id.custom_toast_tv);
        tv.setText("Custom Toast Message");

        Toast t = new Toast(getActivity().getApplicationContext());
        t.setDuration(mDuration);
        t.setGravity(Gravity.CENTER | Gravity.START, 100, 100);
        t.setView(layout);
        t.show();
    }

    private void attachListeners() {
        mRadioBtnOne.setOnClickListener(this);
        mRadioButtonTwo.setOnClickListener(this);
        mLayout.setOnClickListener(this);
        mRepeatBtn.setOnClickListener(this);
        mRegularbtn.setOnClickListener(this);
        mSnackActionBtn.setOnClickListener(this);

    }

    private void unCheckRadioButton(RadioButton rb, boolean value) {
        rb.setChecked(value);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rb_one:
                if (mRadioButtonTwo.isChecked()) {
                    unCheckRadioButton(mRadioButtonTwo, false);
                } else {
                    unCheckRadioButton(mRadioButtonThree, false);
                }
                break;
            case R.id.rb_two:
                if (mRadioBtnOne.isChecked()) {
                    unCheckRadioButton(mRadioBtnOne, false);
                } else {
                    unCheckRadioButton(mRadioButtonThree, false);
                }
                break;
            case R.id.rb_three:
                if (mRadioBtnOne.isChecked()) {
                    unCheckRadioButton(mRadioBtnOne, false);
                } else {
                    unCheckRadioButton(mRadioButtonTwo, false);
                }
                break;
            case R.id.btn_regular_snackbar:
                showRegularSnack();
                break;
            case R.id.btn_with_action_snackbar:
                showSnackWithAction();
                break;
            case R.id.btn_show_toast:
                checkSettings();
                if (!mRadioButtonThree.isChecked() && !aD.isShowing()) {
                    regularToast();
                }
                break;
            case R.id.toast_frag_container:
                mRadioGroup.clearCheck();
                break;
            default:

                break;
        }
    }

    private void showRegularSnack() {
        checkSettings();
        if (!aD.isShowing()) {
            Snackbar regSnack = Snackbar.make(mView.findViewById(R.id.coordinator_container),
                    "Regular snack bar message", mSnackDuration);
            regSnack.show();
        }
    }

    private void showSnackWithAction() {
        checkSettings();
        if (!aD.isShowing()) {
            Snackbar actionSnack = Snackbar.make(mView.findViewById(R.id.coordinator_container),
                    "Snack Bar with Action Button", mSnackDuration);
            actionSnack.setAction("OK", new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getActivity().getApplicationContext(), "Action was tapped",
                            Toast.LENGTH_SHORT).show();
                }
            });
            actionSnack.setActionTextColor(getResources().getColor(R.color.colorAccent));
            actionSnack.show();
        }
    }
}
