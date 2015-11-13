package com.watabou.pixeldungeon.windows;

import com.watabou.noosa.audio.Sample;
import com.watabou.pixeldungeon.Assets;
import com.watabou.pixeldungeon.PixelDungeon;
import com.watabou.pixeldungeon.ui.CheckBox;
import com.watabou.pixeldungeon.ui.Window;

/**
 * Created by keithr on 11/13/15.
 */
public class WndStartWith extends Window {
	private static final String TXT_SEED_POUCH	= "Seed Pouch";
	private static final String TXT_SCROLL_HOLDER	= "Scroll Holder";
	private static final String TXT_WAND_HOLSTER	= "Wand Holster";

	private static final int WIDTH		= 112;
	private static final int BTN_HEIGHT	= 20;
	private static final int GAP 		= 2;

	public WndStartWith() {
		final CheckBox btnFreeSeedPouch = new CheckBox( TXT_SEED_POUCH ) {
			@Override
			protected void onClick() {
				super.onClick();
				PixelDungeon.freeSeedPouch( checked() );
				Sample.INSTANCE.play(Assets.SND_CLICK);
			}
		};
		btnFreeSeedPouch.setRect( 0, 0, WIDTH, BTN_HEIGHT );
		btnFreeSeedPouch.checked( PixelDungeon.freeSeedPouch() );
		add( btnFreeSeedPouch );

		final CheckBox btnFreeScrollHolder = new CheckBox( TXT_SCROLL_HOLDER ) {
			@Override
			protected void onClick() {
				super.onClick();
				PixelDungeon.freeScrollHolder( checked() );
				Sample.INSTANCE.play( Assets.SND_CLICK);
			}
		};
		btnFreeScrollHolder.setRect( 0, btnFreeSeedPouch.bottom() + GAP, WIDTH, BTN_HEIGHT );
		btnFreeScrollHolder.checked( PixelDungeon.freeScrollHolder() );
		add( btnFreeScrollHolder );

		final CheckBox btnFreeWandHolster = new CheckBox( TXT_WAND_HOLSTER ) {
			@Override
			protected void onClick() {
				super.onClick();
				PixelDungeon.freeWandHolster( checked() );
				Sample.INSTANCE.play( Assets.SND_CLICK);
			}
		};
		btnFreeWandHolster.setRect( 0, btnFreeScrollHolder.bottom() + GAP, WIDTH, BTN_HEIGHT );
		btnFreeWandHolster.checked( PixelDungeon.freeWandHolster() );
		add( btnFreeWandHolster );

		resize( WIDTH, (int) btnFreeWandHolster.bottom() );
	}
}