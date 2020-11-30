package space.essem.oil.fluid;

import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import space.essem.oil.Oil;

public abstract class OilFluid extends ModdedFluid
{
  @Override
  public Fluid getStill()
  {
    return Oil.STILL_OIL;
  }
 
  @Override
  public Fluid getFlowing()
  {
    return Oil.FLOWING_OIL;
  }
 
  @Override
  public Item getBucketItem()
  {
    return Oil.OIL_BUCKET;
  }
 
  @Override
  protected BlockState toBlockState(FluidState fluidState)
  {
    // method_15741 converts the LEVEL_1_8 of the fluid state to the LEVEL_15 the fluid block uses
    return Oil.OIL.getDefaultState().with(Properties.LEVEL_15, method_15741(fluidState));
  }
 
  public static class Flowing extends OilFluid
  {
    @Override
    protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder)
    {
      super.appendProperties(builder);
      builder.add(LEVEL);
    }
 
    @Override
    public int getLevel(FluidState fluidState)
    {
      return fluidState.get(LEVEL);
    }
 
    @Override
    public boolean isStill(FluidState fluidState)
    {
      return false;
    }
  }
 
  public static class Still extends OilFluid
  {
    @Override
    public int getLevel(FluidState fluidState)
    {
      return 8;
    }
 
    @Override
    public boolean isStill(FluidState fluidState)
    {
      return true;
    }
  }
}