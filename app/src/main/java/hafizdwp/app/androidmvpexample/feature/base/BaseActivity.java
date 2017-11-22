package hafizdwp.app.androidmvpexample.feature.base;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import butterknife.ButterKnife;

/**
 * Created by Asus on 11/21/2017.
 */

public class BaseActivity extends AppCompatActivity {

    private ProgressDialog mProgressDialog;
    private Toast mToast;

    public void baseBind(){
        ButterKnife.bind(this);
    }

    public void baseShowLoading(boolean isShow) {
        if (isShow) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setCancelable(false);
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.show();
        } else mProgressDialog.dismiss();
    }

    public void baseShowToast(String message) {
        if (mToast != null) mToast.cancel();
        mToast = Toast.makeText(this, message, Toast.LENGTH_LONG);
        mToast.show();
    }
}
