package com.watabou.pixeldungeon.items.bags;

import com.watabou.pixeldungeon.items.Item;
import com.watabou.pixeldungeon.items.potions.Potion;
import com.watabou.pixeldungeon.sprites.ItemSpriteSheet;

/**
 * Created by keithr on 1/20/16.
 */
public class PotionBag extends Bag {

	{
		name = "potion bag";
		image = ItemSpriteSheet.POTION_BAG;

		size = 12;
	}

	@Override
	public boolean grab( Item item ) {
		return item instanceof Potion;
	}

	@Override
	public int price() {
		return 50;
	}

	@Override
	public String info() {
		return
			"This is a leather bag that lets you keep all your potions " +
				"separately from the rest of your belongings.";
	}
}
