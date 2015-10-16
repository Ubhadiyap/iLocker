package com.qc4w.ilocker.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;

public class BitmapUtils {

	public static Bitmap getBitmap(int background, Bitmap contour) {
		return getBitmap(background, contour, 1f);
	}
	
	public static Bitmap getBitmap(Bitmap background, Bitmap contour) {
		return getBitmap(background, contour, 1f);
	}

	/**
	 * ��ȡ�������ü���ͼƬ
	 * @param background Ҫ�ü���ͼƬ
	 * @param contour Ҫ�ü��ɵ�����
	 * @return �ü���ɵ�ͼƬ
	 */
	public static Bitmap getBitmap(Bitmap background, Bitmap contour, float alpha) {
		Paint paint = new Paint();
		paint.setAntiAlias(true);
		paint.setColor(Color.WHITE);
		paint.setDither(false);
		Bitmap bitmap = Bitmap.createBitmap(contour.getWidth(), contour.getHeight(), Bitmap.Config.ARGB_8888);
		Canvas canvas = new Canvas(bitmap);
		Matrix m = new Matrix();
		m.setScale(contour.getWidth() * 1.0f / background.getWidth(), contour.getHeight() * 1.0f / background.getHeight());
		paint.setAlpha((int) (alpha * 0xff));
		canvas.drawBitmap(background, m, paint);
		paint.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
		paint.setAlpha(0xff);
		canvas.drawBitmap(contour, 0, 0, paint);
		return bitmap;
	}

	/**
	 * ������������ɫ
	 * @param background Ҫ���õ���ɫ
	 * @param contour Ҫ������ɫ������
	 * @return ���������ɫ������
	 */
	public static Bitmap getBitmap(int background, Bitmap contour, float alpha) {
		Bitmap bitmap = Bitmap.createBitmap(contour.getWidth(), contour.getHeight(), Bitmap.Config.ARGB_8888);
		Canvas canvas = new Canvas(bitmap);
		canvas.drawColor(background);
		return getBitmap(bitmap, contour, alpha);
	}

}
