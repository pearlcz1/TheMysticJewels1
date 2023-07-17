
package net.mcreator.themysticjewels.gui;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.themysticjewels.ThemysticjewelsMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class DimensionsGuiWindow extends ContainerScreen<DimensionsGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = DimensionsGui.guistate;
	public DimensionsGuiWindow(DimensionsGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 166;
	}
	private static final ResourceLocation texture = new ResourceLocation("themysticjewels:textures/dimensions.png");
	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		Minecraft.getInstance().getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.blit(ms, k, l, 0, 0, this.xSize, this.ySize, this.xSize, this.ySize);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "Select dimension", 46, 10, -16777216);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		minecraft.keyboardListener.enableRepeatEvents(true);
		this.addButton(new Button(this.guiLeft + 5, this.guiTop + 27, 50, 20, new StringTextComponent("Earth"), e -> {
			if (true) {
				ThemysticjewelsMod.PACKET_HANDLER.sendToServer(new DimensionsGui.ButtonPressedMessage(0, x, y, z));
				DimensionsGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 5, this.guiTop + 57, 55, 20, new StringTextComponent("Nether"), e -> {
			if (true) {
				ThemysticjewelsMod.PACKET_HANDLER.sendToServer(new DimensionsGui.ButtonPressedMessage(1, x, y, z));
				DimensionsGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 6, this.guiTop + 87, 40, 20, new StringTextComponent("End"), e -> {
			if (true) {
				ThemysticjewelsMod.PACKET_HANDLER.sendToServer(new DimensionsGui.ButtonPressedMessage(2, x, y, z));
				DimensionsGui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 6, this.guiTop + 112, 85, 20, new StringTextComponent("Demon Forest"), e -> {
			if (true) {
				ThemysticjewelsMod.PACKET_HANDLER.sendToServer(new DimensionsGui.ButtonPressedMessage(3, x, y, z));
				DimensionsGui.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 6, this.guiTop + 137, 65, 20, new StringTextComponent(" Camelot"), e -> {
			if (true) {
				ThemysticjewelsMod.PACKET_HANDLER.sendToServer(new DimensionsGui.ButtonPressedMessage(4, x, y, z));
				DimensionsGui.handleButtonAction(entity, 4, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 69, this.guiTop + 27, 75, 20, new StringTextComponent("Earth-1999"), e -> {
			if (true) {
				ThemysticjewelsMod.PACKET_HANDLER.sendToServer(new DimensionsGui.ButtonPressedMessage(5, x, y, z));
				DimensionsGui.handleButtonAction(entity, 5, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 69, this.guiTop + 55, 85, 20, new StringTextComponent("Dimesion-616"), e -> {
			if (true) {
				ThemysticjewelsMod.PACKET_HANDLER.sendToServer(new DimensionsGui.ButtonPressedMessage(6, x, y, z));
				DimensionsGui.handleButtonAction(entity, 6, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 56, this.guiTop + 87, 75, 20, new StringTextComponent("Multiverse"), e -> {
			if (true) {
				ThemysticjewelsMod.PACKET_HANDLER.sendToServer(new DimensionsGui.ButtonPressedMessage(7, x, y, z));
				DimensionsGui.handleButtonAction(entity, 7, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 77, this.guiTop + 138, 80, 20, new StringTextComponent("Nether-5070"), e -> {
			if (true) {
				ThemysticjewelsMod.PACKET_HANDLER.sendToServer(new DimensionsGui.ButtonPressedMessage(8, x, y, z));
				DimensionsGui.handleButtonAction(entity, 8, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 101, this.guiTop + 112, 55, 20, new StringTextComponent("Reveal"), e -> {
			if (true) {
				ThemysticjewelsMod.PACKET_HANDLER.sendToServer(new DimensionsGui.ButtonPressedMessage(9, x, y, z));
				DimensionsGui.handleButtonAction(entity, 9, x, y, z);
			}
		}));
	}
}
