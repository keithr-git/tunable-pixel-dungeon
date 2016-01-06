package com.watabou.pixeldungeon.windows;

import com.watabou.noosa.BitmapText;
import com.watabou.noosa.BitmapTextMultiline;
import com.watabou.noosa.ui.Component;
import com.watabou.pixeldungeon.PixelDungeon;
import com.watabou.pixeldungeon.scenes.PixelScene;
import com.watabou.pixeldungeon.ui.GameLog;
import com.watabou.pixeldungeon.ui.ScrollPane;
import com.watabou.pixeldungeon.ui.Window;

/**
 * Created by keithr on 1/4/16.
 */
public class WndLog extends Window {

	private static final int WIDTH_P	= 116;
	private static final int WIDTH_L	= 224;
	private static final int HEIGHT_P	= 220;
	private static final int HEIGHT_L	= 164;

	private static final int ITEM_HEIGHT	= 18;

	private static final String TXT_TITLE	= "Log";

	public WndLog() {
		super();

		if (PixelDungeon.landscape()) {
			resize( WIDTH_L, HEIGHT_L );
		} else {
			resize( WIDTH_P, HEIGHT_P );
		}

		BitmapText txtTitle = PixelScene.createText( TXT_TITLE, 9 );
		txtTitle.hardlight( Window.TITLE_COLOR );
		txtTitle.measure();
		txtTitle.x = PixelScene.align( PixelScene.uiCamera, (width - txtTitle.width()) / 2 );
		add( txtTitle );

		Component content = new Component();

		float pos = 0;
		for (BitmapTextMultiline entry: GameLog.LogEntries()) {
			entry.maxWidth = (int)width;
			entry.measure();
			entry.x = 0;
			entry.y = pos;
			content.add(entry);
			pos += entry.height();
		}

		content.setSize( width, pos );

		ScrollPane list = new ScrollPane( content );
		add( list );

		list.setRect( 0, txtTitle.height(), width, height - txtTitle.height() );
		if (content.height() > list.height()) {
			list.scrollTo( 0, content.height() - list.height() );
		}
	}
}
