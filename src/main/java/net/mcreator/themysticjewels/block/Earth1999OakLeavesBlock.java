
package net.mcreator.themysticjewels.block;

import net.minecraft.block.material.Material;
import net.minecraft.util.SoundEvent;

@ThemysticjewelsModElements.ModElement.Tag
public class Earth1999OakLeavesBlock extends ThemysticjewelsModElements.ModElement {

	@ObjectHolder("themysticjewels:earth_1999_oak_leaves")
	public static final Block block = null;

	public Earth1999OakLeavesBlock(ThemysticjewelsModElements instance) {
		super(instance, 61);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.DECORATIONS)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends LeavesBlock {

		public CustomBlock() {
			super(Block.Properties.create(Material.LEAVES).sound(SoundType.PLANT).hardnessAndResistance(0.2f, 0.2f).setLightLevel(s -> 0).notSolid());

			setRegistryName("earth_1999_oak_leaves");
		}

		@Override
		public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return 1;
		}

		@Override
		public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
			return 30;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}

	}

}
