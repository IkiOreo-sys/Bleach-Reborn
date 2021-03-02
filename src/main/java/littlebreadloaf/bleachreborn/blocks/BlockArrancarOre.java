package littlebreadloaf.bleachreborn.blocks;

import java.util.Random;

import littlebreadloaf.bleachreborn.items.BleachItems;
import net.minecraft.block.BlockOre;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class BlockArrancarOre extends BlockOre {
	
	public BlockArrancarOre() {
		this.setHardness(7.0f);
		this.setResistance(7.0f);
		this.setHarvestLevel("pickaxe", 3);
		this.setLightLevel(1);
	}
	
	@Override
	public Item getItemDropped(int metadata, Random rand, int fortuneLevel) {
		Item item=BleachItems.arrancaressence;
		return item;
	}

}
