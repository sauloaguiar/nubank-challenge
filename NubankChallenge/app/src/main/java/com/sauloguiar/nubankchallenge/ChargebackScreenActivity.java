package com.sauloguiar.nubankchallenge;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.sauloguiar.nubankchallenge.presenter.ChargebackPresenter;
import com.sauloguiar.nubankchallenge.ui.UiEvents;
import com.sauloguiar.nubankchallenge.ui.Views;

public class ChargebackScreenActivity extends AppCompatActivity implements Views.ChargebackScreen {

    private TextView title;
    private ImageView lockImage;
    private TextView cardStatusText;
    private Switch merchantSwitch;
    private Switch cardInHandsSwitch;
    private Button cancelButton;
    private Button contestButton;

    private boolean isCardBlocked = false;

    private UiEvents.ChargebackScreenPresenter presenter;
    private TextView comment;
    private EditText editText;
    private RelativeLayout container;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chargeback_notice_screen);

        loadViewObjects();

        presenter = new ChargebackPresenter(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onStart();
    }

    private void loadViewObjects() {
        container = (RelativeLayout) findViewById(R.id.chargeback_screen_container);
        title = (TextView) findViewById(R.id.chargeback_screen_title);
        lockImage = (ImageView) findViewById(R.id.chargeback_screen_lock_image);
        cardStatusText = (TextView) findViewById(R.id.chargeback_screen_card_status);

        merchantSwitch = (Switch) findViewById(R.id.chargeback_screen_merchant_switch);

        cardInHandsSwitch = (Switch) findViewById(R.id.chargeback_screen_card_in_possession_switch);

        comment = (TextView) findViewById(R.id.chargeback_screen_comment);

        cancelButton = (Button) findViewById(R.id.chargeback_screen_cancel_button);
        contestButton = (Button) findViewById(R.id.chargeback_screen_contest_button);

        progressBar = (ProgressBar) findViewById(R.id.chargeback_screen_progress_bar);

        editText = (EditText) findViewById(R.id.chargeback_screen_edit_text);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().equals("")) {
                    contestButton.setTextColor(getResources().getColor(R.color.close_gray));
                } else {
                    contestButton.setTextColor(getResources().getColor(R.color.disabled_gray));
                }
            }
        });
    }

    public void onCancelPressed(View v) {
        presenter.onChargebackCancelled();
        finish();
    }

    public void onContestPressed(View v) {
        presenter.onChargebackSubmit(merchantSwitch.isChecked(), cardInHandsSwitch.isChecked());
    }

    public void onImageClicked(View v) {
        if (isCardBlocked) {
            presenter.unblockCard();
        } else {
            presenter.blockCard();
        }
    }

    @Override
    public void setMerchantRecognized(boolean bool, String label) {
        merchantSwitch.setChecked(bool);
        merchantSwitch.setText(label);
    }

    @Override
    public void setCardInPossession(boolean bool, String label) {
        cardInHandsSwitch.setChecked(bool);
        cardInHandsSwitch.setText(label);
    }

    @Override
    public void autoblockCard(boolean bool) {
        isCardBlocked = bool;
        if (bool) {
            lockImage.setImageResource(R.drawable.ic_chargeback_lock);
            cardStatusText.setText(getString(R.string.preventive_block));
        } else {
            lockImage.setImageResource(R.drawable.ic_chargeback_unlock);
            cardStatusText.setText(getString(R.string.warning_block));
        }
    }

    @Override
    public void setComment(String comment) {
        this.comment.setText(Html.fromHtml(comment));
    }

    @Override
    public void showProgress() {
        container.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
        container.setVisibility(View.VISIBLE);
    }

    @Override
    public void onFailure(Throwable t) {

    }

    @Override
    public void setTitle(String title) {
        this.title.setText(title);
    }
}
