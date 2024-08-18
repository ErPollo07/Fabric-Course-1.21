package me.youngnico.mccourse.item.custom;

import me.youngnico.mccourse.util.Util;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ShooterItem extends Item {
    private static final int fireballExplosionStrenght = 3;

    public ShooterItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        HitResult hit = user.raycast(10, 0, true);

        BlockHitResult blockHit = ((BlockHitResult) hit);

        BlockPos playerBlockPos = user.getBlockPos();
        BlockPos endPos = blockHit.getBlockPos();

        Vec3d playerPos = new Vec3d(
                playerBlockPos.getX(),
                playerBlockPos.getY() + 1,
                playerBlockPos.getZ()
        );

        Vec3d currentPos = new Vec3d(
                playerPos.getX(),
                (playerPos.getY() + 1),
                playerPos.getZ()
        );

        double distance = Math.sqrt(Math.pow(endPos.getX() - playerPos.getX(), 2) + Math.pow(endPos.getY() - playerPos.getY(), 2) + Math.pow(endPos.getZ() - playerPos.getZ(), 2));

        for (int i = 0; i < distance; i++) {
            world.addParticle(new DustParticleEffect(DustParticleEffect.RED, 1),
                    playerPos.getX() + Util.getDirection(user).getX() * i,
                    playerPos.getY() + Util.getDirection(user).getY() * i,
                    playerPos.getZ() + Util.getDirection(user).getZ() * i,
                    0, 0, 0
            );
        }

        world.breakBlock(blockHit.getBlockPos(), true);


        return new TypedActionResult<ItemStack>(ActionResult.CONSUME, PlayerEntity.getSlotForHand(hand).split(getDefaultStack()));
    }

    public double updatePos(double firstArg, double gap, double endPos) {
        if (firstArg >= endPos) {
            return firstArg - gap;
        } else if (firstArg < endPos) {
            return firstArg + gap;
        }

        return 0;
    }
}
