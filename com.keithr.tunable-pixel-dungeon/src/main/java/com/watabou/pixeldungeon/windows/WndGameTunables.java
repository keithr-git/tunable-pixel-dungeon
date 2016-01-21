package com.watabou.pixeldungeon.windows;

import com.watabou.noosa.BitmapTextMultiline;
import com.watabou.pixeldungeon.PixelDungeon;
import com.watabou.pixeldungeon.scenes.PixelScene;
import com.watabou.pixeldungeon.ui.RedButton;
import com.watabou.pixeldungeon.ui.Window;

/**
 * Created by keithr on 11/13/15.
 */
public class WndGameTunables extends Window {
	private static final String TXT_HEALING_RATE		= "Healing Rate:     ";
	private static final String TXT_HUNGER_RATE		= "Hunger Rate:     ";
	private static final String TXT_DEGRADATION_RATE	= "Degradation Rate:";
	private static final String TXT_TREASURE_AMOUNT		= "Treasure Amount: ";

	private static final String TXT_RESET_DEFAULTS		= "Press middle button to reset to 1.0.";

	private static final int WIDTH				= 112;
	private static final int BTN_HEIGHT			= 20;
	private static final int GAP 				= 2;
	private static final int MARGIN				= 2;

	private class FloatValue {
		RedButton btnMinus;
		RedButton btnLabel;
		String prefix;

		public FloatValue( Window parent, float offset, String prefix_) {
			int w = (int) (BTN_HEIGHT * 0.6);

			prefix = prefix_;

			btnMinus = new RedButton( "-" ) {
				@Override
				protected void onClick() {
					float value = getValue();

					value -= 0.1;
					updateValue( value );
				}
			};
			add( btnMinus.setRect( 0, offset, w, BTN_HEIGHT ) );

			final RedButton btnPlus = new RedButton( "+" ) {
				@Override
				protected void onClick() {
					float value = getValue();

					value += 0.1;
					updateValue( value );
				}
			};
			add( btnPlus.setRect( WIDTH - w, offset, w, BTN_HEIGHT ) );

			btnLabel = new RedButton( prefix ) {
				@Override
				protected void onClick() {
					updateValue( 1.0F );
				}
			};
			add ( btnLabel.setRect( btnMinus.right(), offset, WIDTH - btnPlus.width() - btnMinus.width(), BTN_HEIGHT ) );
			updateValue( getValue() );
		}

		void updateValue(float value) {
			if (value < 0.09) {
				btnMinus.enable( false );
				value = 0.0F;
			} else {
				btnMinus.enable( true );
			}

			setValue( value );
			btnLabel.text( prefix + String.format( " %4.1f", value ) );
		}

		void updateValue() {
			updateValue( getValue() );
		}

		float getValue() {
			return 1.0F;
		}

		void setValue( float value ) { }

		float bottom() {
			return btnLabel.bottom();
		}
	}

	public WndGameTunables () {
		BitmapTextMultiline tfReset = PixelScene.createMultiline( TXT_RESET_DEFAULTS, 6 );
		tfReset.hardlight( TITLE_COLOR );
		tfReset.maxWidth = WIDTH - MARGIN;
		tfReset.measure();
		tfReset.x = MARGIN;
		tfReset.y = GAP;
		add(tfReset);

		final FloatValue btnHealingRate = new FloatValue( this, tfReset.y + tfReset.height() + GAP, TXT_HEALING_RATE ) {
			@Override
			float getValue() {
				return PixelDungeon.healingRate();
			}

			@Override
			void setValue( float value ) {
				PixelDungeon.healingRate( value );
			}
		};

		final FloatValue btnHungerRate = new FloatValue( this, btnHealingRate.bottom() + GAP, TXT_HUNGER_RATE ) {
			@Override
			float getValue() {
				return PixelDungeon.hungerRate();
			}

			@Override
			void setValue( float value ) {
				PixelDungeon.hungerRate( value );
			}
		};

		final FloatValue btnUseRate = new FloatValue( this, btnHungerRate.bottom() + GAP, TXT_DEGRADATION_RATE ) {
			@Override
			float getValue() {
				return PixelDungeon.degradationRate();
			}

			@Override
			void setValue( float value ) {
				PixelDungeon.degradationRate( value );
			}
		};


		final FloatValue btnTreasureAmount = new FloatValue( this, btnUseRate.bottom() + GAP, TXT_TREASURE_AMOUNT ) {
			@Override
			float getValue() {
				return PixelDungeon.treasureAmount();
			}

			@Override
			void setValue( float value ) {
				PixelDungeon.treasureAmount( value );
			}
		};

		resize( WIDTH, (int) btnTreasureAmount.bottom() );
	}
}
