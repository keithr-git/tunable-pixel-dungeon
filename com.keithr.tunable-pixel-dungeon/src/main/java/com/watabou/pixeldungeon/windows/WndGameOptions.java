package com.watabou.pixeldungeon.windows;

import com.watabou.pixeldungeon.PixelDungeon;
import com.watabou.pixeldungeon.ui.CheckBox;
import com.watabou.pixeldungeon.ui.RedButton;
import com.watabou.pixeldungeon.ui.Window;

/**
 * Created by keithr on 11/12/15.
 */
public class WndGameOptions extends Window {

	private static final String TXT_NIGHT_MODE		= "Night Mode: ";
	private static final String TXT_NIGHT_MODE_TITLE	= "Game is in night mode:";
	private static final String TXT_AUTO_IDENTIFY		= "Auto-Identify Items";
	private static final String TXT_KEEP_SAVE_FILES		= "Keep Save Files";
	private static final String TXT_GUARANTEED_BOSS_DROPS	= "Guaranteed Boss Drops";
	private static final String TXT_CHOOSE_ENCHANTMENTS	= "Choose Enchantments";
	private static final String TXT_KEEP_ENCHANTMENTS	= "Keep Enchantments";
	private static final String TXT_UPGRADE_SCROLLS		= "Random Upgrade Scrolls";
	private static final String TXT_KEYRING_COLLECTS_RINGS	= "Keyring Collects Rings";

	private static final int WIDTH				= 112;
	private static final int BTN_HEIGHT			= 20;
	private static final int GAP 				= 2;

	private final RedButton btnNightMode;

	public WndGameOptions() {
		btnNightMode = new RedButton( TXT_NIGHT_MODE + PixelDungeon.nightMode()) {
			@Override
			protected void onClick() {
				super.onClick();

				parent.add( new WndOptions( null, TXT_NIGHT_MODE_TITLE, PixelDungeon.VALUE_NIGHT_NEVER, PixelDungeon.VALUE_NIGHT_NORMAL, PixelDungeon.VALUE_NIGHT_ALWAYS ) {
					@Override
					protected void onSelect(int index) {
						switch (index) {
							case 0:
								PixelDungeon.nightMode( PixelDungeon.VALUE_NIGHT_NEVER );
								break;
							case 1:
								PixelDungeon.nightMode( PixelDungeon.VALUE_NIGHT_NORMAL );
								break;
							case 2:
								PixelDungeon.nightMode( PixelDungeon.VALUE_NIGHT_ALWAYS );
								break;
						}

						btnNightMode.text( TXT_NIGHT_MODE + PixelDungeon.nightMode() );
					}
				} );
			}
		};
		btnNightMode.setRect( 0, 0, WIDTH, BTN_HEIGHT );
		add( btnNightMode );

		final CheckBox btnAutoIdentify = new CheckBox( TXT_AUTO_IDENTIFY ) {
			@Override
			protected void onClick() {
				super.onClick();
				PixelDungeon.autoIdentify( checked() );
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
			}
		};
		btnUpgradeScrolls.setRect( 0, btnKeepEnchantments.bottom() + GAP, WIDTH, BTN_HEIGHT );
		btnUpgradeScrolls.checked( PixelDungeon.upgradeScrolls() );
		add( btnUpgradeScrolls );

		final CheckBox btnKeyringCollectsRings = new CheckBox( TXT_KEYRING_COLLECTS_RINGS ) {
			@Override
			protected void onClick() {
				super.onClick();
				PixelDungeon.keyringCollectsRings( checked() );
			}
		};
		btnKeyringCollectsRings.setRect( 0, btnUpgradeScrolls.bottom() + GAP, WIDTH, BTN_HEIGHT );
		btnKeyringCollectsRings.checked( PixelDungeon.keyringCollectsRings() );
		add( btnKeyringCollectsRings );

		resize( WIDTH, (int) btnKeyringCollectsRings.bottom() );
	}
}
