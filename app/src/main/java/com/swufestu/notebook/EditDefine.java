package com.swufestu.notebook;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class EditDefine extends androidx.appcompat.widget.AppCompatEditText {
    private Paint paint;

    private float margin;

    private String color;

    //上下左右的padding
    private int top;
    //视图高度
    private int height;
    //总行数
    private int lineCount;
    //行高
    private int lineHeight;
    private int baseLine;
    //输入的行数
    private int editCount;
    private Rect rect;

    public EditDefine(@NonNull Context context) {
        super(context);
        init();
    }

    public EditDefine(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public EditDefine(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    public void setLineColor(int color){
        paint.setColor(color);
    }

    public void init(){
        this.paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.GRAY);
        paint.setAntiAlias(true);
        rect = new Rect();
        this.setLineSpacing(2.0f, 1.5f);
    }
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
//		canvas.drawColor(Color.BLACK);
        //组件高度
        height =this.getHeight();
        //行高
        lineHeight = this.getLineHeight();
        //总行数
        lineCount = 1 + height/lineHeight;
        //输入行书
        editCount = this.getLineCount();
        lineCount = lineCount > editCount ? lineCount : editCount;
        //输入行数
        top = getCompoundPaddingTop();
        canvas.save();
        int i = 1;
        for(; i <= lineCount; i++){
            canvas.drawLine(5, lineHeight * i, getRight() - 5 , lineHeight * i, paint);
        }
        canvas.restore();
        super.onDraw(canvas);
    }
}
