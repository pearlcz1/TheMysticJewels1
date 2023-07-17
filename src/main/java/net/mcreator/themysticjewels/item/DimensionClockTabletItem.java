
package net.mcreator.themysticjewels.item;

@ThemysticjewelsModElements.ModElement.Tag
public class DimensionClockTabletItem extends ThemysticjewelsModElements.ModElement {

	@ObjectHolder("themysticjewels:dimension_clock_tablet")
	public static final Item block = null;

	public DimensionClockTabletItem(ThemysticjewelsModElements instance) {
		super(instance, 12);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("dimension_clock_tablet");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

	}

}
