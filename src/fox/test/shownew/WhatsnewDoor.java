package fox.test.shownew;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 主activity和动画activity在一起
 * @author liuxiuquan
 * 2014年6月30日
 */
public class WhatsnewDoor extends Activity {
	/**上半部分图片*/
	private ImageView mUp;
	/**下半部分图片*/
	private ImageView mDown;
	/**下部分的文字*/
	private TextView mText;
	/**中间的图片*/
	private ImageView mMiddle;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		mUp = (ImageView) findViewById(R.id.imageUp);
		mDown = (ImageView) findViewById(R.id.imageDown);
		mMiddle = (ImageView) findViewById(R.id.imageMiddle_door);
		mText = (TextView) findViewById(R.id.anim_text);
		// shareInterpolator=true,所有的Animation共用一个Interpolator
		AnimationSet anim = new AnimationSet(true);
		// 从中往上
		TranslateAnimation mytranslateanim = new TranslateAnimation(
				Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f,
				Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, -1f);
		// 动画时长
		mytranslateanim.setDuration(1400);
		// 启动延时 等文字上的效果消失后再启动
		anim.setStartOffset(800);
		// 绑定动画到组件上
		anim.addAnimation(mytranslateanim);
		anim.setFillAfter(true);
		mUp.startAnimation(anim);
		mMiddle.startAnimation(anim);
		AnimationSet anim1 = new AnimationSet(true);
		TranslateAnimation mytranslateanim1 = new TranslateAnimation(
				Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f,
				Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, +1f);
		mytranslateanim1.setDuration(1400);
		anim1.addAnimation(mytranslateanim1);
		anim1.setStartOffset(800);
		// 该方法用于设置一个动画效果执行完毕后，View对象保留在终止的位置。该方法的执行，需要首先通过setFillEnabled方法使能填充效果，否则设置无效。
		anim1.setFillAfter(true);
		mDown.startAnimation(anim1);

		AnimationSet anim2 = new AnimationSet(true);
		ScaleAnimation myscaleanim = new ScaleAnimation(1f, 3f, 1f, 3f,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
				0.5f);
		myscaleanim.setDuration(800);
		AlphaAnimation myalphaanim = new AlphaAnimation(1, 0.0001f);
		myalphaanim.setDuration(1000);
		anim2.addAnimation(myscaleanim);
		anim2.addAnimation(myalphaanim);
		anim2.setFillAfter(true);
		mText.startAnimation(anim2);

		// 设置延时 显示动画效果
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {

				// Intent intent = new Intent (WhatsnewDoor.this,Main.class);
				// startActivity(intent);
				// WhatsnewDoor.this.finish();
			}
		}, 1400);
	}

}
