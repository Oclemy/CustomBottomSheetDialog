package info.camposha.mrsbottomdialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /**
     * I'll start by creating two utility methods.
     * @param message
     */
    private void show(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
    public static int dp2px(Context context, float dpVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpVal,
                context.getResources().getDisplayMetrics());
    }
    /**
     * Here am just creating a bottomsheet dialog from the android.app.Dialog
     * class
     */
    private void showFirstBottomDialog() {
        Dialog bottomDialog = new Dialog(this, R.style.BottomDialog);
        View contentView = LayoutInflater.from(this).inflate(R.layout.rectangular_dialog, null);
        bottomDialog.setContentView(contentView);
        ViewGroup.LayoutParams layoutParams = contentView.getLayoutParams();
        layoutParams.width = getResources().getDisplayMetrics().widthPixels;
        contentView.setLayoutParams(layoutParams);
        bottomDialog.getWindow().setGravity(Gravity.BOTTOM);
        bottomDialog.setCanceledOnTouchOutside(true);
        bottomDialog.getWindow().setWindowAnimations(R.style.BottomDialog_Animation);
        bottomDialog.show();
    }

    /**
     * Then here is the second, a little bit curved dialog
     */
    private void showSecondBottomDialog() {
        Dialog bottomDialog = new Dialog(this, R.style.BottomDialog);
        View contentView = LayoutInflater.from(this).inflate(R.layout.curved_dialog, null);
        bottomDialog.setContentView(contentView);
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) contentView.getLayoutParams();
        params.width = getResources().getDisplayMetrics().widthPixels - dp2px(this, 16f);
        params.bottomMargin = dp2px(this, 8f);
        contentView.setLayoutParams(params);
        bottomDialog.setCanceledOnTouchOutside(true);
        bottomDialog.getWindow().setGravity(Gravity.BOTTOM);
        bottomDialog.getWindow().setWindowAnimations(R.style.BottomDialog_Animation);
        bottomDialog.show();
    }
    /**
     * Let's handle a few item clicks. For buttons and just two of our
     * menu items. You can add more case statements to handle more
     * menu items.
     * @param view
     */
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_show_1:
                showFirstBottomDialog();
                break;
            case R.id.btn_show_2:
                showSecondBottomDialog();
                break;
            case R.id.editMenuItem:
                show("Edit Clicked");
                break;
            case R.id.starMenuItem:
                show("Star Clicked");
                break;
        }
    }


    /**
     * Our onCreate callback
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}
//end