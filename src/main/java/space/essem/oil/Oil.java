package space.essem.oil;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import space.essem.oil.block.OilFluidBlock;
import space.essem.oil.effect.OilEffect;
import space.essem.oil.fluid.OilFluid;

public class Oil implements ModInitializer {
	public static String MOD_ID = "oil";
	public static FlowableFluid STILL_OIL;
	public static FlowableFluid FLOWING_OIL;

	public static Item OIL_BUCKET;

	public static Block OIL;

	public static StatusEffect OIL_EFFECT;

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		System.out.println("Covering self in oil...");
		STILL_OIL = Registry.register(Registry.FLUID, new Identifier(MOD_ID, "oil"), new OilFluid.Still());
 
		FLOWING_OIL = Registry.register(Registry.FLUID, new Identifier(MOD_ID, "flowing_oil"), new OilFluid.Flowing());
	 
		OIL_BUCKET = Registry.register(Registry.ITEM, new Identifier(MOD_ID, "oil_bucket"), new BucketItem(STILL_OIL, new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1)));

		OIL = Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "oil"), new OilFluidBlock(STILL_OIL, FabricBlockSettings.copy(Blocks.WATER)){});

		OIL_EFFECT = Registry.register(Registry.STATUS_EFFECT, new Identifier(MOD_ID, "oil_effect"), new OilEffect());
	}
}
