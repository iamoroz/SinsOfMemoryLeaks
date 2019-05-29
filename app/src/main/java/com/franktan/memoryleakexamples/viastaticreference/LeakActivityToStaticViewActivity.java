package com.franktan.memoryleakexamples.viastaticreference;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.franktan.memoryleakexamples.R;

public class LeakActivityToStaticViewActivity extends AppCompatActivity {

    // FIXME: 2/26/17 static view will leak the activity. To fix it, make it non-static
    static TextView label;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        label = new TextView(this);
        label.setText(getString(R.string.leak_explanation_static_view, getString(R.string.instruction_check_for_leaks)));

        setContentView(label);
    }
}
