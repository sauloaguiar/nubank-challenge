package com.sauloguiar.nubankchallenge;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.Button;
import android.widget.ImageView;
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

    private UiEvents.ChargebackScreenPresenter presenter;
    private TextView comment;

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
        title = (TextView) findViewById(R.id.chargeback_screen_title);
        lockImage = (ImageView) findViewById(R.id.chargeback_screen_lock_image);
        cardStatusText = (TextView) findViewById(R.id.chargeback_screen_card_status);

        merchantSwitch = (Switch) findViewById(R.id.chargeback_screen_merchant_switch);
        cardInHandsSwitch = (Switch) findViewById(R.id.chargeback_screen_card_in_possession_switch);

        comment = (TextView) findViewById(R.id.chargeback_screen_comment);

        cancelButton = (Button) findViewById(R.id.chargeback_screen_cancel_button);
        contestButton = (Button) findViewById(R.id.chargeback_screen_contest_button);
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

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void onFailure(Throwable t) {

    }

    @Override
    public void setTitle(String title) {
        this.title.setText(title);
    }
}
