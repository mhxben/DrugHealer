package com.example.drughealer.listener;

import android.text.Editable;
import android.text.TextWatcher;

import com.google.android.material.textfield.TextInputEditText;

public class FocusChangeTextWatcher implements TextWatcher {

    private TextInputEditText nextEditText;

    public FocusChangeTextWatcher(TextInputEditText nextEditText) {
        this.nextEditText = nextEditText;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (s.length() == 1)
            nextEditText.requestFocus();
    }

    @Override
    public void afterTextChanged(Editable s) {

    }

}
