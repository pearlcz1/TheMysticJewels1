
package net.mcreator.themysticjewels.block;

import net.minecraft.block.material.Material;
import net.minecraft.util.SoundEvent;

@ThemysticjewelsModElements.ModElement.Tag
public class DimensionOakPlanksBlock extends ThemysticjewelsModElements.ModElement {

	@ObjectHolder("themysticjewels:dimension_oak_planks")
	public static final Block block = null;

	public DimensionOakPlanksBlock(ThemysticjewelsModElements instance) {
		super(instance, 80);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(TheMysticJewelsItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2f, 3f).setLightLevel(s -> 0).harvestLevel(0)
					.harvestTool(ToolType.AXE).setRequiresTool());

			setRegistryName("dimension_oak_planks");
		}

		@Override
		public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return 15;
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
			return Collections.singletonList(new ItemStack(this, 1));
		}

	}

}
