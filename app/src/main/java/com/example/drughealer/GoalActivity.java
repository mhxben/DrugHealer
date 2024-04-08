package com.example.drughealer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.example.drughealer.databinding.ActivityGoalBinding;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.DateValidatorPointForward;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

public class GoalActivity extends AppCompatActivity {

    ActivityGoalBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityGoalBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        // Next Screen
        mBinding.bNext.setOnClickListener(v -> {
            mBinding.gEnterSpend.setVisibility(View.GONE);
            mBinding.gEnterDate.setVisibility(View.VISIBLE);
        });

        // Calculate the spending
        mBinding.tietSpend.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    mBinding.tietSaveWeek
                            .setText(String.valueOf(Double.parseDouble(s.toString()) * 7));
                    mBinding.tietSaveMonth
                            .setText(String.valueOf(Double.parseDouble(s.toString()) * 30));
                } else {
                    mBinding.tietSaveWeek.setText("");
                    mBinding.tietSaveMonth.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        // Enter Date
        mBinding.vDate.setOnClickListener(v -> {
            // Create a DateValidator to allow only future dates
            CalendarConstraints.Builder constraintsBuilder = new CalendarConstraints.Builder();
            constraintsBuilder.setValidator(DateValidatorPointForward.now());

            MaterialDatePicker<Long> picker = MaterialDatePicker.Builder.datePicker()
                    .setTitleText("Select date")
                    .setCalendarConstraints(constraintsBuilder.build())
                    .build();

            picker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener<Long>() {
                @Override
                public void onPositiveButtonClick(Long selection) {
                    mBinding.tietDate.setText(picker.getHeaderText());
                }
            });

            picker.show(getSupportFragmentManager(), picker.toString());
        });
    }
}