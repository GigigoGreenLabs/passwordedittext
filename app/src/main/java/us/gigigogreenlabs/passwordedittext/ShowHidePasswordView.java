package us.gigigogreenlabs.passwordedittext;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;


/**
 * Created by josemoralejo on 19/5/15.
 */
public class ShowHidePasswordView  extends EditText{

    private static final int SHOW_TYPE_ON_CLICK = 0;
    private static final int SHOW_TYPE_LONG_PRESS = 1;
    private boolean clicable;
    private boolean visible;

    public ShowHidePasswordView(Context context) {
        this(context, null);
    }

    public ShowHidePasswordView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initComponent(attrs);
    }

    public ShowHidePasswordView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initComponent(attrs);
    }

    private void initComponent(AttributeSet attrs) {
        initView();
        loadAttributes(attrs);
        setListeners();
        performHidePassword();
    }


    private void initView(){
        //this.setTransformationMethod(new PasswordTransformationMethod());
       // this.setCompoundDrawablesWithIntrinsicBounds(0, 0, android.R.drawable.ic_secure, 0); //icon (left, up, right, down)
        this.setInputType(EditorInfo.TYPE_TEXT_FLAG_NO_SUGGESTIONS);//No suggestions.

    }


    private void loadAttributes(AttributeSet attrs) {
        if( attrs!= null) {
            // Procesamos los atributos XML personalizados
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.ShowHidePasswordView);

            int showType = a.getInt(R.styleable.ShowHidePasswordView_show_type, SHOW_TYPE_LONG_PRESS);
            clicable = ( showType == SHOW_TYPE_ON_CLICK)? true: false;
            a.recycle();
        }
    }






    private void setListeners() {
        this.setOnTouchListener(onTouchListener);
    }








    OnTouchListener onTouchListener = new OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            final int DRAWABLE_LEFT = 0;
            final int DRAWABLE_TOP = 1;
            final int DRAWABLE_RIGHT = 2;
            final int DRAWABLE_BOTTOM = 3;

            if(clicable){
                if (event.getAction() == MotionEvent.ACTION_UP){
                    if (event.getRawX() >= (ShowHidePasswordView.this.getRight() - ShowHidePasswordView.this.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {

                        if (visible) {
                            performHidePassword();
                        } else {
                            performShowPassword();
                        }
                        visible = !visible;
                    }
                }

            } else {

                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    if (event.getRawX() >= (ShowHidePasswordView.this.getRight() - ShowHidePasswordView.this.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        Log.d("jmmt", "pulsoooo");
                        performShowPassword();
                        return true;
                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_MOVE) {
                    if (event.getRawX() >= (ShowHidePasswordView.this.getRight() - ShowHidePasswordView.this.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        Log.d("jmmt", "sueltooo");
                        performHidePassword();
                        return true;
                    }
                }
            }
            return false;
        }

    };









    private void performHidePassword() {
        this.setCompoundDrawablesWithIntrinsicBounds(0, 0, android.R.drawable.ic_secure, 0);
        this.setTransformationMethod(new PasswordTransformationMethod());
        this.setSelection(this.getText().length());
    }



    private void performShowPassword() {
        this.setCompoundDrawablesWithIntrinsicBounds(0, 0, android.R.drawable.ic_partial_secure, 0);
        this.setTransformationMethod(null);
        this.setSelection(this.getText().length());
    }


}
