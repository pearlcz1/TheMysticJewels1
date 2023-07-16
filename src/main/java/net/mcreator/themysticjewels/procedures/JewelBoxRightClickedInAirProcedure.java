package net.mcreator.themysticjewels.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.themysticjewels.item.JewelBoxItem;
import net.mcreator.themysticjewels.block.JeweleryBoxBlock;
import net.mcreator.themysticjewels.ThemysticjewelsMod;

import java.util.Map;

public class JewelBoxRightClickedInAirProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ThemysticjewelsMod.LOGGER.warn("Failed to load dependency entity for procedure JewelBoxRightClickedInAir!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ThemysticjewelsMod.LOGGER.warn("Failed to load dependency x for procedure JewelBoxRightClickedInAir!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ThemysticjewelsMod.LOGGER.warn("Failed to load dependency y for procedure JewelBoxRightClickedInAir!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ThemysticjewelsMod.LOGGER.warn("Failed to load dependency z for procedure JewelBoxRightClickedInAir!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ThemysticjewelsMod.LOGGER.warn("Failed to load dependency world for procedure JewelBoxRightClickedInAir!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(JewelBoxItem.block)) : false)) {
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(JewelBoxItem.block);
				((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
						((PlayerEntity) entity).container.func_234641_j_());
			}
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), JeweleryBoxBlock.block.getDefaultState(), 3);
		}
	}
}
