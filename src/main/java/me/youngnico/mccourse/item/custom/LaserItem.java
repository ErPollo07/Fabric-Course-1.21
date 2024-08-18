package me.youngnico.mccourse.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class LaserItem extends FireballEntity {

    private int numberOfCollision = 0;

    public LaserItem(World world, LivingEntity owner, Vec3d velocity) {
        super(world, owner, velocity, 0);
    }

    @Override
    protected void onCollision(HitResult hitResult) {

        if (hitResult.getType() == HitResult.Type.BLOCK) {

            if (numberOfCollision >= 100) {
                this.kill();
            }

            numberOfCollision++;

            BlockHitResult blockHit = (BlockHitResult) hitResult;

            this.getWorld().breakBlock(blockHit.getBlockPos(), false);
        }
    }
}
