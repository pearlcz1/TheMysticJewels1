
package net.mcreator.themysticjewels.item;

public class CamelotyItem extends Item {

	@ObjectHolder("themysticjewels:cameloty")
	public static final Item block = null;

	public CamelotyItem() {
		super(new Item.Properties().group(TheMysticJewelsItemGroup.tab).maxDamage(64));
	}

	@Override
	public ActionResultType onItemUse(ItemUseContext context) {
		PlayerEntity entity = context.getPlayer();
		BlockPos pos = context.getPos().offset(context.getFace());
		ItemStack itemstack = context.getItem();
		World world = context.getWorld();
		if (!entity.canPlayerEdit(pos, context.getFace(), itemstack)) {
			return ActionResultType.FAIL;
		} else {
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			boolean success = false;

			if (world.isAirBlock(pos) && true) {
				CamelotyDimension.portal.portalSpawn(world, pos);
				itemstack.damageItem(1, entity, c -> c.sendBreakAnimation(context.getHand()));
				success = true;
			}

			return success ? ActionResultType.SUCCESS : ActionResultType.FAIL;
		}
	}
}
