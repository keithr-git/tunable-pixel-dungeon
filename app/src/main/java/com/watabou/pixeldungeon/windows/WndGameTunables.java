package com.watabou.pixeldungeon.windows;

import com.watabou.pixeldungeon.PixelDungeon;
import com.watabou.pixeldungeon.ui.RedButton;
import com.watabou.pixeldungeon.ui.Window;

/**
 * Created by keithr on 11/13/15.
 */
public class WndGameTunables extends Window {
	private static final String TXT_HUNGER_RATE		= "Hunger Rate:     ";
	private static final String TXT_DEGRADATION_RATE	= "Degradation Rate:";
	private static final String TXT_TREASURE_AMOUNT		= "Treasure Amount: ";

	private static final String TXT_RESET_DEFAULTS		= "Reset to Defaults";

	private static final int WIDTH				= 112;
	private static final int BTN_HEIGHT			= 20;
	private static final int GAP 				= 2;

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
					updateLabel( value );
				}
			};
			add( btnMinus.setRect( 0, offset, w, BTN_HEIGHT ) );

			final RedButton btnPlus = new RedButton( "+" ) {
				@Override
				protected void onClick() {
					float value = getValue();

					value += 0.1;
					updateLabel( value );
				}
			};
			add( btnPlus.setRect( WIDTH - w, offset, w, BTN_HEIGHT ) );

			btnLabel = new RedButton( prefix );
			add ( btnLabel.setRect( btnMinus.right(), offset, WIDTH - btnPlus.width() - btnMinus.width(), BTN_HEIGHT ) );
			updateLabel( getValue() );
		}

		void updateLabel(float value) {
			if (value < 0.09) {
				btnMinus.enable( false );
				value = 0.0F;
			} else {
				btnMinus.enable( true );
			}

			setValue( value );
			btnLabel.text( prefix + String.format( " %4.1f", value ) );
		}

		void updateLabel() {
			updateLabel( getValue() );
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
		final FloatValue btnHungerRate = new FloatValue( this, 0, TXT_HUNGER_RATE ) {
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

		RedButton btnResetToDefaults = new RedButton( TXT_RESET_DEFAULTS ) {
			@Override
			protected void onClick() {
				PixelDungeon.hungerRate( 1.0F );
				PixelDungeon.degradationRate( 1.0F );
				PixelDungeon.treasureAmount( 1.0F );

				btnHungerRate.updateLabel();
				btnUseRate.updateLabel();
				btnTreasureAmount.updateLabel();
			}
		};
		btnResetToDefaults.setRect( 0, btnTreasureAmount.bottom() + GAP, WIDTH, BTN_HEIGHT );
		add( btnResetToDefaults );

		resize( WIDTH, (int) btnResetToDefaults.bottom() );
	}
}
