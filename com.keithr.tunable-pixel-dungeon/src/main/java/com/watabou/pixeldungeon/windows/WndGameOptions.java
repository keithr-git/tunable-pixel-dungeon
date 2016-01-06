package com.watabou.pixeldungeon.windows;

import com.watabou.noosa.audio.Sample;
import com.watabou.pixeldungeon.Assets;
import com.watabou.pixeldungeon.PixelDungeon;
import com.watabou.pixeldungeon.ui.CheckBox;
import com.watabou.pixeldungeon.ui.Window;

/**
 * Created by keithr on 11/12/15.
 */
public class WndGameOptions extends Window {

	private static final String TXT_DISABLE_NIGHT_MODE     	= "Disable Night Mode";
	private static final String TXT_AUTO_IDENTIFY		= "Auto-Identify Items";
	private static final String TXT_KEEP_SAVE_FILES		= "Keep Save Files";
	private static final String TXT_GUARANTEED_BOSS_DROPS	= "Guaranteed Boss Drops";
	private static final String TXT_CHOOSE_ENCHANTMENTS	= "Choose Enchantments";
	private static final String TXT_KEEP_ENCHANTMENTS	= "Keep Enchantments";
	private static final String TXT_UPGRADE_SCROLLS		= "Random Upgrade Scrolls";

	private static final int WIDTH				= 112;
	private static final int BTN_HEIGHT			= 20;
	private static final int GAP 				= 2;

	public WndGameOptions() {
		final CheckBox btnNightMode = new CheckBox( TXT_DISABLE_NIGHT_MODE ) {
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

		final CheckBox btnAutoIdentify = new CheckBox( TXT_AUTO_IDENTIFY ) {
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

		final CheckBox btnKeepSaveFiles = new CheckBox( TXT_KEEP_SAVE_FILES ) {
			@Override
			protected void onClick() {
				super.onClick();
				PixelDungeon.keepSaveFiles( checked() );
				Sample.INSTANCE.play(Assets.SND_CLICK);
			}
		};
		btnKeepSaveFiles.setRect( 0, btnAutoIdentify.bottom() + GAP, WIDTH, BTN_HEIGHT );
		btnKeepSaveFiles.checked( PixelDungeon.keepSaveFiles() );
		add( btnKeepSaveFiles );

		final CheckBox btnGuaranteedBossDrops = new CheckBox( TXT_GUARANTEED_BOSS_DROPS ) {
			@Override
			protected void onClick() {
				super.onClick();
				PixelDungeon.guaranteedBossDrops( checked() );
				Sample.INSTANCE.play(Assets.SND_CLICK);
			}
		};
		btnGuaranteedBossDrops.setRect( 0, btnKeepSaveFiles.bottom() + GAP, WIDTH, BTN_HEIGHT );
		btnGuaranteedBossDrops.checked( PixelDungeon.guaranteedBossDrops() );
		add( btnGuaranteedBossDrops );

		final CheckBox btnChooseEnchantments = new CheckBox( TXT_CHOOSE_ENCHANTMENTS ) {
			@Override
			protected void onClick() {
				super.onClick();
				PixelDungeon.chooseEnchantments( checked() );
				Sample.INSTANCE.play(Assets.SND_CLICK);
			}
		};
		btnChooseEnchantments.setRect( 0, btnGuaranteedBossDrops.bottom() + GAP, WIDTH, BTN_HEIGHT );
		btnChooseEnchantments.checked( PixelDungeon.chooseEnchantments() );
		add( btnChooseEnchantments );

		final CheckBox btnKeepEnchantments = new CheckBox( TXT_KEEP_ENCHANTMENTS ) {
			@Override
			protected void onClick() {
				super.onClick();
				PixelDungeon.keepEnchantments( checked() );
				Sample.INSTANCE.play(Assets.SND_CLICK);
			}
		};
		btnKeepEnchantments.setRect( 0, btnChooseEnchantments.bottom() + GAP, WIDTH, BTN_HEIGHT );
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

		resize( WIDTH, (int) btnUpgradeScrolls.bottom() );
	}
}
