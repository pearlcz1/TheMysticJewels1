package net.mcreator.themysticjewels.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.themysticjewels.item.DimesionalClockItem;
import net.mcreator.themysticjewels.item.DimensionalClockCamoItem;
import net.mcreator.themysticjewels.ThemysticjewelsMod;

import java.util.Map;

public class DimesionalClockRightClickedInAirProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ThemysticjewelsMod.LOGGER.warn("Failed to load dependency entity for procedure DimesionalClockRightClickedInAir!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(DimesionalClockItem.block)) : false)) {
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(DimesionalClockItem.block);
				((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
						((PlayerEntity) entity).container.func_234641_j_());
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(DimensionalClockCamoItem.block);
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
		}
	}
}
