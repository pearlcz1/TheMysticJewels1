
package net.mcreator.themysticjewels.block;

import net.minecraft.block.material.Material;
import net.minecraft.util.SoundEvent;

@ThemysticjewelsModElements.ModElement.Tag
public class CamelotOakSlabBlock extends ThemysticjewelsModElements.ModElement {

	@ObjectHolder("themysticjewels:camelot_oak_slab")
	public static final Block block = null;

	public CamelotOakSlabBlock(ThemysticjewelsModElements instance) {
		super(instance, 43);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(TheMysticJewelsItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends SlabBlock {

		public CustomBlock() {
			super(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2f, 3f).setLightLevel(s -> 0));

			setRegistryName("camelot_oak_slab");
		}

		@Override
		public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
			return 5;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, state.get(TYPE) == SlabType.DOUBLE ? 2 : 1));
		}

	}

}
