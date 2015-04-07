package azuxul.morelight.client;

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EnumPlayerModelParts;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class Cape implements LayerRenderer {

    private final RenderPlayer playerRenderer;
	
    public Cape(RenderPlayer p_i46123_1_) {
    	
        this.playerRenderer = p_i46123_1_;
    }
	
	public void doRenderLayer(AbstractClientPlayer player, float p_177166_2_, float p_177166_3_, float p_177166_4_, float p_177166_5_, float p_177166_6_, float p_177166_7_, float p_177166_8_) {
		
		if (player.hasPlayerInfo() && !player.isInvisible() && player.func_175148_a(EnumPlayerModelParts.CAPE)) {
			
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            this.playerRenderer.bindTexture(new ResourceLocation("morelight:layer/AzuxulCape.png"));
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0F, 0.0F, 0.125F);
            double d0 = player.field_71091_bM + (player.field_71094_bP - player.field_71091_bM) * p_177166_4_ - (player.prevPosX + (player.posX - player.prevPosX) * p_177166_4_);
            double d1 = player.field_71096_bN + (player.field_71095_bQ - player.field_71096_bN) * p_177166_4_ - (player.prevPosY + (player.posY - player.prevPosY) * p_177166_4_);
            double d2 = player.field_71097_bO + (player.field_71085_bR - player.field_71097_bO) * p_177166_4_ - (player.prevPosZ + (player.posZ - player.prevPosZ) * p_177166_4_);
            float f7 = player.prevRenderYawOffset + (player.renderYawOffset - player.prevRenderYawOffset) * p_177166_4_;
            double d3 = MathHelper.sin(f7 * (float)Math.PI / 180.0F);
            double d4 = (-MathHelper.cos(f7 * (float)Math.PI / 180.0F));
            float f8 = (float)d1 * 10.0F;
            f8 = MathHelper.clamp_float(f8, -6.0F, 32.0F);
            float f9 = (float)(d0 * d3 + d2 * d4) * 100.0F;
            float f10 = (float)(d0 * d4 - d2 * d3) * 100.0F;

            if (f9 < 0.0F) {
            	
                f9 = 0.0F;
            }

            float f11 = player.prevCameraYaw + (player.cameraYaw - player.prevCameraYaw) * p_177166_4_;
            f8 += MathHelper.sin((player.prevDistanceWalkedModified + (player.distanceWalkedModified - player.prevDistanceWalkedModified) * p_177166_4_) * 6.0F) * 32.0F * f11;

            if (player.isSneaking()) {
            	
                f8 += 25.0F;
            }

            GlStateManager.rotate(6.0F + f9 / 2.0F + f8, 1.0F, 0.0F, 0.0F);
            GlStateManager.rotate(f10 / 2.0F, 0.0F, 0.0F, 1.0F);
            GlStateManager.rotate(-f10 / 2.0F, 0.0F, 1.0F, 0.0F);
            GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
            this.playerRenderer.getPlayerModel().func_178728_c(0.0625F);
            GlStateManager.popMatrix();
            
        }
    }
	
	@Override
	public boolean shouldCombineTextures() {
		
        return false;
    }

    @Override
	public void doRenderLayer(EntityLivingBase p_177141_1_, float p_177141_2_, float p_177141_3_, float p_177141_4_, float p_177141_5_, float p_177141_6_, float p_177141_7_, float p_177141_8_) {
    	
        this.doRenderLayer((AbstractClientPlayer)p_177141_1_, p_177141_2_, p_177141_3_, p_177141_4_, p_177141_5_, p_177141_6_, p_177141_7_, p_177141_8_);
    }

}
