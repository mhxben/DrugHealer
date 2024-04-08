package com.example.drughealer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.drughealer.databinding.ActivityWelcomeBinding;

public class WelcomeActivity extends AppCompatActivity {

    private ActivityWelcomeBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityWelcomeBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        // Remove top hint from TextInputLayout
        mBinding.tilEmail.setHintEnabled(false);
        mBinding.tilPassword.setHintEnabled(false);

        mBinding.tilSignUpFullName.setHintEnabled(false);
        mBinding.tilSignUpEmail.setHintEnabled(false);
        mBinding.tilSignUpPassword.setHintEnabled(false);
        mBinding.tilSignUpConfirmPassword.setHintEnabled(false);

        mBinding.bLogin.setOnClickListener(v -> {
            mBinding.bLogin.setBackgroundResource(R.drawable.bg_login_selected);
            mBinding.bSignup.setBackgroundResource(R.drawable.bg_sign_up_unselected);
            mBinding.gLogin.setVisibility(View.VISIBLE);
            mBinding.gSignup.setVisibility(View.GONE);
        });

        mBinding.bSignup.setOnClickListener(v -> {
            mBinding.bSignup.setBackgroundResource(R.drawable.bg_sign_up_selected);
            mBinding.bLogin.setBackgroundResource(R.drawable.bg_login_unselected);
            mBinding.gSignup.setVisibility(View.VISIBLE);
            mBinding.gLogin.setVisibility(View.GONE);
        });

        mBinding.tvForgetPassword.setOnClickListener(v -> {
            Intent intent = new Intent(this, ForgetPasswordActivity.class);
            startActivity(intent);
        });

        mBinding.bSignupNow.setOnClickListener(v -> {
            Intent intent = new Intent(this, GoalActivity.class);
            startActivity(intent);
        });

        mBinding.bLoginNow.setOnClickListener(v -> {
            Intent intent = new Intent(this, GoalActivity.class);
            startActivity(intent);
        });
    }

}