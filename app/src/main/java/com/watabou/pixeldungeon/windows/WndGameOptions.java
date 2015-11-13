package com.watabou.pixeldungeon.windows;

import com.watabou.noosa.audio.Sample;
import com.watabou.pixeldungeon.Assets;
import com.watabou.pixeldungeon.PixelDungeon;
import com.watabou.pixeldungeon.ui.CheckBox;
import com.watabou.pixeldungeon.ui.RedButton;
import com.watabou.pixeldungeon.ui.Window;

/**
 * Created by keithr on 11/12/15.
 */
public class WndGameOptions extends Window {

	private static final String TXT_NIGHT_MODE      = "Disable Night Mode";
	private static final String TXT_AUTO_IDENT      = "Auto-Identify Items";
	private static final String TXT_KEEP_ENCHANTMENT = "Keep Enchantments";
	private static final String TXT_UPGRADE_SCROLLS	= "Random Upgrade Scrolls";

	private static final String TXT_RESET_DEFAULTS	= "Reset to Defaults";

	private static final int WIDTH		= 112;
	private static final int BTN_HEIGHT	= 20;
	private static final int GAP 		= 2;

	public WndGameOptions() {

		final CheckBox btnNightMode = new CheckBox( TXT_NIGHT_MODE ) {
			@Override
			protected void onClick() {
				super.onClick();
				PixelDungeon.nightModeDisabled( checked() );
				Sample.INSTANCE.play( Assets.SND_CLICK );
			}
		};
		btnNightMode.setRect( 0, 0, WIDTH, BTN_HEIGHT );
		btnNightMode.checked( PixelDungeon.nightModeDisabled() );
		add( btnNightMode );

		final CheckBox btnAutoIdentify = new CheckBox( TXT_AUTO_IDENT ) {
			@Override
			protected void onClick() {
				super.onClick();
				PixelDungeon.autoIdentify( checked() );
				Sample.INSTANCE.play(Assets.SND_CLICK);
			}
		};
		btnAutoIdentify.setRect( 0, btnNightMode.bottom() + GAP, WIDTH, BTN_HEIGHT );
		btnAutoIdentify.checked( PixelDungeon.autoIdentify() );
		add( btnAutoIdentify );

		final CheckBox btnKeepEnchantments = new CheckBox( TXT_KEEP_ENCHANTMENT ) {
			@Override
			protected void onClick() {
				super.onClick();
				PixelDungeon.keepEnchantments( checked() );
				Sample.INSTANCE.play(Assets.SND_CLICK);
			}
		};
		btnKeepEnchantments.setRect( 0, btnAutoIdentify.bottom() + GAP, WIDTH, BTN_HEIGHT );
		btnKeepEnchantments.checked( PixelDungeon.keepEnchantments() );
		add( btnKeepEnchantments );

		final CheckBox btnUpgradeScrolls = new CheckBox( TXT_UPGRADE_SCROLLS ) {
			@Override
			protected void onClick() {
				super.onClick();
				PixelDungeon.upgradeScrolls( checked() );
				Sample.INSTANCE.play(Assets.SND_CLICK);
			}
		};
		btnUpgradeScrolls.setRect( 0, btnKeepEnchantments.bottom() + GAP, WIDTH, BTN_HEIGHT );
		btnUpgradeScrolls.checked( PixelDungeon.upgradeScrolls() );
		add( btnUpgradeScrolls );

		RedButton btnResetToDefaults = new RedButton( TXT_RESET_DEFAULTS ) {
			@Override
			protected void onClick() {
				PixelDungeon.nightModeDisabled( false );
				PixelDungeon.autoIdentify( false );
				PixelDungeon.keepEnchantments( false );
				PixelDungeon.upgradeScrolls( false );
				btnNightMode.checked( PixelDungeon.nightModeDisabled() );
				btnAutoIdentify.checked( PixelDungeon.autoIdentify() );
				btnKeepEnchantments.checked( PixelDungeon.keepEnchantments() );
				btnUpgradeScrolls.checked( PixelDungeon.upgradeScrolls() );
			}
		};
		btnResetToDefaults.setRect( 0, btnUpgradeScrolls.bottom() + GAP, WIDTH, BTN_HEIGHT );
		add( btnResetToDefaults );

		resize( WIDTH, (int) btnResetToDefaults.bottom() );
	}
}