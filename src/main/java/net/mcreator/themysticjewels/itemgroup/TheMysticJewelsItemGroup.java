
package net.mcreator.themysticjewels.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.themysticjewels.item.JewelBoxItem;
import net.mcreator.themysticjewels.ThemysticjewelsModElements;

@ThemysticjewelsModElements.ModElement.Tag
public class TheMysticJewelsItemGroup extends ThemysticjewelsModElements.ModElement {
	public TheMysticJewelsItemGroup(ThemysticjewelsModElements instance) {
		super(instance, 10);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabthe_mystic_jewels") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(JewelBoxItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
