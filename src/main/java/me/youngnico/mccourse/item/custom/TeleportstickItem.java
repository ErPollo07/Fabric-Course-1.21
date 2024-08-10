package me.youngnico.mccourse.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TeleportstickItem extends Item {

    public TeleportstickItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        if (!world.isClient()) {
            HitResult hit = user.raycast(4, 1, true);

            int x = (int) Math.round(hit.getPos().getX());
            int y = (int) Math.round(hit.getPos().getY());
            int z = (int) Math.round(hit.getPos().getZ());

            if (isValidPos(world, x, y, z)) {
                user.requestTeleport(hit.getPos().getX(), hit.getPos().getY(), hit.getPos().getZ());
            }
        }

        return new TypedActionResult<ItemStack>(ActionResult.SUCCESS, PlayerEntity.getSlotForHand(hand).split(getDefaultStack()));
    }

    private boolean isValidPos(World world, int x, int y, int z) {
        return !world.getBlockState(new BlockPos(x, y-1, z)).isAir() &&
                world.getBlockState(new BlockPos(x, y+1, z)).isAir() &&
                world.getBlockState(new BlockPos(x, y+2, z)).isAir();
    }
}
