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
package com.watabou.pixeldungeon;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

import com.watabou.noosa.Game;
import com.watabou.noosa.audio.Music;
import com.watabou.noosa.audio.Sample;
import com.watabou.pixeldungeon.scenes.GameScene;
import com.watabou.pixeldungeon.scenes.PixelScene;
import com.watabou.pixeldungeon.scenes.TitleScene;

import javax.microedition.khronos.opengles.GL10;

public class PixelDungeon extends Game {
	
	public PixelDungeon() {
		super( TitleScene.class );
		
		com.watabou.utils.Bundle.addAlias( 
			com.watabou.pixeldungeon.items.scrolls.ScrollOfUpgrade.class, 
			"com.watabou.pixeldungeon.items.scrolls.ScrollOfEnhancement" );
		com.watabou.utils.Bundle.addAlias( 
			com.watabou.pixeldungeon.actors.blobs.WaterOfHealth.class, 
			"com.watabou.pixeldungeon.actors.blobs.Light" );
		com.watabou.utils.Bundle.addAlias( 
			com.watabou.pixeldungeon.items.rings.RingOfMending.class, 
			"com.watabou.pixeldungeon.items.rings.RingOfRejuvenation" );
		com.watabou.utils.Bundle.addAlias( 
			com.watabou.pixeldungeon.items.wands.WandOfReach.class, 
			"com.watabou.pixeldungeon.items.wands.WandOfTelekenesis" );
		com.watabou.utils.Bundle.addAlias( 
			com.watabou.pixeldungeon.actors.blobs.Foliage.class, 
			"com.watabou.pixeldungeon.actors.blobs.Blooming" );
		com.watabou.utils.Bundle.addAlias( 
			com.watabou.pixeldungeon.actors.buffs.Shadows.class, 
			"com.watabou.pixeldungeon.actors.buffs.Rejuvenation" );
		com.watabou.utils.Bundle.addAlias( 
			com.watabou.pixeldungeon.items.scrolls.ScrollOfPsionicBlast.class, 
			"com.watabou.pixeldungeon.items.scrolls.ScrollOfNuclearBlast" );
		com.watabou.utils.Bundle.addAlias( 
			com.watabou.pixeldungeon.actors.hero.Hero.class, 
			"com.watabou.pixeldungeon.actors.Hero" );
		com.watabou.utils.Bundle.addAlias( 
			com.watabou.pixeldungeon.actors.mobs.npcs.Shopkeeper.class,
			"com.watabou.pixeldungeon.actors.mobs.Shopkeeper" );
		// 1.6.1
		com.watabou.utils.Bundle.addAlias( 
			com.watabou.pixeldungeon.items.quest.DriedRose.class,
			"com.watabou.pixeldungeon.items.DriedRose" );
		com.watabou.utils.Bundle.addAlias( 
			com.watabou.pixeldungeon.actors.mobs.npcs.MirrorImage.class,
			"com.watabou.pixeldungeon.items.scrolls.ScrollOfMirrorImage$MirrorImage" );
		// 1.6.4
		com.watabou.utils.Bundle.addAlias( 
			com.watabou.pixeldungeon.items.rings.RingOfElements.class,
			"com.watabou.pixeldungeon.items.rings.RingOfCleansing" );
		com.watabou.utils.Bundle.addAlias( 
			com.watabou.pixeldungeon.items.rings.RingOfElements.class,
			"com.watabou.pixeldungeon.items.rings.RingOfResistance" );
		com.watabou.utils.Bundle.addAlias( 
			com.watabou.pixeldungeon.items.weapon.missiles.Boomerang.class,
			"com.watabou.pixeldungeon.items.weapon.missiles.RangersBoomerang" );
		com.watabou.utils.Bundle.addAlias( 
			com.watabou.pixeldungeon.items.rings.RingOfPower.class,
			"com.watabou.pixeldungeon.items.rings.RingOfEnergy" );
		// 1.7.2
		com.watabou.utils.Bundle.addAlias( 
			com.watabou.pixeldungeon.plants.Dreamweed.class,
			"com.watabou.pixeldungeon.plants.Blindweed" );
		com.watabou.utils.Bundle.addAlias( 
			com.watabou.pixeldungeon.plants.Dreamweed.Seed.class,
			"com.watabou.pixeldungeon.plants.Blindweed$Seed" );
		// 1.7.4
		com.watabou.utils.Bundle.addAlias( 
			com.watabou.pixeldungeon.items.weapon.enchantments.Shock.class,
			"com.watabou.pixeldungeon.items.weapon.enchantments.Piercing" );
		com.watabou.utils.Bundle.addAlias( 
			com.watabou.pixeldungeon.items.weapon.enchantments.Shock.class,
			"com.watabou.pixeldungeon.items.weapon.enchantments.Swing" );
		com.watabou.utils.Bundle.addAlias( 
			com.watabou.pixeldungeon.items.scrolls.ScrollOfEnchantment.class,
			"com.watabou.pixeldungeon.items.scrolls.ScrollOfWeaponUpgrade" );
		// 1.7.5
		com.watabou.utils.Bundle.addAlias( 
			com.watabou.pixeldungeon.items.scrolls.ScrollOfEnchantment.class,
			"com.watabou.pixeldungeon.items.Stylus" );
		// 1.8.0
		com.watabou.utils.Bundle.addAlias( 
			com.watabou.pixeldungeon.actors.mobs.FetidRat.class,
			"com.watabou.pixeldungeon.actors.mobs.npcs.Ghost$FetidRat" );
		com.watabou.utils.Bundle.addAlias( 
			com.watabou.pixeldungeon.plants.Rotberry.class,
			"com.watabou.pixeldungeon.actors.mobs.npcs.Wandmaker$Rotberry" );
		com.watabou.utils.Bundle.addAlias( 
			com.watabou.pixeldungeon.plants.Rotberry.Seed.class,
			"com.watabou.pixeldungeon.actors.mobs.npcs.Wandmaker$Rotberry$Seed" );
		// 1.9.0
		com.watabou.utils.Bundle.addAlias( 
			com.watabou.pixeldungeon.items.wands.WandOfReach.class,
			"com.watabou.pixeldungeon.items.wands.WandOfTelekinesis" );
	}
	
	@Override
	protected void onCreate( Bundle savedInstanceState ) {
		super.onCreate( savedInstanceState );
		
		updateImmersiveMode();
		
		DisplayMetrics metrics = new DisplayMetrics();
		instance.getWindowManager().getDefaultDisplay().getMetrics( metrics );
		boolean landscape = metrics.widthPixels > metrics.heightPixels;
		
		if (Preferences.INSTANCE.getBoolean( Preferences.KEY_LANDSCAPE, false ) != landscape) {
			landscape( !landscape );
		}
		
		Music.INSTANCE.enable( music() );
		Sample.INSTANCE.enable( soundFx() );
		
		Sample.INSTANCE.load( 
			Assets.SND_CLICK, 
			Assets.SND_BADGE, 
			Assets.SND_GOLD,
			
			Assets.SND_DESCEND,
			Assets.SND_STEP,
			Assets.SND_WATER,
			Assets.SND_OPEN,
			Assets.SND_UNLOCK,
			Assets.SND_ITEM,
			Assets.SND_DEWDROP, 
			Assets.SND_HIT, 
			Assets.SND_MISS,
			Assets.SND_EAT,
			Assets.SND_READ,
			Assets.SND_LULLABY,
			Assets.SND_DRINK,
			Assets.SND_SHATTER,
			Assets.SND_ZAP,
			Assets.SND_LIGHTNING,
			Assets.SND_LEVELUP,
			Assets.SND_DEATH,
			Assets.SND_CHALLENGE,
			Assets.SND_CURSED,
			Assets.SND_EVOKE,
			Assets.SND_TRAP,
			Assets.SND_TOMB,
			Assets.SND_ALERT,
			Assets.SND_MELD,
			Assets.SND_BOSS,
			Assets.SND_BLAST,
			Assets.SND_PLANT,
			Assets.SND_RAY,
			Assets.SND_BEACON,
			Assets.SND_TELEPORT,
			Assets.SND_CHARMS,
			Assets.SND_MASTERY,
			Assets.SND_PUFF,
			Assets.SND_ROCKS,
			Assets.SND_BURNING,
			Assets.SND_FALLING,
			Assets.SND_GHOST,
			Assets.SND_SECRET,
			Assets.SND_BONES,
			Assets.SND_BEE,
			Assets.SND_DEGRADE,
			Assets.SND_MIMIC );
	}
	
	@Override
	public void onWindowFocusChanged( boolean hasFocus ) {
		
		super.onWindowFocusChanged( hasFocus );
		
		if (hasFocus) {
			updateImmersiveMode();
		}
	}
	
	public static void switchNoFade( Class<? extends PixelScene> c ) {
		PixelScene.noFade = true;
		switchScene( c );
	}
	
	/*
	 * ---> Prefernces
	 */
	
	public static void landscape( boolean value ) {
		Game.instance.setRequestedOrientation( value ?
			ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE :
			ActivityInfo.SCREEN_ORIENTATION_PORTRAIT );
		Preferences.INSTANCE.put( Preferences.KEY_LANDSCAPE, value );
	}
	
	public static boolean landscape() {
		return width > height;
	}
	
	// *** IMMERSIVE MODE ****
	
	private static boolean immersiveModeChanged = false;
	
	@SuppressLint("NewApi")
	public static void immerse( boolean value ) {
		Preferences.INSTANCE.put( Preferences.KEY_IMMERSIVE, value );
		
		instance.runOnUiThread( new Runnable() {
			@Override
			public void run() {
				updateImmersiveMode();
				immersiveModeChanged = true;
			}
		} );
	}
	
	@Override
	public void onSurfaceChanged( GL10 gl, int width, int height ) {
		super.onSurfaceChanged( gl, width, height );
		
		if (immersiveModeChanged) {
			requestedReset = true;
			immersiveModeChanged = false;
		}
	}
	
	@SuppressLint("NewApi")
	public static void updateImmersiveMode() {
		if (android.os.Build.VERSION.SDK_INT >= 19) {
			try {
				// Sometime NullPointerException happens here
				instance.getWindow().getDecorView().setSystemUiVisibility( 
					immersed() ?
					View.SYSTEM_UI_FLAG_LAYOUT_STABLE | 
					View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION | 
					View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | 
					View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | 
					View.SYSTEM_UI_FLAG_FULLSCREEN | 
					View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY 
					:
					0 );
			} catch (Exception e) {
				reportException( e );
			}
		}
	}
	
	public static boolean immersed() {
		return Preferences.INSTANCE.getBoolean( Preferences.KEY_IMMERSIVE, false );
	}
	
	// *****************************
	
	public static void scaleUp( boolean value ) {
		Preferences.INSTANCE.put( Preferences.KEY_SCALE_UP, value );
		switchScene( TitleScene.class );
	}
	
	public static boolean scaleUp() {
		return Preferences.INSTANCE.getBoolean( Preferences.KEY_SCALE_UP, true );
	}

	public static void zoom( int value ) {
		Preferences.INSTANCE.put( Preferences.KEY_ZOOM, value );
	}
	
	public static int zoom() {
		return Preferences.INSTANCE.getInt( Preferences.KEY_ZOOM, 0 );
	}
	
	public static void music( boolean value ) {
		Music.INSTANCE.enable( value );
		Preferences.INSTANCE.put( Preferences.KEY_MUSIC, value );
	}
	
	public static boolean music() {
		return Preferences.INSTANCE.getBoolean( Preferences.KEY_MUSIC, true );
	}
	
	public static void soundFx( boolean value ) {
		Sample.INSTANCE.enable( value );
		Preferences.INSTANCE.put( Preferences.KEY_SOUND_FX, value );
	}
	
	public static boolean soundFx() {
		return Preferences.INSTANCE.getBoolean( Preferences.KEY_SOUND_FX, true );
	}

	public static void secondQuickSlot(boolean value) {
		Preferences.INSTANCE.put( Preferences.KEY_SECOND_QUICKSLOT, value );
	}

	public static boolean secondQuickSlot() {
		return Preferences.INSTANCE.getBoolean( Preferences.KEY_SECOND_QUICKSLOT, false );
	}

	public static void nightModeDisabled(boolean value) {
		Preferences.INSTANCE.put( Preferences.KEY_NIGHT_MODE, value );
	}

	public static boolean nightModeDisabled() {
		return Preferences.INSTANCE.getBoolean( Preferences.KEY_NIGHT_MODE, false );
	}

	public static void autoIdentify( boolean value ) {
		Preferences.INSTANCE.put( Preferences.KEY_AUTO_IDENTIFY, value );
	}

	public static boolean autoIdentify() {
		return Preferences.INSTANCE.getBoolean( Preferences.KEY_AUTO_IDENTIFY, false );
	}

	public static void chooseEnchantments( boolean value ) {
		Preferences.INSTANCE.put( Preferences.KEY_CHOOSE_ENCHANTMENTS, value );
	}

	public static boolean chooseEnchantments() {
		return Preferences.INSTANCE.getBoolean( Preferences.KEY_CHOOSE_ENCHANTMENTS, false );
	}

	public static void keepEnchantments( boolean value ) {
		Preferences.INSTANCE.put( Preferences.KEY_KEEP_ENCHANTMENTS, value );
	}

	public static boolean keepEnchantments() {
		return Preferences.INSTANCE.getBoolean( Preferences.KEY_KEEP_ENCHANTMENTS, false );
	}

	public static void upgradeScrolls( boolean value ) {
		Preferences.INSTANCE.put( Preferences.KEY_UPGRADE_SCROLLS, value );
	}

	public static boolean upgradeScrolls() {
		return Preferences.INSTANCE.getBoolean( Preferences.KEY_UPGRADE_SCROLLS, false );
	}

	public static void keepSaveFiles( boolean value ) {
		Preferences.INSTANCE.put( Preferences.KEY_KEEP_SAVE_FILES, value );
	}

	public static boolean keepSaveFiles() {
		return Preferences.INSTANCE.getBoolean( Preferences.KEY_KEEP_SAVE_FILES, false );
	}

	public static void guaranteedBossDrops( boolean value ) {
		Preferences.INSTANCE.put( Preferences.KEY_GUARANTEED_BOSS_DROPS, value );
	}

	public static boolean guaranteedBossDrops() {
		return Preferences.INSTANCE.getBoolean( Preferences.KEY_GUARANTEED_BOSS_DROPS, false );
	}

	public static void freeDewVial( boolean value ) {
		Preferences.INSTANCE.put( Preferences.KEY_FREE_DEW_VIAL, value );
	}

	public static boolean freeDewVial() {
		return Preferences.INSTANCE.getBoolean( Preferences.KEY_FREE_DEW_VIAL, false );
	}

	public static void freeSeedPouch( boolean value ) {
		Preferences.INSTANCE.put( Preferences.KEY_FREE_SEED_POUCH, value );
	}

	public static boolean freeSeedPouch() {
		return Preferences.INSTANCE.getBoolean( Preferences.KEY_FREE_SEED_POUCH, false );
	}

	public static void freeScrollHolder(boolean value) {
		Preferences.INSTANCE.put( Preferences.KEY_FREE_SCROLL_HOLDER, value );
	}

	public static boolean freeScrollHolder() {
		return Preferences.INSTANCE.getBoolean( Preferences.KEY_FREE_SCROLL_HOLDER, false );
	}

	public static void freeWandHolster(boolean value) {
		Preferences.INSTANCE.put( Preferences.KEY_FREE_WAND_HOLSTER, value );
	}

	public static boolean freeWandHolster() {
		return Preferences.INSTANCE.getBoolean( Preferences.KEY_FREE_WAND_HOLSTER, false );
	}

	public static void freeLloydsBeacon(boolean value) {
		Preferences.INSTANCE.put( Preferences.KEY_FREE_LLOYDS_BEACON, value );
	}

	public static boolean freeLloydsBeacon() {
		return Preferences.INSTANCE.getBoolean( Preferences.KEY_FREE_LLOYDS_BEACON, false );
	}

	public static void healingRate( float value ) {
		Preferences.INSTANCE.put( Preferences.KEY_HEALING_RATE, value );
	}

	public static float healingRate() {
		return Preferences.INSTANCE.getFloat( Preferences.KEY_HEALING_RATE, 1.0F );
	}

	public static void hungerRate( float value ) {
		Preferences.INSTANCE.put( Preferences.KEY_HUNGER_RATE, value );
	}

	public static float hungerRate() {
		return Preferences.INSTANCE.getFloat( Preferences.KEY_HUNGER_RATE, 1.0F );
	}

	public static void degradationRate(float value) {
		Preferences.INSTANCE.put( Preferences.KEY_DEGRADATION_RATE, value );
	}

	public static float degradationRate() {
		return Preferences.INSTANCE.getFloat( Preferences.KEY_DEGRADATION_RATE, 1.0F );
	}

	public static void treasureAmount(float value) {
		Preferences.INSTANCE.put( Preferences.KEY_TREASURE_AMOUNT, value );
	}

	public static float treasureAmount() {
		return Preferences.INSTANCE.getFloat( Preferences.KEY_TREASURE_AMOUNT, 1.0F );
	}

	public static void brightness( boolean value ) {
		Preferences.INSTANCE.put( Preferences.KEY_BRIGHTNESS, value );
		if (scene() instanceof GameScene) {
			((GameScene)scene()).brightness( value );
		}
	}
	
	public static boolean brightness() {
		return Preferences.INSTANCE.getBoolean( Preferences.KEY_BRIGHTNESS, false );
	}
	
	public static void donated( String value ) {
		Preferences.INSTANCE.put( Preferences.KEY_DONATED, value );
	}
	
	public static String donated() {
		return Preferences.INSTANCE.getString( Preferences.KEY_DONATED, "" );
	}
	
	public static void lastClass( int value ) {
		Preferences.INSTANCE.put( Preferences.KEY_LAST_CLASS, value );
	}
	
	public static int lastClass() {
		return Preferences.INSTANCE.getInt( Preferences.KEY_LAST_CLASS, 0 );
	}
	
	public static void challenges( int value ) {
		Preferences.INSTANCE.put( Preferences.KEY_CHALLENGES, value );
	}
	
	public static int challenges() {
		return Preferences.INSTANCE.getInt( Preferences.KEY_CHALLENGES, 0 );
	}
	
	public static void intro( boolean value ) {
		Preferences.INSTANCE.put( Preferences.KEY_INTRO, value );
	}
	
	public static boolean intro() {
		return Preferences.INSTANCE.getBoolean( Preferences.KEY_INTRO, true );
	}
	
	/*
	 * <--- Preferences
	 */
	
	public static void reportException( Throwable tr ) {
		Log.e( "PD", Log.getStackTraceString( tr ) ); 
	}
}
