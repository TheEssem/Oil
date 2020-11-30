package space.essem.oil.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;

public class OilEffect extends StatusEffect {
  public OilEffect() {
    super(StatusEffectType.BENEFICIAL, 0x615533);
  }
 
  // This method is called every tick to check weather it should apply the status effect or not
  @Override
  public boolean canApplyUpdateEffect(int duration, int amplifier) {
    // In our case, we just make it return true so that it applies the status effect every tick.
    return true;
  }
 
  // This method is called when it applies the status effect. We implement custom functionality here.
  @Override
  public void applyUpdateEffect(LivingEntity entity, int amplifier) {
    if (entity.world.isRaining() && entity.world.isSkyVisible(entity.getBlockPos())) {
      entity.setVelocity(entity.getVelocity().x, 2, entity.getVelocity().z);
    }
  }
}
