package com.sauloguiar.nubankchallenge;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.sauloguiar.nubankchallenge.presenter.NoticePresenter;
import com.sauloguiar.nubankchallenge.ui.UiEvents;
import com.sauloguiar.nubankchallenge.ui.Views;

import java.net.UnknownHostException;

public class NoticeScreenActivity extends AppCompatActivity implements Views.NoticeScreen {

    private UiEvents.NoticeScreenPresenter presenter;
    private TextView title;
    private TextView description;
    private Button buttonContinue;
    private Button buttonClose;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_notice_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        presenter = new NoticePresenter(this);

        loadViewObjects();
    }

    private void loadViewObjects() {
        title = (TextView) findViewById(R.id.notice_screen_title);
        description = (TextView) findViewById(R.id.notice_screen_description);
        buttonContinue = (Button) findViewById(R.id.notice_screen_button_continue);
        buttonClose = (Button) findViewById(R.id.notice_screen_button_close);

        progressBar = (ProgressBar) findViewById(R.id.content_screen_progress_bar);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onStart();
    }

    @Override
    protected void onStop() {
        presenter.onStop();
        super.onStop();
    }

    public void onContinuePressed(View v){
        presenter.onContinue();
        Intent intent = new Intent(this, ChargebackScreenActivity.class);
        startActivity(intent);
    }

    public void onCancelPressed(View v){
        presenter.onNoticeCancelled();
        finish();
    }

    @Override
    public void setTitle(String title) {
        this.title.setText(title);
    }

    @Override
    public void setDescription(String description) {
        this.description.setText(Html.fromHtml(description));
    }

    @Override
    public void setContinueButtonLabel(String label) {
        buttonContinue.setText(label);
    }

    @Override
    public void setCancelButtonLabel(String label) {
        buttonClose.setText(label);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        Log.d("NoticeScreenActivity", "displaying progress...");
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onFailure(Throwable t) {
        progressBar.setVisibility(View.GONE);
        Toast.makeText(this, "We had a problem...", Toast.LENGTH_SHORT).show();
        if (t instanceof UnknownHostException) {
            Toast.makeText(this, getString(R.string.internet_error) , Toast.LENGTH_LONG).show();
            finish();
        }

    }
}
