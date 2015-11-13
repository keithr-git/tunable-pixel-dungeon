/*
 * Pixel Dungeon
 * Copyright (C) 2012-2015 Oleg Dolya
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */
package com.watabou.pixeldungeon.windows;

import com.watabou.noosa.Camera;
import com.watabou.noosa.audio.Sample;
import com.watabou.pixeldungeon.Assets;
import com.watabou.pixeldungeon.PixelDungeon;
import com.watabou.pixeldungeon.scenes.PixelScene;
import com.watabou.pixeldungeon.ui.CheckBox;
import com.watabou.pixeldungeon.ui.RedButton;
import com.watabou.pixeldungeon.ui.Toolbar;
import com.watabou.pixeldungeon.ui.Window;

public class WndSettings extends Window {
	
	private static final String TXT_ZOOM_IN			= "+";
	private static final String TXT_ZOOM_OUT		= "-";
	private static final String TXT_ZOOM_DEFAULT	= "Default Zoom";

	private static final String TXT_SCALE_UP		= "Scale up UI";
	private static final String TXT_IMMERSIVE		= "Immersive mode";
	
	private static final String TXT_MUSIC	= "Music";
	
	private static final String TXT_SOUND	= "Sound FX";
	
	private static final String TXT_BRIGHTNESS	= "Brightness";
	
	private static final String TXT_QUICKSLOT	= "Second quickslot";
	
	private static final String TXT_SWITCH_PORT	= "Switch to portrait";
	private static final String TXT_SWITCH_LAND	= "Switch to landscape";

	private static final String TXT_START_WITH	= "Start Game With ...";
	private static final String TXT_GAME_OPTIONS	= "Game Options ...";

	private static final int WIDTH		= 112;
	private static final int BTN_HEIGHT	= 20;
	private static final int GAP 		= 2;

	private RedButton btnZoomOut;
	private RedButton btnZoomIn;
	
	public WndSettings( boolean inGame ) {
		super();
		
		CheckBox btnImmersive = null;
		float nextButtonPosition;
		
		if (inGame) {
			int w = BTN_HEIGHT;
			
			btnZoomOut = new RedButton( TXT_ZOOM_OUT ) {
				@Override
				protected void onClick() {
					zoom( Camera.main.zoom - 1 );
				}
			};
			add( btnZoomOut.setRect( 0, 0, w, BTN_HEIGHT) );
			
			btnZoomIn = new RedButton( TXT_ZOOM_IN ) {
				@Override
				protected void onClick() {
					zoom( Camera.main.zoom + 1 );
				}
			};
			add( btnZoomIn.setRect( WIDTH - w, 0, w, BTN_HEIGHT) );
			
			add( new RedButton( TXT_ZOOM_DEFAULT ) {
				@Override
				protected void onClick() {
					zoom( PixelScene.defaultZoom );
				}
			}.setRect( btnZoomOut.right(), 0, WIDTH - btnZoomIn.width() - btnZoomOut.width(), BTN_HEIGHT ) );
			nextButtonPosition = btnZoomIn.bottom() + GAP;
			
			updateEnabled();
			
		} else {
			
			CheckBox btnScaleUp = new CheckBox( TXT_SCALE_UP ) {
				@Override
				protected void onClick() {
					super.onClick();
					PixelDungeon.scaleUp( checked() );
				}
			};
			btnScaleUp.setRect( 0, 0, WIDTH, BTN_HEIGHT );
			btnScaleUp.checked( PixelDungeon.scaleUp() );
			add( btnScaleUp );
			
			btnImmersive = new CheckBox( TXT_IMMERSIVE ) {
				@Override
				protected void onClick() {
					super.onClick();
					PixelDungeon.immerse( checked() );
				}
			};
			btnImmersive.setRect( 0, btnScaleUp.bottom() + GAP, WIDTH, BTN_HEIGHT );
			btnImmersive.checked( PixelDungeon.immersed() );
			btnImmersive.enable( android.os.Build.VERSION.SDK_INT >= 19 );
			add( btnImmersive );

			nextButtonPosition = btnImmersive.bottom() + GAP;
		}
		
		CheckBox btnMusic = new CheckBox( TXT_MUSIC ) {
			@Override
			protected void onClick() {
				super.onClick();
				PixelDungeon.music( checked() );
			}
		};
		btnMusic.setRect( 0, nextButtonPosition, WIDTH, BTN_HEIGHT );
		btnMusic.checked( PixelDungeon.music() );
		add( btnMusic );
		
		CheckBox btnSound = new CheckBox( TXT_SOUND ) {
			@Override
			protected void onClick() {
				super.onClick();
				PixelDungeon.soundFx( checked() );
				Sample.INSTANCE.play( Assets.SND_CLICK );
			}
		};
		btnSound.setRect( 0, btnMusic.bottom() + GAP, WIDTH, BTN_HEIGHT );
		btnSound.checked( PixelDungeon.soundFx() );
		add( btnSound );
		
		if (inGame) {
			
			CheckBox btnBrightness = new CheckBox( TXT_BRIGHTNESS ) {
				@Override
				protected void onClick() {
					super.onClick();
					PixelDungeon.brightness( checked() );
				}
			};
			btnBrightness.setRect( 0, btnSound.bottom() + GAP, WIDTH, BTN_HEIGHT );
			btnBrightness.checked( PixelDungeon.brightness() );
			add( btnBrightness );
			
			CheckBox btnQuickslot = new CheckBox( TXT_QUICKSLOT ) {
				@Override
				protected void onClick() {
					super.onClick();
					Toolbar.secondQuickslot( checked() );
				}
			};
			btnQuickslot.setRect( 0, btnBrightness.bottom() + GAP, WIDTH, BTN_HEIGHT );
			btnQuickslot.checked( Toolbar.secondQuickslot() );
			add( btnQuickslot );
			
			resize( WIDTH, (int)btnQuickslot.bottom() );
			nextButtonPosition = btnQuickslot.bottom() + GAP;
		} else {

			RedButton btnOrientation = new RedButton( orientationText() ) {
				@Override
				protected void onClick() {
					PixelDungeon.landscape( !PixelDungeon.landscape() );
				}
			};
			btnOrientation.setRect( 0, btnSound.bottom() + GAP, WIDTH, BTN_HEIGHT );
			add( btnOrientation );

			RedButton btnStartWith = new RedButton( TXT_START_WITH ) {
				@Override
				protected void onClick() {
					parent.add( new WndStartWith() );
				}
			};
			btnStartWith.setRect( 0, btnOrientation.bottom() + GAP, WIDTH, BTN_HEIGHT );
			add( btnStartWith );

			nextButtonPosition = btnStartWith.bottom() + GAP;
		}

		RedButton btnGameOptions = new RedButton( TXT_GAME_OPTIONS ) {
			@Override
			protected void onClick() {
				parent.add( new WndGameOptions() );
			}
		};
		btnGameOptions.setRect( 0, nextButtonPosition, WIDTH, BTN_HEIGHT );
		add( btnGameOptions );

		resize( WIDTH, (int) btnGameOptions.bottom() );
	}
	
	private void zoom( float value ) {

		Camera.main.zoom( value );
		PixelDungeon.zoom( (int)(value - PixelScene.defaultZoom) );

		updateEnabled();
	}
	
	private void updateEnabled() {
		float zoom = Camera.main.zoom;
		btnZoomIn.enable( zoom < PixelScene.maxZoom );
		btnZoomOut.enable( zoom > PixelScene.minZoom );
	}
	
	private String orientationText() {
		return PixelDungeon.landscape() ? TXT_SWITCH_PORT : TXT_SWITCH_LAND;
	}
}
