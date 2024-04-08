package com.example.drughealer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.drughealer.databinding.ActivityForgetPasswordBinding;
import com.example.drughealer.listener.FocusChangeTextWatcher;

public class ForgetPasswordActivity extends AppCompatActivity {

    private ActivityForgetPasswordBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityForgetPasswordBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        // Remove top hint from TextInputLayout
        mBinding.tilEmail.setHintEnabled(false);
        mBinding.tilPassword.setHintEnabled(false);
        mBinding.tilConfirmPassword.setHintEnabled(false);

        // Setup buttons click listener
        mBinding.bBack.setOnClickListener(v -> {
            finish();
        });

        mBinding.bSubmit.setOnClickListener(v -> {
            mBinding.gEnterEmail.setVisibility(View.GONE);
            mBinding.gEnterCode.setVisibility(View.VISIBLE);
        });

        mBinding.bConfirmCode.setOnClickListener(v -> {
            mBinding.gEnterCode.setVisibility(View.GONE);
            mBinding.gEnterPassword.setVisibility(View.VISIBLE);
        });

        mBinding.bConfirmPassword.setOnClickListener(v -> {
            Intent intent = new Intent(this, GoalActivity.class);
            startActivity(intent);
        });

        // Setup code TextInputEditText to switch auto
        mBinding.tietCode1.addTextChangedListener(
                new FocusChangeTextWatcher(mBinding.tietCode2));
        mBinding.tietCode2.addTextChangedListener(
                new FocusChangeTextWatcher(mBinding.tietCode3));
        mBinding.tietCode3.addTextChangedListener(
                new FocusChangeTextWatcher(mBinding.tietCode4));
    }
}