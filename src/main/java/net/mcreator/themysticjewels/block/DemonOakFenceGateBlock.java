
package net.mcreator.themysticjewels.block;

import net.minecraft.block.material.Material;
import net.minecraft.util.SoundEvent;

@ThemysticjewelsModElements.ModElement.Tag
public class DemonOakFenceGateBlock extends ThemysticjewelsModElements.ModElement {

	@ObjectHolder("themysticjewels:demon_oak_fence_gate")
	public static final Block block = null;

	public DemonOakFenceGateBlock(ThemysticjewelsModElements instance) {
		super(instance, 21);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.REDSTONE)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends FenceGateBlock {

		public CustomBlock() {
			super(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2f, 3f).setLightLevel(s -> 0));

			setRegistryName("demon_oak_fence_gate");
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
