package ivanlu.com.tw.popwindows;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class PopWindowActivity extends AppCompatActivity {

    public TextView root, root2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_window);
        root = (TextView)findViewById(R.id.root);
        root.setOnClickListener(cardIconListener);
        root2 = (TextView)findViewById(R.id.root2);
        root2.setOnClickListener(cardIconListener2);
    }

    View.OnClickListener cardIconListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            try {
                if (root != null) {
                    View popWindow = LayoutInflater.from(PopWindowActivity.this).inflate(R.layout.pop_window_card_icon, null, false);
                    ImageView imageView = (ImageView) popWindow.findViewById(R.id.card_icon);
                    imageView.setImageResource(getCardIconRes());
                    final PopupWindow window = new PopupWindow(popWindow,
                            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
                    popWindow.setPadding(0, 50, 0, 0);
                    window.setTouchable(true);
                    window.setTouchInterceptor(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View v, MotionEvent event) {
                            window.dismiss();
                            return false;
                        }
                    });
                    window.setBackgroundDrawable(new ColorDrawable(0));
                    window.showAtLocation(root, Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
                }
            } catch (Exception e) {
                Log.e(PopWindowActivity.class.getSimpleName(), ""+e);
            }
        }
    };

    View.OnClickListener cardIconListener2 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            try {
                if (root2 != null) {
                    View popWindow = LayoutInflater.from(PopWindowActivity.this).inflate(R.layout.pop_window_card_icon_center, null, false);
                    ImageView imageView = (ImageView) popWindow.findViewById(R.id.card_icon);
                    imageView.setImageResource(getCardIconRes());
                    final PopupWindow window = new PopupWindow(popWindow,
                            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
                    window.setTouchable(true);
                    window.setTouchInterceptor(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View v, MotionEvent event) {
                            window.dismiss();
                            return false;
                        }
                    });
                    window.setBackgroundDrawable(new ColorDrawable(0));
                    window.showAtLocation(root2, Gravity.NO_GRAVITY, 0, 0);
                }
            } catch (Exception e) {
                Log.e(PopWindowActivity.class.getSimpleName(), ""+e);
            }
        }
    };

    private int getCardIconRes() {
       return R.drawable.traffic_ecc_card;
    }
}
