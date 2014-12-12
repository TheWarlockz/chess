package com.example.chess;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class ChessView extends View {
	
	private int[][] board;
	private boolean selected;
	private int size;
	private Paint black,white;
	private RectF bounding_box;
	
	public ChessView(Context c) {
		super(c);
		init();
	}
	
	public ChessView(Context c,AttributeSet as) {
		super(c,as);
		init();
	}
	
	public ChessView(Context c, AttributeSet as, int default_style) {
		super(c, as, default_style);
		init();
	}
	
	public void init() {
		board = new int[8][8];
		black = new Paint(Paint.ANTI_ALIAS_FLAG);
		black.setColor(0xFF444444);
		white = new Paint(Paint.ANTI_ALIAS_FLAG);
		white.setColor(0x00FFFFFF);
		
		bounding_box = new RectF();
		
	}
	
	public void onDraw(Canvas canvas) {
		Paint activeColor;
		if(canvas.getHeight() <= canvas.getWidth()) {
			size = canvas.getHeight()/8;
		}
		else {
			size = canvas.getWidth()/8;
		}
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++){
				bounding_box.top = i*size;
				bounding_box.left = j*size;
				bounding_box.bottom = (i+1) * size;
				bounding_box.right = (j+1) * size;
				if(i%2 == 0) {
					if(j%2 == 0) {
						activeColor = white;
					}
					else {
						activeColor = black;
			
					 }
				}
				else {
					if(j%2 == 0) {
						activeColor = black;
					}
					else {
						activeColor = white;
					}
				}
				canvas.drawRect(bounding_box, activeColor);
			}
			canvas.drawLine(0, 0, 0, 8*size, black);
			canvas.drawLine(0, 0, 8*size, 0, black);
			canvas.drawLine(8*size, 0, 8*size, 8*size, black);
			canvas.drawLine(0, 8*size, 8*size, 8*size, black);
		}
		
	}
	}
