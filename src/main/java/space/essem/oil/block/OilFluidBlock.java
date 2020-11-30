package space.essem.oil.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import space.essem.oil.Oil;

public class OilFluidBlock extends FluidBlock {
  public OilFluidBlock(FlowableFluid fluid, AbstractBlock.Settings settings) {
    super(fluid, settings);
  }

  @Override
  public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
    if (entity instanceof LivingEntity) {
      ((LivingEntity)entity).addStatusEffect(new StatusEffectInstance(Oil.OIL_EFFECT, 1200));
    }
  }
}
